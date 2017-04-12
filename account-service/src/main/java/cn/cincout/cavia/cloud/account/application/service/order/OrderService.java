package cn.cincout.cavia.cloud.account.application.service.order;

import cn.cincout.cavia.cloud.account.api.dto.order.OrderState;
import cn.cincout.cavia.cloud.account.domain.order.OrderDetail;

import java.util.List;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-4-9
 * @sine 1.8
 */
public interface OrderService {
    /**
     * save or update order, default order state is UNPAID
     * @param order
     * @return saved order details
     */
    OrderDetail save(OrderDetail order);
    OrderDetail updateOrderState(OrderState state, long orderId);

    OrderDetail findById(long id);
    OrderDetail findByOrderNumber(String orderNumber);

    List<OrderDetail> findByAccount(long accountId);
    List<OrderDetail> findByAccount(String email);

    /**
     * find order list by account id and order state
     * @param orderState order state
     * @param accountId account id
     * @return order list
     */
    List<OrderDetail> findByStateAndAccount(OrderState orderState, long accountId);

    void delete(long id);
    void deleteByOrderNumber(String orderNumber);
}
