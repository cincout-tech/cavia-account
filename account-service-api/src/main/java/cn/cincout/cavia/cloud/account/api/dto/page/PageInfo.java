package cn.cincout.cavia.cloud.account.api.dto.page;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-5-15
 * @sine 1.8
 */
public interface PageInfo {
    /**
     * Returns the page to be returned.
     *
     * @return the page to be returned.
     */
    int getPageNumber();

    /**
     * Returns the number of items to be returned.
     *
     * @return the number of items of that page
     */
    int getPageSize();

    /**
     * Returns the offset to be taken according to the underlying page and page size.
     *
     * @return the offset to be taken
     */
    int getOffset();

    /**
     * Returns the sorting parameters.
     *
     * @return
     */
    Sorts getSort();

    /**
     * Returns the {@link PageInfo} requesting the next {@link Pagination}.
     *
     * @return
     */
    PageInfo next();

    /**
     * Returns the previous {@link PageInfo} or the first {@link PageInfo} if the current one already is the first one.
     *
     * @return
     */
    PageInfo previousOrFirst();

    /**
     * Returns the {@link PageInfo} requesting the first page.
     *
     * @return
     */
    PageInfo first();

    /**
     * Returns whether there's a previous {@link PageInfo} we can access from the current one. Will return
     * {@literal false} in case the current {@link PageInfo} already refers to the first page.
     *
     * @return
     */
    boolean hasPrevious();
}
