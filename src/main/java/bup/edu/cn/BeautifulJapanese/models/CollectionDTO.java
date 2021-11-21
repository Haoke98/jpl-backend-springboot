package bup.edu.cn.BeautifulJapanese.models;

import lombok.Data;

import javax.persistence.OneToMany;
import java.util.List;

@Data
public class CollectionDTO {
    private Long id;
    private String title;
    private String subTitle;
    private String cover;
}
