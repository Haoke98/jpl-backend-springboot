package iniedu.link.jpl.models;

import lombok.Data;

@Data
public class ArticleDTO1 extends ArticleDTO {
    private CollectionDTO collection;

    public ArticleDTO1(ArticleDO article, String cover,CollectionDTO collection) {
        super(article, cover);
        this.collection = collection;
    }
}