package cn.cincout.cavia.cloud.account.application.service.exception;

import org.springframework.dao.DataAccessException;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-4-12
 * @sine 1.8
 */
public class OrderStateUpdateException extends DataAccessException {
    public OrderStateUpdateException(String msg) {
        super(msg);
    }
}
