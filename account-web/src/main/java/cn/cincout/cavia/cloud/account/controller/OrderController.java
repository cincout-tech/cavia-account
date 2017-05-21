package cn.cincout.cavia.cloud.account.controller;

import cn.cincout.cavia.cloud.account.api.dto.order.OrderDetailDto;
import cn.cincout.cavia.cloud.account.vo.OrderVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-4-3
 * @sine 1.8
 */
@RestController
@RequestMapping("/api")
public class OrderController {
    private final static Logger LOG = LoggerFactory.getLogger(OrderController.class);

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public List<OrderDetailDto> orderDetailList(long accountId) {
        return null;
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public OrderDetailDto purchaseService(@RequestBody OrderVo orderVo) {
        return new OrderDetailDto();
    }
}
