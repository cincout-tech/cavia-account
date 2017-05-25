package cn.cincout.cavia.cloud.account.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-5-25
 * @sine 1.8
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatisticVo implements Serializable {
    private long totalAccounts;
    private long totalResources;
    private long totalLikes;
    private long totalViews;
}
