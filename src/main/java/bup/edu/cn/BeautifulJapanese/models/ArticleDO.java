package bup.edu.cn.BeautifulJapanese.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;

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
    private Boolean hot;
    private Date publishedAt;
    @OneToOne
    private TagDO tag;
    @OneToOne
    private CollectionDO collection;
}
