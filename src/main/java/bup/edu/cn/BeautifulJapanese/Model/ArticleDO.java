package bup.edu.cn.BeautifulJapanese.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Setter
@Getter
@Entity(name = "article")
public class ArticleDO {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String cover;
    private String url;
    private Boolean hot;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
