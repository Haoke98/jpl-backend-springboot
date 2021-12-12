package iniedu.link.jpl.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Entity(name = "users")
public class UserDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
    private Date deletedAt;
    private Date visitAt;//上次浏览开始
    private Date breathAt;//上次浏览最后一次呼吸访问时间
    private String ip;
    private Integer visitTimes = 0;

    public UserDO(String ip) {
        this.ip = ip;
    }

    public UserDO() {

    }

    public void visit() {
        this.visitAt = new Date();
    }

    public void breath() {
        this.breathAt = new Date();
    }
}
