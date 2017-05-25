package cn.cincout.cavia.cloud.account.vo;

import lombok.*;
import org.springframework.http.HttpStatus;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-4-8
 * @sine 1.8
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HttpMessage<D> {
    private HttpStatus status;
    private D data;
    private Msg msg;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class Msg {
        private int code;
        private String info;
    }
}

