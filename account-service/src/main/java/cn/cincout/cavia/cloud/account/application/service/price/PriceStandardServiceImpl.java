package cn.cincout.cavia.cloud.account.application.service.price;

import cn.cincout.cavia.cloud.account.domain.price.PriceStandard;
import cn.cincout.cavia.cloud.account.inf.repository.PriceStandardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-4-11
 * @sine 1.8
 */
@Service
public class PriceStandardServiceImpl implements PriceStandardService {
    private final static Logger LOG = LoggerFactory.getLogger(PriceStandardServiceImpl.class);

    @Autowired
    private PriceStandardRepository priceStandardRepository;

    @Override
    public PriceStandard getById(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("id less than 0");
        }
        return priceStandardRepository.findOne(id);
    }

    @Override
    public Collection<PriceStandard> getAll() {
        return priceStandardRepository.findAll();
    }

    @Override
    public PriceStandard save(PriceStandard priceStandard) {
        if (priceStandard == null) {
            throw new IllegalArgumentException("null argument error.");
        }
        return priceStandardRepository.save(priceStandard);
    }

    @Override
    public List<PriceStandard> save(List<PriceStandard> priceStandards) {
        if (priceStandards == null) {
            throw new IllegalArgumentException("null argument error.");
        }
        return priceStandardRepository.save(priceStandards);
    }

    @Override
    public void delete(int id) {
        LOG.debug("PriceStandard id {} was deleted.", id);
        priceStandardRepository.delete(id);
    }
}
