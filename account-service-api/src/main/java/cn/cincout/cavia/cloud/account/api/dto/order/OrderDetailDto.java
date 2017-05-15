package cn.cincout.cavia.cloud.account.api.dto.order;

import cn.cincout.cavia.cloud.account.api.dto.account.AccountDto;
import cn.cincout.cavia.cloud.account.api.dto.price.PriceStandardDto;
import lombok.*;

import java.util.List;

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
@ToString
@EqualsAndHashCode
public class OrderDetailDto {

    private long id;
    private String orderNumber;
    private long createDate;
    private long expireIn;

    private PriceStandardDto priceStandardDto;
    // purchase number
    private int purchaseNum;
    private OrderState state;

    private AccountDto accountDto;

    private List<HashCodeDto> hashCodeDtoList;

}
