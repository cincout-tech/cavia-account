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
abstract class Chunk<T> implements Slice<T>, Serializable {
    private List<T> content = new ArrayList<T>();
    private PageInfo pageInfo;

    public Chunk() {
    }

    /**
     * Creates a new {@link Chunk} with the given content and the given governing {@link PageInfo}.
     *
     * @param content must not be {@literal null}.
     * @param pageInfo can be {@literal null}.
     */
    public Chunk(List<T> content, PageInfo pageInfo) {
        this.content.addAll(content);
        this.pageInfo = pageInfo;
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

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Chunk<?>)) {
            return false;
        }

        Chunk<?> that = (Chunk<?>) obj;

        boolean contentEqual = this.content.equals(that.content);
        boolean pageableEqual = this.pageInfo == null ? that.pageInfo == null : this.pageInfo.equals(that.pageInfo);

        return contentEqual && pageableEqual;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        int result = 17;

        result += 31 * (pageInfo == null ? 0 : pageInfo.hashCode());
        result += 31 * content.hashCode();

        return result;
    }
}
