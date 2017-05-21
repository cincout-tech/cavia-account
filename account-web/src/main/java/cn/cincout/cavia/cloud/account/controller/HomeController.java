package cn.cincout.cavia.cloud.account.controller;

import cn.cincout.cavia.cloud.account.config.AuthorInfo;
import cn.cincout.cavia.cloud.account.event.LoginEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-4-6
 * @sine 1.8
 */
@RestController
public class HomeController implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private AuthorInfo authorInfo;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String index() {
        applicationEventPublisher.publishEvent(new LoginEvent("hello world"));
        System.out.println(authorInfo);
        return "hello world";
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
