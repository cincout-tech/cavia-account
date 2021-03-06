package cn.cincout.cavia.cloud.account.controller;

import cn.cincout.cavia.cloud.account.api.dto.account.AccountDto;
import cn.cincout.cavia.cloud.account.api.service.AccountServiceFacade;
import cn.cincout.cavia.cloud.account.vo.AccountVo;
import cn.cincout.cavia.cloud.account.vo.HttpMessage;
import cn.cincout.cavia.cloud.account.vo.VoAdapter;
import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-3-17
 * @sine 1.8
 */

@Controller
@RequestMapping(value = "/api")
//@CrossOrigin
public class AccountController {
    private final static Logger LOG = LoggerFactory.getLogger(AccountController.class);

    @Reference(version = "1.0")
    private AccountServiceFacade accountServiceFacade;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @ApiOperation(value = "login")
    //@ApiImplicitParam(name = "accountVo", value = "account login info", required = true, dataType = "cn.cincout.cavia.cloud.account.vo.AccountVo")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public HttpMessage<AccountDto> login(@RequestBody AccountVo accountVo) {
        LOG.info(accountVo.toString());
        AccountDto accountDto = accountServiceFacade.getByEmail(accountVo.getEmail());
        if (accountDto == null) {
            return new HttpMessage<>(HttpStatus.NOT_FOUND, null, new HttpMessage.Msg(404, "user not exits."));
        }
        if (passwordEncoder.matches(accountVo.getPassword(), accountDto.getPassword())) {
            return new HttpMessage<>(
                    HttpStatus.OK,
                    accountDto,
                    new HttpMessage.Msg(1000, "login success.")
            );
        } else {
            return new HttpMessage<>(
                    HttpStatus.BAD_REQUEST,
                    null,
                    new HttpMessage.Msg(1000, "password error.")
            );
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<AccountDto> register(@RequestBody AccountVo accountVo) {
        LOG.debug("register user {}.", accountVo.getEmail());
        AccountDto accountDto = VoAdapter.toDto(accountVo);
        accountDto = accountServiceFacade.save(accountDto);
        return new ResponseEntity<>(accountDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<AccountDto> search(@RequestParam(name = "userName", required = false) String userName,
                                             @RequestParam(name = "phoneNumber", required = false) String phoneNumber,
                                             @RequestParam(name = "email", required = false) String email) {
        AccountDto accountDto = null;
        if (StringUtils.isNotBlank(userName)) {
            accountDto = accountServiceFacade.getByName(userName);
            if (accountDto != null) {
                return new ResponseEntity<>(accountDto, HttpStatus.CONFLICT);
            }
            else {
                return new ResponseEntity<>(accountDto, HttpStatus.NOT_FOUND);
            }
        }
        else if (StringUtils.isNotBlank(phoneNumber)) {
            accountDto = accountServiceFacade.getByPhoneNumber(phoneNumber);
            if (accountDto != null) {
                return new ResponseEntity<>(accountDto, HttpStatus.CONFLICT);
            }
            else {
                return new ResponseEntity<>(accountDto, HttpStatus.NOT_FOUND);
            }
        }

        else if (StringUtils.isNotBlank(email)) {
            accountDto = accountServiceFacade.getByEmail(email);
            if (accountDto != null) {
                return new ResponseEntity<>(accountDto, HttpStatus.CONFLICT);
            }
            else {
                return new ResponseEntity<>(accountDto, HttpStatus.NOT_FOUND);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
}


