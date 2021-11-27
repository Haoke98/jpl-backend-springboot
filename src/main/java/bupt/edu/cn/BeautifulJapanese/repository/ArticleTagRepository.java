package bupt.edu.cn.BeautifulJapanese.repository;

import bupt.edu.cn.BeautifulJapanese.models.TagDO;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ArticleTagRepository extends PagingAndSortingRepository<TagDO, Long> {
    TagDO findArticleTagDOById(Long id);
}
