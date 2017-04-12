package cn.cincout.cavia.cloud.account.domain.price;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-4-3
 * @sine 1.8
 */
@Entity
@Table(name = "t_price_standard")

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = {"id", "title", "description"})
@Builder
public class PriceStandard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;

    private double totalPrice;
    /**
     * default discount is 1.0
     */
    private float discount = 1.0F;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "priceStandardId", referencedColumnName = "id")
    private Set<PriceItem> priceItems;

    public void addPriceItem(PriceItem priceItem) {
        if (this.priceItems == null) {
            this.priceItems = new HashSet<>();
        }
        this.priceItems.add(priceItem);
    }

    public void addPriceItem(Set<PriceItem> priceItems) {
        if (this.priceItems == null) {
            this.priceItems = new HashSet<>();
        }
        this.priceItems.addAll(priceItems);
    }

    public void calculateTotalPrice() {
        if (this.priceItems == null || this.priceItems.size() == 0) {
            return;
        }

        priceItems.stream().forEach(item -> {
            this.totalPrice += item.getPrice();
        });
    }
}
