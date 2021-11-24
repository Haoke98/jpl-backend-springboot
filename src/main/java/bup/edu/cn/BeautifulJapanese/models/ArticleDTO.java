package bup.edu.cn.BeautifulJapanese.models;

import bup.edu.cn.BeautifulJapanese.utils.TimeUtils;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.standard.DateTimeFormatterFactory;

import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
public class ArticleDTO {
    private Long id;
    private String title;
    private String subTitle;
    private String cover;
    private String url;
    private Boolean hot;
    private String publishedAt;
    private Long hasBeenReadTimes;
    private TagDO tag;

    public ArticleDTO(ArticleDO article, String cover) {
        id = article.getId();
        title = article.getTitle();
        subTitle = article.getSubTitle();
        hot = article.getHot();
        url = article.getUrl();
        publishedAt = TimeUtils.getDateString(article.getPublishedAt());
        hasBeenReadTimes = article.getHasBeenReadTimes();
        tag = article.getTag();
        this.cover = cover;
    }
    public ArticleDTO(){}
}
