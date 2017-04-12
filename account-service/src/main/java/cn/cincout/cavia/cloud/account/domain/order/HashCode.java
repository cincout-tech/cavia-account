package cn.cincout.cavia.cloud.account.domain.order;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-4-3
 * @sine 1.8
 */

@Entity
@Table(name = "t_hash_code")

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = {"id", "accountId", "expireIn"})
@EqualsAndHashCode
@Builder
public class HashCode {
    public static final String ACCOUNT_ID_KEY = "account_id";
    public static final String EXPIRE_IN_KEY = "expire_in";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long accountId;
    private long expireIn;
    @CreatedDate
    private long createDate;

    private String cryptoText;

    public HashCode(long accountId, long expireIn) {
        this.accountId = accountId;
        this.expireIn = expireIn;
    }

    /**
     * get the map for generate crypto text
     * @return map
     */
    public static Map<String, Long> getMap(long accountId, long expireIn) {
        Map<String, Long> map = new HashMap<>();
        map.put(ACCOUNT_ID_KEY, accountId);
        map.put(EXPIRE_IN_KEY, expireIn);
        return map;
    }
}
