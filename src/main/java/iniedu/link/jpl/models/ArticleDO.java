package iniedu.link.jpl.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * 文章实体类（模型）
 *
 * @author 萨达木(sadam)
 * @date 2021/11/23 2:17
 */
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity(name = "jpl_article")
public class ArticleDO {

    @Id
    @GeneratedValue
    private Long id;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
    private Date deletedAt;
    private String title;
    private String subTitle;
    private String cover;
    private String url;
    private Boolean hot = false;//是否热门
    private Date publishedAt;
    @Column(nullable = false,columnDefinition = "bigint default 0")
    private Long hasBeenReadTimes = 0L;//被阅读次数
    @OneToOne
    private TagDO tag;
    @OneToOne
    private CollectionDO collection;

    /**
     * 文章被阅读
     * ---阅读次数自增一
     */
    public void read() {
        this.hasBeenReadTimes++;
    }
}
