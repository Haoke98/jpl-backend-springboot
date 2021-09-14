package bup.edu.cn.BeautifulJapanese.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity(name = "article_tag")
public class ArticleTagDO {
    @Id
    @GeneratedValue
    private Long id;
    private String title;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
