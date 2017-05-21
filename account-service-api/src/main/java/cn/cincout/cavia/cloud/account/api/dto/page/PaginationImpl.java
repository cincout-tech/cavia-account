package cn.cincout.cavia.cloud.account.api.dto.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-5-15
 * @sine 1.8
 */
public class PaginationImpl<T> implements Pagination<T>, Slice<T>, Serializable {
    private List<T> content = new ArrayList<T>();
    private long total;
    private PageInfo pageInfo;

    public PaginationImpl() {
    }

    /**
     * Constructor of {@code PageImpl}.
     *
     * @param content the content of this page, must not be {@literal null}.
     * @param pageInfo the paging information, can be {@literal null}.
     * @param total the total amount of items available. The total might be adapted considering the length of the content
     *          given, if it is going to be the content of the last page. This is in place to mitigate inconsistencies
     */
    public PaginationImpl(List<T> content, PageInfo pageInfo, long total) {

        this.pageInfo = pageInfo;
        this.content.addAll(content);
        this.total = !content.isEmpty() && pageInfo != null && pageInfo.getOffset() + pageInfo.getPageSize() > total
                ? pageInfo.getOffset() + content.size() : total;
    }

    /**
     * Creates a new {@link PaginationImpl} with the given content. This will result in the created {@link Pagination} being identical
     * to the entire {@link List}.
     *
     * @param content must not be {@literal null}.
     */
    public PaginationImpl(List<T> content) {
        this(content, null, null == content ? 0 : content.size());
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.domain.Page#getTotalPages()
     */
    @Override
    public int getTotalPages() {
        return getSize() == 0 ? 1 : (int) Math.ceil((double) total / (double) getSize());
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.domain.Page#getTotalElements()
     */
    @Override
    public long getTotalElements() {
        return total;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.domain.Slice#hasNext()
     */
    @Override
    public boolean hasNext() {
        return getNumber() + 1 < getTotalPages();
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    /*
         * (non-Javadoc)
         * @see org.springframework.data.domain.Slice#getNumber()
         */
    public int getNumber() {
        return pageInfo == null ? 0 : pageInfo.getPageNumber();
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.domain.Slice#getSize()
     */
    public int getSize() {
        return pageInfo == null ? 0 : pageInfo.getPageSize();
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.domain.Slice#getNumberOfElements()
     */
    public int getNumberOfElements() {
        return content.size();
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.domain.Slice#hasPrevious()
     */
    public boolean hasPrevious() {
        return getNumber() > 0;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.domain.Slice#isFirst()
     */
    public boolean isFirst() {
        return !hasPrevious();
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.domain.Slice#isLast()
     */
    public boolean isLast() {
        return !hasNext();
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.domain.Slice#nextPageable()
     */
    public PageInfo nextPageable() {
        return hasNext() ? pageInfo.next() : null;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.domain.Slice#previousPageable()
     */
    public PageInfo previousPageable() {

        if (hasPrevious()) {
            return pageInfo.previousOrFirst();
        }

        return null;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.domain.Slice#hasContent()
     */
    public boolean hasContent() {
        return !content.isEmpty();
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.domain.Slice#getContent()
     */
    public List<T> getContent() {
        return Collections.unmodifiableList(content);
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.domain.Slice#getSort()
     */
    public Sorts getSort() {
        return pageInfo == null ? null : pageInfo.getSort();
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Iterable#iterator()
     */
    public Iterator<T> iterator() {
        return content.iterator();
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }


    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        String contentType = "UNKNOWN";
        List<T> content = getContent();

        if (content.size() > 0) {
            contentType = content.get(0).getClass().getName();
        }

        return String.format("Page %s of %d containing %s instances", getNumber() + 1, getTotalPages(), contentType);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof PaginationImpl<?>)) {
            return false;
        }

        PaginationImpl<?> that = (PaginationImpl<?>) obj;

        return this.total == that.total && super.equals(obj);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        int result = 17;

        result += 31 * (int) (total ^ total >>> 32);
        result += 31 * super.hashCode();

        return result;
    }
}

