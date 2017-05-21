package cn.cincout.cavia.cloud.account.application.service.resource;

import cn.cincout.cavia.cloud.account.domain.resource.Resource;
import cn.cincout.cavia.cloud.account.domain.resource.ResourceLike;
import cn.cincout.cavia.cloud.account.domain.resource.ResourceView;
import cn.cincout.cavia.cloud.account.inf.repository.resource.ResourceLikeRepository;
import cn.cincout.cavia.cloud.account.inf.repository.resource.ResourceRepository;
import cn.cincout.cavia.cloud.account.inf.repository.resource.ResourceViewRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-5-12
 * @sine 1.8
 */
@Service
@Transactional
public class ResourceServiceImpl implements ResourceService {
    private final static Logger LOG = LoggerFactory.getLogger(ResourceServiceImpl.class);

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private ResourceLikeRepository resourceLikeRepository;

    @Autowired
    private ResourceViewRepository resourceViewRepository;

    @Override
    public Resource save(Resource resource) {
        if (resource == null) {
            throw new IllegalArgumentException("null argument error.");
        }
        if (resource.getCreateTime() == null || resource.getCreateTime() == 0) {
            resource.setCreateTime(System.currentTimeMillis());
        }
        return resourceRepository.save(resource);
    }

    @Override
    @Transactional
    public List<Resource> save(Iterable<Resource> resources) {
        if (resources == null) {
            throw new IllegalArgumentException("null point error.");
        }
        List<Resource> resourceList = new ArrayList<>();
        resources.forEach(resource -> {
            resourceList.add(save(resource));
        });
        return resourceList;
    }

    @Override
    public Page<Resource> findByKeyWordsLike(String keywords, Pageable pageable) {
        if (StringUtils.isBlank(keywords)) {
            throw new IllegalArgumentException("keywords is blank.");
        }
        return resourceRepository.findByKeywordsLike(keywords, pageable);
    }

    @Override
    public Page<Resource> findByCategory(String category) {
        return null;
    }

    @Override
    public Page<Resource> findByTag(String tag) {
        return null;
    }

    @Override
    public Page<Resource> findByAccountId(Long accountId) {
        return null;
    }

    @Override
    public Page<Resource> findByKeyWordsLike(Long accountId, String keywords) {
        return null;
    }

    @Override
    public Page<Resource> findByCategory(Long accountId, String category) {
        return null;
    }

    @Override
    public Page<Resource> findByTag(Long accountId, String tag) {
        return null;
    }

    @Override
    public void delete(Long resourceId) {
        if (resourceId == null) {
            throw new IllegalArgumentException("resourceId is null.");
        }
        resourceRepository.delete(resourceId);
    }

    @Override
    @Transactional
    public Resource like(Long accountId, Long resourceId) {
        if (accountId  == null || resourceId == null) {
            throw new IllegalArgumentException("illegal argument, account id is " + accountId + "; resource id is " + resourceId);
        }
        ResourceLike resourceLike = resourceLikeRepository.findByAccountIdAndResourceId(accountId, resourceId);
        if (resourceLike == null) {
            Resource resource = resourceRepository.findOne(resourceId);
            resource.setLikeCount(resource.getLikeCount() + 1);

            resourceLike = ResourceLike.builder()
                    .accountId(accountId)
                    .resourceId(resourceId)
                    .build();
            resourceLikeRepository.save(resourceLike);
            return resource;
        }
        else {
            resourceLikeRepository.delete(resourceLike);
            Resource resource = resourceRepository.findOne(resourceId);
            resource.setLikeCount(resource.getLikeCount() - 1);
            return resource;
        }
    }

    @Override
    @Transactional
    public Resource view(Long accountId, Long resourceId) {
        if (accountId  == null || resourceId == null) {
            throw new IllegalArgumentException("illegal argument, account id is " + accountId + "; resource id is " + resourceId);
        }
        Resource resource = resourceRepository.findOne(resourceId);
        resource.setView(resource.getView() + 1);

        ResourceView resourceView = ResourceView.builder()
                .accountId(accountId)
                .resourceId(resourceId)
                .build();
        resourceViewRepository.save(resourceView);
        return resource;
    }

    @Override
    public Resource view(Long resourceId) {
        if (resourceId == null) {
            throw new IllegalArgumentException("null point.");
        }
        Resource resource = resourceRepository.findOne(resourceId);
        resource.setView(resource.getView() + 1);
        return resource;
    }
}
