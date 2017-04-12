package cn.cincout.cavia.cloud.account.application.service.price;

import cn.cincout.cavia.cloud.account.domain.price.PriceStandard;

import java.util.Collection;
import java.util.List;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-4-9
 * @sine 1.8
 */
public interface PriceStandardService {
    PriceStandard getById(int id);
    Collection<PriceStandard> getAll();

    PriceStandard save(PriceStandard priceStandard);
    List<PriceStandard> save(List<PriceStandard> priceStandards);

    void delete(int id);
}
