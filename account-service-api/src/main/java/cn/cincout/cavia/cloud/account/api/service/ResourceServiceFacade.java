package cn.cincout.cavia.cloud.account.api.service;

import cn.cincout.cavia.cloud.account.api.dto.page.Pagination;
import cn.cincout.cavia.cloud.account.api.dto.page.PageInfo;
import cn.cincout.cavia.cloud.account.api.dto.resource.ResourceDto;

import java.util.List;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-5-15
 * @sine 1.8
 */
public interface ResourceServiceFacade {
    ResourceDto save(ResourceDto resource);
    List<ResourceDto> save(Iterable<ResourceDto> resources);

    Pagination<ResourceDto> findByKeyWordsLike(String keywords, PageInfo pageInfo);
    Pagination<ResourceDto> findByCategory(String category);
    Pagination<ResourceDto> findByTag(String tag);

    Pagination<ResourceDto> findByAccountId(Long accountId);
    Pagination<ResourceDto> findByKeyWordsLike(Long accountId, String keywords);
    Pagination<ResourceDto> findByCategory(Long accountId, String category);
    Pagination<ResourceDto> findByTag(Long accountId, String tag);

    void delete(Long resourceId);
}
