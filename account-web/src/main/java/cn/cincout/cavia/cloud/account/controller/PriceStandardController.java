package cn.cincout.cavia.cloud.account.controller;

import cn.cincout.cavia.cloud.account.api.dto.price.PriceStandardDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
public class PriceStandardController {

    @RequestMapping(value = "/priceList", method = RequestMethod.GET)
    public List<PriceStandardDto> priceStandardList() {
        return null;
    }

}
