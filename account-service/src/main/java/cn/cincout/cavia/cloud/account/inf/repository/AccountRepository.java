package cn.cincout.cavia.cloud.account.inf.repository;

import cn.cincout.cavia.cloud.account.domain.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-4-8
 * @sine 1.8
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query(value = "select account from Account account where account.name = ?1")
    Account findByName(String name);

    @Query(value = "select account from Account account where account.email = ?1")
    Account findByEmail(String email);

    @Query(value = "select account from Account account where account.phoneNumber = ?1")
    Account findByPhoneNumber(String phoneNumber);

    @Query(value = "select account from Account account where account.name like %:keyword% or account.email like %:keyword%")
    List<Account> findByNameOrEmailLike(@Param("keyword") String keyWord);

}
