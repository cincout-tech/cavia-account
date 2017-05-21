package cn.cincout.cavia.cloud.account.inf.repository.resource;

import cn.cincout.cavia.cloud.account.domain.resource.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-5-12
 * @sine 1.8
 */
public interface ResourceRepository extends JpaRepository<Resource, Long> {
    @Query(value = "select resource from Resource resource where resource.accountId = ?1")
    Page<Resource> findByAccountId(Long accountId, Pageable pageable);

    @Query(value = "select resource from Resource resource where resource.title like %:keyword% or resource.categories like %:keyword% or resource.tags like %:keyword%")
    Page<Resource> findByKeywordsLike(@Param("keyword") String keyWord, Pageable pageable);

    @Query(value = "select resource from Resource resource where resource.categories like %:categories% ")
    Page<Resource> findByCategories(@Param("categories") String categories, Pageable pageable);

    @Query(value = "select resource from Resource resource where resource.tags like %:tags% ")
    Page<Resource> findByTags(@Param("tags") String tags, Pageable pageable);
}
