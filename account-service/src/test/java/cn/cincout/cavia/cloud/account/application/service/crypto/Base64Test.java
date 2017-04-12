package cn.cincout.cavia.cloud.account.application.service.crypto;

import org.junit.Test;
import org.springframework.util.Base64Utils;

import java.io.UnsupportedEncodingException;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-4-12
 * @sine 1.8
 */
public class Base64Test {
    @Test
    public void base64Test() throws UnsupportedEncodingException {
        String encodeString = Base64Utils.encodeToString("zhangzhaoyu".getBytes("utf-8"));
        System.out.println(encodeString);

        System.out.println(new String(Base64Utils.decodeFromString(encodeString), "utf-8"));
    }

    @Test
    public void base64Test2() throws UnsupportedEncodingException {
        String encodeString = Base64Utils.encodeToString("zhangzhaoyu".getBytes("utf-8"));
        System.out.println(encodeString);

        System.out.println(new String(Base64Utils.decodeFromString(encodeString), "utf-8"));
    }
}
