package cn.cincout.cavia.cloud.account.application.service.crypto;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-4-9
 * @sine 1.8
 */
public interface CryptoService {
    String encrypt(String plainText, String key);
    String decrypt(String content, String key);
}
