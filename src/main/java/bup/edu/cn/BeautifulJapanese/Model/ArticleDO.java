package bup.edu.cn.BeautifulJapanese.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.sql.Date;

@Setter
@Getter
@Entity(name = "jpl_article")
public class ArticleDO {

    @Id
    @GeneratedValue
    private Long id;
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getCover() {
        return "http://59.110.225.84/" + cover;
    }
}
