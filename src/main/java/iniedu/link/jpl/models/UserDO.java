package iniedu.link.jpl.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Entity(name = "users")
public class UserDO extends VisitorDO {
    @Column(unique = true)
    private String username;
    private String password;

    public UserDO() {
    }


}
