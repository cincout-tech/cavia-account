package cn.cincout.cavia.cloud.account.application.service.crypto;

import cn.cincout.cavia.cloud.account.api.dto.account.AccountDto;
import cn.cincout.cavia.cloud.account.domain.account.Account;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-4-12
 * @sine 1.8
 */
public class BeanUtilsTest {
    @Test
    public void testCopy() {
        Account account = new Account(1L, "name", "email@gmail.com", "18511929811", "xx", true, System.currentTimeMillis());
        AccountDto dto = new AccountDto();
        BeanUtils.copyProperties(account, dto);
        System.out.println(dto);
    }
}
