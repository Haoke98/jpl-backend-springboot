package iniedu.link.jpl.models;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * 游客模型
 *
 * @author 萨达木(sadam)
 * @date 2021/12/13 1:27
 */
@Data
@EntityListeners(AuditingEntityListener.class)
@Entity(name = "visitors")
public class VisitorDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
    private Date deletedAt;
    /**
     * 游客访问时间
     * <p>
     * 也就是游客在当前会话中第一次访问我们某一个接口的时候
     */
    private Date visitAt;
    /**
     * 游客最后一次呼吸时间
     * <p>
     * 也就是游客在本次会话中最后一次向我们发起请求时间
     */
    private Date lastBreathAt;
    private String ip;

    public Integer getBreathTimes() {
        return breathTimes == null ? 0 : breathTimes;
    }

    /**
     * 游客在本次会话中总的呼吸次数
     * <p>
     * 也就是本次会话中游客发起请求总数
     * <p>
     * 能够发现游客的活跃性
     */
    @Column(nullable = false)
    private Integer breathTimes = 0;

    /**
     * 游客开始访问
     */
    public void visit() {
        this.visitAt = new Date();
    }

    /**
     * 游客呼吸
     * <p>
     * 把游客的每一次访问当做是最后一次访问来记录下来
     */
    public void breath() {
        this.lastBreathAt = new Date();
        this.breathTimes = this.getBreathTimes() + 1;
    }
}
