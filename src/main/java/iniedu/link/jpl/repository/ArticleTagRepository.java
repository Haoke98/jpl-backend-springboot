package iniedu.link.jpl.repository;

import iniedu.link.jpl.models.TagDO;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ArticleTagRepository extends PagingAndSortingRepository<TagDO, Long> {
    TagDO findArticleTagDOById(Long id);
}
