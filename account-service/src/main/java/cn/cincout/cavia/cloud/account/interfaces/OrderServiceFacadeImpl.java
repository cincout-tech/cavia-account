package cn.cincout.cavia.cloud.account.interfaces;

import cn.cincout.cavia.cloud.account.api.dto.order.OrderDetailDto;
import cn.cincout.cavia.cloud.account.api.dto.order.OrderState;
import cn.cincout.cavia.cloud.account.api.service.OrderServiceFacade;
import cn.cincout.cavia.cloud.account.application.service.order.OrderService;
import com.alibaba.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-4-12
 * @sine 1.8
 */
@Service(version = "1.0")
public class OrderServiceFacadeImpl implements OrderServiceFacade {
    private static final Logger LOG = LoggerFactory.getLogger(OrderServiceFacadeImpl.class);

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDetailDto save(OrderDetailDto order) {
        return null;
    }

    @Override
    public OrderDetailDto updateOrderState(OrderState state, long orderId) {
        return null;
    }

    @Override
    public OrderDetailDto findById(long id) {
        return null;
    }

    @Override
    public OrderDetailDto findByOrderNumber(String orderNumber) {
        return null;
    }

    @Override
    public List<OrderDetailDto> findByAccount(long accountId) {
        return null;
    }

    @Override
    public List<OrderDetailDto> findByAccount(String email) {
        return null;
    }

    @Override
    public List<OrderDetailDto> findByStateAndAccount(OrderState orderState, long accountId) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void deleteByOrderNumber(String orderNumber) {

    }
}
