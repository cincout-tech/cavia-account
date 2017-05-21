package cn.cincout.cavia.cloud.account.domain.resource;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-5-12
 * @sine 1.8
 */

@Entity
@Table(name = "t_resource")

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"id", "title", "link"})
@EqualsAndHashCode
@Builder
public class Resource implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @Column(columnDefinition="TEXT")
    private String abstractContent;
    private String origin;
    @Column(unique = true)
    private String link;

    // tag1;tag2;tag3
    private String tags;
    private String categories;

    private Long accountId;
    private Long likeCount;
    private Long view;

    private Long createTime;
}
