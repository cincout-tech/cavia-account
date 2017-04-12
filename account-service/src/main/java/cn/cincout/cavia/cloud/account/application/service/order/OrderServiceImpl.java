package cn.cincout.cavia.cloud.account.application.service.order;

import cn.cincout.cavia.cloud.account.api.dto.order.OrderState;
import cn.cincout.cavia.cloud.account.application.factory.HashCodeBuilder;
import cn.cincout.cavia.cloud.account.application.service.exception.OrderStateUpdateException;
import cn.cincout.cavia.cloud.account.domain.order.HashCode;
import cn.cincout.cavia.cloud.account.domain.order.OrderDetail;
import cn.cincout.cavia.cloud.account.inf.repository.OrderDetailRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-4-11
 * @sine 1.8
 */
@Service
public class OrderServiceImpl implements OrderService {
    private final static Logger LOG = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private HashCodeBuilder hashCodeBuilder;

    @Override
    public OrderDetail save(OrderDetail order) {
        if (order == null || order.getAccount() == null || order.getPriceStandard() == null) {
            LOG.warn("order instance has illegal argument");
            throw new IllegalArgumentException("illegal argument exception.");
        }

        List<HashCode> hashCodes = hashCodeBuilder.build(
                order.getAccount().getId(),
                order.getExpireIn(),
                order.getPurchaseNum());
        order.setHashCodeList(hashCodes);
        // default is unpaid
        if (order.getState() == null) {
            order.setState(OrderState.UNPAID);
        }
        return orderDetailRepository.save(order);
    }

    @Override
    public OrderDetail updateOrderState(OrderState state, long orderId) {
        if (state == null) {
            throw new IllegalArgumentException("order state is null.");
        }
        int flag = orderDetailRepository.updateOrderState(state, orderId);
        if (flag < 0) {
            LOG.warn("update order {} error.", orderId);
            throw new OrderStateUpdateException("update order " + orderId + " error.");
        }
        return orderDetailRepository.findOne(orderId);
    }

    @Override
    public OrderDetail findById(long id) {
        return orderDetailRepository.findOne(id);
    }

    @Override
    public OrderDetail findByOrderNumber(String orderNumber) {
        if (StringUtils.isBlank(orderNumber)) {
            LOG.error("order number is blank.");
            throw new IllegalArgumentException("order number is blank.");
        }
        return orderDetailRepository.findByOrderNumber(orderNumber);
    }

    @Override
    public List<OrderDetail> findByAccount(long accountId) {
        return orderDetailRepository.findByAccountId(accountId);
    }

    @Override
    public List<OrderDetail> findByAccount(String email) {
        if (StringUtils.isBlank(email)) {
            LOG.error("email is blank.");
            throw new IllegalArgumentException("email is blank.");
        }
        return orderDetailRepository.findByAccountEmail(email);
    }

    @Override
    public List<OrderDetail> findByStateAndAccount(OrderState orderState, long accountId) {
        if (orderState == null) {
            throw new IllegalArgumentException("order state is null.");
        }
        return orderDetailRepository.findByStateAndAccount(orderState, accountId);
    }

    @Override
    public void delete(long id) {
        orderDetailRepository.delete(id);
        LOG.debug("order id {} deleted.", id);
    }

    @Override
    public void deleteByOrderNumber(String orderNumber) {
        if (StringUtils.isBlank(orderNumber)) {
            LOG.error("order number is blank.");
            throw new IllegalArgumentException("order number is blank.");
        }

        orderDetailRepository.deleteByOrderNumber(orderNumber);
        LOG.debug("order number {} deleted.", orderNumber);
    }
}
