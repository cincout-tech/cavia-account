package cn.cincout.cavia.cloud.account.api.service;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-5-25
 * @sine 1.8
 */
public interface StatisticServiceFacade {
    long totalAccount();
    long totalResource();
    long totalCategories();
    long totalTags();
    long totalView();
    long totalLike();
}
