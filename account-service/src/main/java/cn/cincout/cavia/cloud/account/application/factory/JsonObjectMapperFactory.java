package cn.cincout.cavia.cloud.account.application.factory;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 16-12-11
 * @sine 1.0
 */
public enum JsonObjectMapperFactory {
    MAPPER;

    private ObjectMapper objectMapper;

    private JsonObjectMapperFactory() {
        this.objectMapper = new ObjectMapper();
    }

    public ObjectMapper instance() {
        return this.objectMapper;
    }
}
