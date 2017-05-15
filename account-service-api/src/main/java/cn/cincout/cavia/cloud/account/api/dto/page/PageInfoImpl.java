package cn.cincout.cavia.cloud.account.api.dto.page;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-5-15
 * @sine 1.8
 */
public class PageInfoImpl extends AbstractPageRequest {
    private Sorts sort;

    public PageInfoImpl() {
        super(0, 10);
        this.sort = null;
    }

    /**
     * Creates a new {@link PageInfoImpl}. Pages are zero indexed, thus providing 0 for {@code page} will return the first
     * page.
     *
     * @param page zero-based page index.
     * @param size the size of the page to be returned.
     */
    public PageInfoImpl(int page, int size) {
        this(page, size, null);
    }

    /**
     * Creates a new {@link PageInfoImpl} with sort parameters applied.
     *
     * @param page zero-based page index.
     * @param size the size of the page to be returned.
     * @param direction the direction of the {@link Sorts} to be specified, can be {@literal null}.
     * @param properties the properties to sort by, must not be {@literal null} or empty.
     */
    public PageInfoImpl(int page, int size, Sorts.Direction direction, String... properties) {
        this(page, size, new Sorts(direction, properties));
    }

    /**
     * Creates a new {@link PageInfoImpl} with sort parameters applied.
     *
     * @param page zero-based page index.
     * @param size the size of the page to be returned.
     * @param sort can be {@literal null}.
     */
    public PageInfoImpl(int page, int size, Sorts sort) {
        super(page, size);
        this.sort = sort;
    }

    public void setSort(Sorts sort) {
        this.sort = sort;
    }

    /*
         * (non-Javadoc)
         * @see org.springframework.data.domain.Pageable#getSort()
         */
    public Sorts getSort() {
        return sort;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.domain.Pageable#next()
     */
    public PageInfo next() {
        return new PageInfoImpl(getPageNumber() + 1, getPageSize(), getSort());
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.domain.AbstractPageRequest#previous()
     */
    public PageInfoImpl previous() {
        return getPageNumber() == 0 ? this : new PageInfoImpl(getPageNumber() - 1, getPageSize(), getSort());
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.domain.Pageable#first()
     */
    public PageInfo first() {
        return new PageInfoImpl(0, getPageSize(), getSort());
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof PageInfoImpl)) {
            return false;
        }

        PageInfoImpl that = (PageInfoImpl) obj;

        boolean sortEqual = this.sort == null ? that.sort == null : this.sort.equals(that.sort);

        return super.equals(that) && sortEqual;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return 31 * super.hashCode() + (null == sort ? 0 : sort.hashCode());
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("Page request [number: %d, size %d, sort: %s]", getPageNumber(), getPageSize(),
                sort == null ? null : sort.toString());
    }
}

