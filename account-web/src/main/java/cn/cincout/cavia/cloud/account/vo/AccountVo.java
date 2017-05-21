package cn.cincout.cavia.cloud.account.vo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-3-17
 * @sine 1.8
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountVo implements Serializable {

    private String email;
    private String userName;
    private String phoneNumber;
    private String password;

}
