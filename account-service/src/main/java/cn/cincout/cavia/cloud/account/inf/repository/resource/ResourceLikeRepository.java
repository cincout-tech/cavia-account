package cn.cincout.cavia.cloud.account.inf.repository.resource;

import cn.cincout.cavia.cloud.account.domain.resource.ResourceLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-5-21
 * @sine 1.8
 */
public interface ResourceLikeRepository extends JpaRepository<ResourceLike, Long> {
    @Query(value = "select resourceLike from ResourceLike resourceLike where resourceLike.accountId = ?1 and resourceLike.resourceId = ?2")
    ResourceLike findByAccountIdAndResourceId(Long accountId, Long resourceId);
}