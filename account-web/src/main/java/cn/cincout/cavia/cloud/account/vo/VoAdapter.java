package cn.cincout.cavia.cloud.account.vo;

import cn.cincout.cavia.cloud.account.api.dto.account.AccountDto;
import cn.cincout.cavia.cloud.account.api.dto.resource.ResourceDto;
import org.springframework.beans.BeanUtils;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-5-15
 * @sine 1.8
 */
public class VoAdapter {
    private VoAdapter() {}

    public static ResourceDto toDto(ResourceVo resourceVo) {
        if (resourceVo == null) {
            return null;
        }

        ResourceDto resourceDto = new ResourceDto();
        BeanUtils.copyProperties(resourceVo, resourceDto);
        return resourceDto;
    }

    public static AccountDto toDto(AccountVo accountVo) {
        if (accountVo == null) {
            return null;
        }
        return new AccountDto(
                accountVo.getUserName(),
                accountVo.getEmail(),
                accountVo.getPhoneNumber(),
                accountVo.getPassword(),
                Boolean.TRUE,
                System.currentTimeMillis()
        );
    }
}
