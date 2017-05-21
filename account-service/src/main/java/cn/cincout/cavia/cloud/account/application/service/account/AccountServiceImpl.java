package cn.cincout.cavia.cloud.account.application.service.account;

import cn.cincout.cavia.cloud.account.domain.account.Account;
import cn.cincout.cavia.cloud.account.inf.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-4-8
 * @sine 1.8
 */
@Service
public class AccountServiceImpl implements AccountService {
    private final static Logger LOG = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account getById(long id) {
        return accountRepository.findOne(id);
    }

    @Override
    public Account getByName(String name) {
        return accountRepository.findByName(name);
    }

    @Override
    public Account getByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    @Override
    public Account getByPhoneNumber(String phoneNumber) {
        return accountRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public List<Account> getByNameOrEmailLike(String keyword) {
        LOG.debug("keyword is {}.", keyword);
        return accountRepository.findByNameOrEmailLike(keyword);
    }

    @Override
    public Account save(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        LOG.debug("password was encoded.");
        return accountRepository.save(account);
    }

    @Override
    @Transactional
    public Account delete(long id) {
        Account account = getById(id);
        account.setEnable(Boolean.FALSE);
        return account;
    }
}
