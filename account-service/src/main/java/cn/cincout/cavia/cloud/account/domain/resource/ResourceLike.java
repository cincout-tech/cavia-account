package cn.cincout.cavia.cloud.account.domain.resource;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-5-21
 * @sine 1.8
 */
@Entity
@Table(name = "t_resource_like")

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"id", "accountId", "resourceId"})
@EqualsAndHashCode
@Builder
public class ResourceLike implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long accountId;
    private Long resourceId;
}
