package cn.cincout.cavia.cloud.account.api.dto.price;

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
@ToString
@EqualsAndHashCode
public class PriceItemDto implements Serializable {
    private int id;
    private String name;
    private String description;
    private double price;
}
