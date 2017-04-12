package cn.cincout.cavia.cloud.account.domain.order;

import cn.cincout.cavia.cloud.account.api.dto.order.OrderState;
import cn.cincout.cavia.cloud.account.domain.account.Account;
import cn.cincout.cavia.cloud.account.domain.price.PriceStandard;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.List;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-4-3
 * @sine 1.8
 */
@Entity
@Table(name = "t_orders")

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = {"id", "orderNumber"})
@EqualsAndHashCode
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNumber;

    @CreatedDate
    private long createDate;

    private long expireIn;

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "priceStandId", referencedColumnName = "id")
    private PriceStandard priceStandard;
    // purchase number of PriceStandard
    private int purchaseNum;

    @Enumerated(EnumType.STRING)
    private OrderState state;

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "accountId", referencedColumnName = "id")
    private Account account;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "orderId", referencedColumnName = "id")
    private List<HashCode> hashCodeList;

}
