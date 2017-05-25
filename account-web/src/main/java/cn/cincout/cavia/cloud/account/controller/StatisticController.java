package cn.cincout.cavia.cloud.account.controller;

import cn.cincout.cavia.cloud.account.api.service.StatisticServiceFacade;
import cn.cincout.cavia.cloud.account.vo.StatisticVo;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-5-25
 * @sine 1.8
 */
@RequestMapping("/api")
@RestController
public class StatisticController {

    @Reference(version = "1.0")
    private StatisticServiceFacade statisticServiceFacade;

    @RequestMapping(value = "/statistic", method = RequestMethod.GET)
    public StatisticVo statistic() {
        return new StatisticVo(
                statisticServiceFacade.totalAccount(),
                statisticServiceFacade.totalResource(),
                statisticServiceFacade.totalLike(),
                statisticServiceFacade.totalView()
        );
    }

}
