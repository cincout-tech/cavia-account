package cn.cincout.cavia.cloud.account.interfaces;

import cn.cincout.cavia.cloud.account.api.dto.page.Pagination;
import cn.cincout.cavia.cloud.account.api.dto.page.PaginationImpl;
import cn.cincout.cavia.cloud.account.api.dto.page.PageInfo;
import cn.cincout.cavia.cloud.account.api.dto.resource.ResourceDto;
import cn.cincout.cavia.cloud.account.api.service.ResourceServiceFacade;
import cn.cincout.cavia.cloud.account.application.service.resource.ResourceService;
import cn.cincout.cavia.cloud.account.domain.resource.Resource;
import cn.cincout.cavia.cloud.account.interfaces.utils.PageUtils;
import com.alibaba.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-5-15
 * @sine 1.8
 */
@Service(version = "1.0")
public class ResourceServiceFacadeImpl implements ResourceServiceFacade {
    private final static Logger LOG = LoggerFactory.getLogger(ResourceServiceFacadeImpl.class);

    @Autowired
    private ResourceService resourceService;

    @Override
    public ResourceDto save(ResourceDto resourceDto) {
        Resource resource = DtoAdapter.toDomain(resourceDto);
        return DtoAdapter.toDto(resourceService.save(resource));
    }

    @Override
    public List<ResourceDto> save(Iterable<ResourceDto> resources) {
        return null;
    }

    @Override
    public Pagination<ResourceDto> findByKeyWordsLike(String keywords, PageInfo pageInfo) {
        LOG.debug("search keywords is {}.", keywords);

        Page<Resource> resourcePage = resourceService.findByKeyWordsLike(
                keywords,
                new PageRequest(pageInfo.getPageNumber(), pageInfo.getPageSize(), PageUtils.toSort(pageInfo.getSort()))
        );
        return new PaginationImpl<ResourceDto>(
                DtoAdapter.toResourceDtoList(resourcePage.getContent()),
                pageInfo,
                resourcePage.getTotalElements()
        );
    }

    @Override
    public Pagination<ResourceDto> findByCategory(String category) {
        return null;
    }

    @Override
    public Pagination<ResourceDto> findByTag(String tag) {
        return null;
    }

    @Override
    public Pagination<ResourceDto> findByAccountId(Long accountId) {
        return null;
    }

    @Override
    public Pagination<ResourceDto> findByKeyWordsLike(Long accountId, String keywords) {
        return null;
    }

    @Override
    public Pagination<ResourceDto> findByCategory(Long accountId, String category) {
        return null;
    }

    @Override
    public Pagination<ResourceDto> findByTag(Long accountId, String tag) {
        return null;
    }

    @Override
    public void delete(Long resourceId) {
        resourceService.delete(resourceId);
    }

    @Override
    public ResourceDto like(Long accountId, Long resourceId) {
        Resource resource = resourceService.like(accountId, resourceId);
        return DtoAdapter.toDto(resource);
    }

    @Override
    public ResourceDto view(Long accountId, Long resourceId) {
        Resource resource = resourceService.view(accountId, resourceId);
        return DtoAdapter.toDto(resource);
    }

    @Override
    public ResourceDto view(Long resourceId) {
        return null;
    }
}
