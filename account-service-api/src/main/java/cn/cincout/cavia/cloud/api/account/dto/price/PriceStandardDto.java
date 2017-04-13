package cn.cincout.cavia.cloud.api.account.dto.price;

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
@Builder
public class PriceStandardDto {

    private int id;
    private String title;
    private String description;

    private double totalPrice;
    /**
     * default discount is 1.0
     */
    private float discount = 1.0F;

    List<PriceItemDto> priceItems;

    public void calculateTotalPrice() {
        if (this.priceItems == null || this.priceItems.size() == 0) {
            return;
        }

        priceItems.stream().forEach(item -> {
            this.totalPrice += item.getPrice();
        });
    }
}
