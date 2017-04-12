package cn.cincout.cavia.cloud.account.application.service.crypto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-4-9
 * @sine 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CryptoServiceImplTest {
    private final static Logger LOG = LoggerFactory.getLogger(CryptoServiceImplTest.class);

    private String key = "caviaxcv";
    private String content = "hello world";

    @Autowired
    private CryptoService cryptoService;

    @Test
    public void encrypt() throws Exception {
        String result = cryptoService.encrypt(content, key);
        System.out.println("-x-" + result);
        String val = cryptoService.decrypt(result, key);
        System.out.println(val);
    }

    @Test
    public void decrypt() throws Exception {

    }
}