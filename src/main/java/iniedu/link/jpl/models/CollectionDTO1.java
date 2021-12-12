package iniedu.link.jpl.models;

import lombok.Data;

import java.util.List;

@Data
public class CollectionDTO1 {
    private Long id;
    private String title;
    private String subTitle;
    private String cover;
    private List<ArticleDTO> articles;

    public CollectionDTO1(CollectionDTO dto) {
        this.id = dto.getId();
        this.title = dto.getTitle();
        this.subTitle = dto.getSubTitle();
        this.cover = dto.getCover();
    }
}
