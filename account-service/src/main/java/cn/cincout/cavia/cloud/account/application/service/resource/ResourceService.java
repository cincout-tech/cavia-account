package cn.cincout.cavia.cloud.account.application.service.resource;

import cn.cincout.cavia.cloud.account.domain.resource.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-5-12
 * @sine 1.8
 */
public interface ResourceService {
    /**
     * if createTime is null, set current system time
     * @param resource
     * @return
     */
    Resource save(Resource resource);
    List<Resource> save(Iterable<Resource> resources);

    Page<Resource> findByKeyWordsLike(String keywords, Pageable pageable);
    Page<Resource> findByCategory(String category);
    Page<Resource> findByTag(String tag);

    Page<Resource> findByAccountId(Long accountId);
    Page<Resource> findByKeyWordsLike(Long accountId, String keywords);
    Page<Resource> findByCategory(Long accountId, String category);
    Page<Resource> findByTag(Long accountId, String tag);

    void delete(Long resourceId);

    Resource like(Long accountId, Long resourceId);
    Resource view(Long accountId, Long resourceId);
    Resource view(Long resourceId);

    long totalResources();
    long totalViews();
    long totalLikes();
}
