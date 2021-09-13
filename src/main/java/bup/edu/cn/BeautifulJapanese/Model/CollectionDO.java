package bup.edu.cn.BeautifulJapanese.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity(name = "collection")
public class CollectionDO {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String subTitle;
    private String cover;
    @OneToMany
    private List<ArticleDO> articles;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getCover() {
        return "https://japanese.izbasar.link/" + cover;
    }
}
