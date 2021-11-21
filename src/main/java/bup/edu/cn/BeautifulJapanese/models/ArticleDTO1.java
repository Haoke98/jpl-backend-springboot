package bup.edu.cn.BeautifulJapanese.models;

import lombok.Data;

import java.sql.Date;

@Data
public class ArticleDTO1 {
    private Long id;
    private String title;
    private String subTitle;
    private String cover;
    private String url;
    private Boolean hot;
    private Date publishedAt;
    private TagDO tag;
    private CollectionDTO collection;

    public ArticleDTO1(ArticleDTO dto) {
        this.id = dto.getId();
        this.title = dto.getSubTitle();
        this.subTitle = dto.getSubTitle();
        this.cover = dto.getCover();
        this.url = dto.getCover();
        this.hot = dto.getHot();
        this.publishedAt = dto.getPublishedAt();
        this.tag = dto.getTag();
    }
}
