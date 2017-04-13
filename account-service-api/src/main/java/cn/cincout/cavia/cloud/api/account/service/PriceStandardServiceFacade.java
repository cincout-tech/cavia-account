package cn.cincout.cavia.cloud.api.account.service;

import cn.cincout.cavia.cloud.api.account.dto.price.PriceStandardDto;

import java.util.Collection;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-4-3
 * @sine 1.8
 */
public interface PriceStandardServiceFacade {
    PriceStandardDto getById(int id);
    Collection<PriceStandardDto> getAll();

    PriceStandardDto save(PriceStandardDto priceStandard);
    Collection<PriceStandardDto> save(Collection<PriceStandardDto> priceStandards);

    void delete(int id);

}
