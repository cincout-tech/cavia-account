package cn.cincout.cavia.cloud.account.application.service.account;

import cn.cincout.cavia.cloud.account.domain.account.Account;

import java.util.List;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-4-8
 * @sine 1.8
 */
public interface AccountService {
    Account getById(long id);
    Account getByName(String name);
    Account getByEmail(String email);
    Account getByPhoneNumber(String phoneNumber);
    List<Account> getByNameOrEmailLike(String keyword);

    Account save(Account account);
    Account delete(long id);

    long totalAccounts();
}
