package cn.cincout.cavia.cloud.account.api.dto.order;

import lombok.*;

import java.io.Serializable;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-4-3
 * @sine 1.8
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = {"id", "accountId", "expireIn"})
@EqualsAndHashCode
public class HashCodeDto implements Serializable {
    private Long id;
    private long accountId;
    private long expireIn;
    private long createDate;

    private String cryptoText;

    public HashCodeDto(long accountId, long expireIn) {
        this.accountId = accountId;
        this.expireIn = expireIn;
    }
}
