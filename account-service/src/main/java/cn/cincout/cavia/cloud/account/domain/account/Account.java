package cn.cincout.cavia.cloud.account.domain.account;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-4-8
 * @sine 1.8
 */
@Entity
@Table(name = "t_account")

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"id", "name", "email", "phoneNumber"})
@EqualsAndHashCode
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phoneNumber;
    private String password;

    private boolean enable;
    private long createdDate;
}
