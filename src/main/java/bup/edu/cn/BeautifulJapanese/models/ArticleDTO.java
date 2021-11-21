package bup.edu.cn.BeautifulJapanese.models;

import lombok.Data;

import java.sql.Date;

@Data
public class ArticleDTO {
    private Long id;
    private String title;
    private String subTitle;
    private String cover;
    private String url;
    private Boolean hot;
    private Date publishedAt;
    private TagDO tag;

    public ArticleDTO() {
    }
}
