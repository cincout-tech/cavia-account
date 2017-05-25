package cn.cincout.cavia.cloud.account.interfaces;

import cn.cincout.cavia.cloud.account.api.service.StatisticServiceFacade;
import cn.cincout.cavia.cloud.account.application.service.account.AccountService;
import cn.cincout.cavia.cloud.account.application.service.resource.ResourceService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-5-25
 * @sine 1.8
 */
@Service(version = "1.0")
public class StatisticServiceFacadeImpl implements StatisticServiceFacade {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ResourceService resourceService;

    @Override
    public long totalAccount() {
        return accountService.totalAccounts();
    }

    @Override
    public long totalResource() {
        return resourceService.totalResources();
    }

    @Override
    public long totalCategories() {
        return 0;
    }

    @Override
    public long totalTags() {
        return 0;
    }

    @Override
    public long totalView() {
        return resourceService.totalViews();
    }

    @Override
    public long totalLike() {
        return resourceService.totalLikes();
    }
}
