package cn.cincout.cavia.cloud.account.application.factory;

import cn.cincout.cavia.cloud.account.application.service.crypto.CryptoService;
import cn.cincout.cavia.cloud.account.domain.order.HashCode;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-4-11
 * @sine 1.8
 */
@Service
public class HashCodeFactory implements HashCodeBuilder {
    private final static Logger LOG = LoggerFactory.getLogger(HashCodeFactory.class);

    @Autowired
    private CryptoService cryptoService;

    @Override
    public HashCode build(long accountId, long expireIn) {
        try {
            String plainText = JsonObjectMapperFactory
                    .MAPPER.instance().writeValueAsString(HashCode.getMap(accountId, expireIn));
            String encryptText = cryptoService.encrypt(plainText, String.valueOf(accountId));
            return HashCode.builder()
                    .accountId(accountId)
                    .expireIn(expireIn)
                    .cryptoText(encryptText)
                    .build();
        } catch (JsonProcessingException e) {
            LOG.error("json mapper error {}.", e.getMessage());
        }
        return null;
    }

    @Override
    public List<HashCode> build(long accountId, long expireIn, int size) {
        if (size < 1) {
            throw new IllegalArgumentException("size is illegal argument, value is " + size);
        }
        List<HashCode> hashCodes = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            hashCodes.add(build(accountId, expireIn));
        }
        return hashCodes;
    }
}
