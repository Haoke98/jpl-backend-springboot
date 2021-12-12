package iniedu.link.jpl.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Entity(name = "jpl_collection")
public class CollectionDO {
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
    @OneToMany
    private List<ArticleDO> articles;
}
