package cn.cincout.cavia.cloud.account.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-4-13
 * @sine 1.8
 */
@Component
public class AccountActionListener implements ApplicationListener<ApplicationEvent> {
    private final static Logger LOG = LoggerFactory.getLogger(AccountActionListener.class);

    @Override
    public void onApplicationEvent(ApplicationEvent accountEvent) {
        LOG.info("AccountActionListener, event is {}.", accountEvent.getClass().getName());
    }
}
