package cn.cincout.cavia.cloud.account.api.dto.resource;

import lombok.*;

import java.io.Serializable;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-5-15
 * @sine 1.8
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = {"id", "title"})
@EqualsAndHashCode(of = {"id", "title", "link"})
@Builder
public class ResourceDto implements Serializable {
    private Long id;

    private String title;
    private String abstractContent;
    private String origin;
    private String link;

    // tag1;tag2;tag3
    private String tags;
    private String categories;

    private Long accountId;
    private Long likeCount;
    private Long view;

    private Long createTime;
}
