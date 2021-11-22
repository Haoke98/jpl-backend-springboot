package bup.edu.cn.BeautifulJapanese.models;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleDTO {
    private Long id;
    private String title;
    private String subTitle;
    private String cover;
    private String url;
    private Boolean hot;
    private Date publishedAt;
    private Long hasBeenReadTimes;
    private TagDO tag;

    public ArticleDTO(ArticleDO article, String cover) {
        id = article.getId();
        title = article.getTitle();
        subTitle = article.getSubTitle();
        hot = article.getHot();
        url = article.getUrl();
        publishedAt = article.getPublishedAt();
        hasBeenReadTimes = article.getHasBeenReadTimes();
        tag = article.getTag();
        this.cover = cover;
    }
}
