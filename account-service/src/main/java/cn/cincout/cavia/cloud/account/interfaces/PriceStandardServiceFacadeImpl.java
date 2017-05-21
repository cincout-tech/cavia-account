package cn.cincout.cavia.cloud.account.interfaces;

import cn.cincout.cavia.cloud.account.api.dto.price.PriceStandardDto;
import cn.cincout.cavia.cloud.account.api.service.PriceStandardServiceFacade;
import cn.cincout.cavia.cloud.account.application.service.price.PriceStandardService;
import com.alibaba.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-4-12
 * @sine 1.8
 */
//@Service(version = "1.0")
public class PriceStandardServiceFacadeImpl implements PriceStandardServiceFacade {
    private final static Logger LOG = LoggerFactory.getLogger(PriceStandardServiceFacadeImpl.class);

    @Autowired
    private PriceStandardService priceStandardService;

    @Override
    public PriceStandardDto getById(int id) {
        return DtoAdapter.toDto(priceStandardService.getById(id));
    }

    @Override
    public Collection<PriceStandardDto> getAll() {
        return DtoAdapter.toPriceStandardDtoList(priceStandardService.getAll());
    }

    @Override
    public PriceStandardDto save(PriceStandardDto priceStandard) {
        if (priceStandard == null) {
            throw new NullPointerException("priceStandard si null.");
        }
        return DtoAdapter.toDto(
                priceStandardService.save(DtoAdapter.toDomain(priceStandard))
        );
    }

    @Override
    public Collection<PriceStandardDto> save(Collection<PriceStandardDto> priceStandards) {
        if (priceStandards == null) {
            throw new NullPointerException("priceStandards is null.");
        }
        return DtoAdapter.toPriceStandardDtoList(
                DtoAdapter.toPriceStandardDomainList(priceStandards)
        );
    }

    @Override
    public void delete(int id) {
        priceStandardService.delete(id);
    }
}
