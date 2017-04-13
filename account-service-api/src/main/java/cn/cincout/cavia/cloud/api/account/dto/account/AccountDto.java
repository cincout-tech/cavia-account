package cn.cincout.cavia.cloud.api.account.dto.account;

import lombok.*;

import java.io.Serializable;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-4-3
 * @sine 1.8
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = {"id", "name"})
@EqualsAndHashCode(of = {"id", "name", "email", "phoneNumber"})
@Builder
public class AccountDto implements Serializable {

    private long id;
    private String name;
    private String email;
    private String phoneNumber;

    private boolean enable;
}
