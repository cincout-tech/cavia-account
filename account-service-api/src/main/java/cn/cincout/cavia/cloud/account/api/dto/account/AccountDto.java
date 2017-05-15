package cn.cincout.cavia.cloud.account.api.dto.account;

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
    private String password;

    private boolean enable;
    private long createdDate;

    public AccountDto(String name, String email,
                      String phoneNumber, boolean enable) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.enable = enable;
    }

    public AccountDto(String name, String email, String phoneNumber, String password, boolean enable, long createdDate) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.enable = enable;
        this.createdDate = createdDate;
    }
}
