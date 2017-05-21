package cn.cincout.cavia.cloud.account.interfaces;

import cn.cincout.cavia.cloud.account.api.dto.account.AccountDto;
import cn.cincout.cavia.cloud.account.api.service.AccountServiceFacade;
import cn.cincout.cavia.cloud.account.application.factory.JsonObjectMapperFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-4-13
 * @sine 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceFacadeImplTest {

    @Autowired
    private AccountServiceFacade accountServiceFacade;

    @Bean
    private AccountServiceFacade accountServiceFacade() {
        return new AccountServiceFacadeImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Before
    public void setUp() throws Exception {
        Assert.assertNotNull(accountServiceFacade);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Ignore
    public void getById() throws Exception {

    }

    @Ignore
    public void getByName() throws Exception {

    }

    @Test
    public void getByEmail() throws Exception {
        String email = "zhangzhaoyu@cincout.cn";
        AccountDto accountDto = accountServiceFacade.getByEmail(email);
        Assert.assertEquals(email, accountDto.getEmail());
    }

    @Ignore
    public void getByPhoneNumber() throws Exception {

    }

    @Ignore
    public void getByNameOrEmailLike() throws Exception {

    }

    @Test
    public void save() throws Exception {
        AccountDto accountDto = AccountDto.builder()
                .email("zhangzhaoyu@cincout.cn")
                .enable(Boolean.TRUE)
                .phoneNumber("18511929810")
                .name("zhangzhaoyu")
                .password("123456")
                .createdDate(System.currentTimeMillis())
                .build();

        accountDto = accountServiceFacade.save(accountDto);
        System.out.println(accountDto.getId());
        Assert.assertNotNull(accountDto.getId());
    }

    @Ignore
    public void update() throws JsonProcessingException {
        AccountDto accountDto = accountServiceFacade.getByEmail("zhangzhaoyu@cincout.cn");
        accountDto.setPassword("123456");
        accountDto.setCreatedDate(System.currentTimeMillis());

        accountDto = accountServiceFacade.save(accountDto);
        System.out.println(JsonObjectMapperFactory.MAPPER.instance().writeValueAsString(accountDto));
    }

    @Ignore
    public void delete() throws Exception {

    }

}