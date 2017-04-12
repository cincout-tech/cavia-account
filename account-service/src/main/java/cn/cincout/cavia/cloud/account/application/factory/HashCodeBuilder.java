package cn.cincout.cavia.cloud.account.application.factory;

import cn.cincout.cavia.cloud.account.domain.order.HashCode;

import java.util.List;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-4-11
 * @sine 1.8
 */
public interface HashCodeBuilder {
    HashCode build(long accountId, long expireIn);

    /**
     * build hashcode list
     * @param accountId account id
     * @param expireIn expire in time, in milliseconds
     * @param size size of hashcode
     * @return
     */
    List<HashCode> build(long accountId, long expireIn, int size);
}
