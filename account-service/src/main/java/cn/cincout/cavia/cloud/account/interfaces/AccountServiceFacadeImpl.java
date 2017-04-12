package cn.cincout.cavia.cloud.account.interfaces;

import cn.cincout.cavia.cloud.account.api.dto.account.AccountDto;
import cn.cincout.cavia.cloud.account.application.service.account.AccountService;
import cn.cincout.cavia.cloud.account.domain.account.Account;
import cn.cincout.cavia.cloud.account.api.service.AccountServiceFacade;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-4-8
 * @sine 1.8
 */
@Service(version = "1.0")
public class AccountServiceFacadeImpl implements AccountServiceFacade {

    @Autowired
    private AccountService accountService;

    @Override
    public AccountDto getById(long id) {
        return DtoAdapter.toDto(accountService.getById(id));
    }

    @Override
    public AccountDto getByName(String name) {
        return DtoAdapter.toDto(accountService.getByName(name));
    }

    @Override
    public AccountDto getByEmail(String email) {
        return DtoAdapter.toDto(accountService.getByEmail(email));
    }

    @Override
    public AccountDto getByPhoneNumber(String phoneNumber) {
        return DtoAdapter.toDto(accountService.getByPhoneNumber(phoneNumber));
    }

    @Override
    public List<AccountDto> getByNameOrEmailLike(String keyword) {
        return DtoAdapter.toAccountDtoList(accountService.getByNameOrEmailLike(keyword));
    }

    @Override
    public AccountDto save(AccountDto accountDto) {
        Account account = accountService.save(DtoAdapter.toDomain(accountDto));
        return DtoAdapter.toDto(account);
    }

    @Override
    public AccountDto delete(long id) {
        return DtoAdapter.toDto(accountService.delete(id));
    }
}
