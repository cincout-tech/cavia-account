package cn.cincout.cavia.cloud.account.inf.repository;

import cn.cincout.cavia.cloud.account.api.dto.order.OrderState;
import cn.cincout.cavia.cloud.account.domain.order.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-4-11
 * @sine 1.8
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    @Query(value = "select orderDetail from OrderDetail orderDetail where orderDetail.orderNumber = ?1")
    OrderDetail findByOrderNumber(String orderNumber);

    @Query(value = "select orderDetail from OrderDetail orderDetail where orderDetail.account.id = ?1")
    List<OrderDetail> findByAccountId(Long accountId);

    @Query(value = "select orderDetail from OrderDetail orderDetail where orderDetail.account.email = ?1")
    List<OrderDetail> findByAccountEmail(String email);

    @Query(value = "select orderDetail from OrderDetail orderDetail where orderDetail.state = ?1 and orderDetail.account.id = ?2")
    List<OrderDetail> findByStateAndAccount(OrderState state, Long accountId);

    @Modifying(clearAutomatically = true)
    @Query("update OrderDetail orderDetail set orderDetail.state = ?1 where orderDetail.id = ?2")
    int updateOrderState(OrderState state, long orderId);

    @Modifying(clearAutomatically = true)
    @Query("delete from OrderDetail orderDetail where orderDetail.orderNumber = :orderNumber")
    void deleteByOrderNumber(@Param("orderNumber") String orderNumber);
}
