package cn.cincout.cavia.cloud.account.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-4-13
 * @sine 1.8
 */
public class LoginEvent extends ApplicationEvent {

    public LoginEvent(Object source) {
        super(source);
    }
}
