package cn.cincout.cavia.cloud.account.controller;

import cn.cincout.cavia.cloud.account.api.dto.page.PageInfo;
import cn.cincout.cavia.cloud.account.api.dto.page.PageInfoImpl;
import cn.cincout.cavia.cloud.account.api.dto.page.Pagination;
import cn.cincout.cavia.cloud.account.api.dto.page.Sorts;
import cn.cincout.cavia.cloud.account.api.dto.resource.ResourceDto;
import cn.cincout.cavia.cloud.account.api.service.ResourceServiceFacade;
import cn.cincout.cavia.cloud.account.vo.ResourceVo;
import cn.cincout.cavia.cloud.account.vo.VoAdapter;
import com.alibaba.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-5-15
 * @sine 1.8
 */
@RestController
@RequestMapping(value = "/api")
public class ResourceController {
    private final static Logger LOG = LoggerFactory.getLogger(ResourceController.class);

    @Reference(version = "1.0")
    private ResourceServiceFacade resourceServiceFacade;

    @RequestMapping(value = "/resources", method = RequestMethod.POST)
    public ResourceDto save(@RequestBody ResourceVo resourceVo) {
        LOG.debug("save resource, link is {}.", resourceVo.getLink());
        ResourceDto resourceDto = VoAdapter.toDto(resourceVo);
        return resourceServiceFacade.save(resourceDto);
    }

    @RequestMapping(value = "/resources", method = RequestMethod.GET)
    public Pagination<ResourceDto> findByKeywords(
            @RequestParam("keywords") String keywords,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "sort", defaultValue = "createTime") String sort,
            @RequestParam(name = "order", defaultValue = "ASC") String order) {
        PageInfo pageable = new PageInfoImpl(
                page, size,
                new Sorts(new Sorts.OrderBy(order.toUpperCase().equals("ASC") ? Sorts.Direction.ASC: Sorts.Direction.DESC, sort))
        );
        Pagination<ResourceDto> pagination = resourceServiceFacade.findByKeyWordsLike(keywords, pageable);
        return pagination;
    }

    @RequestMapping(value = "/account/{accountId}/resources/{resourceId}/like")
    public ResourceDto like(
            @PathVariable(name = "accountId") long accountId,
            @PathVariable(name = "resourceId") long resourceId) {
        return resourceServiceFacade.like(accountId, resourceId);
    }

    @RequestMapping(value = "/account/{accountId}/resources/{resourceId}/view")
    public ResourceDto view(
            @PathVariable(name = "accountId") long accountId,
            @PathVariable(name = "resourceId") long resourceId) {
        return resourceServiceFacade.view(accountId, resourceId);
    }

    @RequestMapping(value = "/resources/{resourceId}/view")
    public ResourceDto view(
            @PathVariable(name = "resourceId") long resourceId) {
        LOG.debug("view resource id {}.", resourceId);
        return resourceServiceFacade.view(resourceId);
    }
}
