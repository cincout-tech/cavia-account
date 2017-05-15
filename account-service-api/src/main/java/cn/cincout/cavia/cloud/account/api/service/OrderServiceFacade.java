package cn.cincout.cavia.cloud.account.api.service;

import cn.cincout.cavia.cloud.account.api.dto.order.OrderState;
import cn.cincout.cavia.cloud.account.api.dto.order.OrderDetailDto;

import java.util.List;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-4-3
 * @sine 1.8
 */
public interface OrderServiceFacade {
    /**
     * save or update order, default order state is UNPAID
     * @param order
     * @return saved order details
     */
    OrderDetailDto save(OrderDetailDto order);
    OrderDetailDto updateOrderState(OrderState state, long orderId);

    OrderDetailDto findById(long id);
    OrderDetailDto findByOrderNumber(String orderNumber);

    List<OrderDetailDto> findByAccount(long accountId);
    List<OrderDetailDto> findByAccount(String email);

    /**
     * find order list by account id and order state
     * @param orderState order state
     * @param accountId account id
     * @return order list
     */
    List<OrderDetailDto> findByStateAndAccount(OrderState orderState, long accountId);

    void delete(long id);
    void deleteByOrderNumber(String orderNumber);
}
