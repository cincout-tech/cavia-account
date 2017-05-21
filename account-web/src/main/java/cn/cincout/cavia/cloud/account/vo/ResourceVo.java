package cn.cincout.cavia.cloud.account.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class ResourceVo implements Serializable {
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
