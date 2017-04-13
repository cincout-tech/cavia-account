package cn.cincout.cavia.cloud.api.account.service;

import cn.cincout.cavia.cloud.api.account.dto.account.AccountDto;

import java.util.List;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-4-3
 * @sine 1.8
 */
public interface AccountServiceFacade {
    AccountDto getById(long id);
    AccountDto getByName(String name);
    AccountDto getByEmail(String email);
    AccountDto getByPhoneNumber(String phoneNumber);
    List<AccountDto> getByNameOrEmailLike(String keyword);

    AccountDto save(AccountDto accountDto);
    AccountDto delete(long id);
}
