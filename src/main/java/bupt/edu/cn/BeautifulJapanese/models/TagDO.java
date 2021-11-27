package bupt.edu.cn.BeautifulJapanese.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Entity(name = "jpl_tag")
public class TagDO {
    @Id
    @GeneratedValue
    private Long id;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
    private Date deletedAt;
    private String title;
    private Integer weight;//权重：越高，排在越前
}
