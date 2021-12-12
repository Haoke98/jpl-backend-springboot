package iniedu.link.jpl.repository;

import iniedu.link.jpl.models.ArticleDO;
import iniedu.link.jpl.models.CollectionDO;
import iniedu.link.jpl.models.TagDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ArticleRepository extends PagingAndSortingRepository<ArticleDO, Long> {
    List<ArticleDO> findArticleDOByHot(boolean isHot);

    List<ArticleDO> findArticleDOByCollection(CollectionDO collection);

    List<ArticleDO> findArticleDOByTag(TagDO tag);

    Page<ArticleDO> findAllByHot(Boolean hot, Pageable pageable);
    Page<ArticleDO> findAllByTag(TagDO tag, Pageable pageable);
    Page<ArticleDO> findAllByTagAndHot(TagDO tag,Boolean hot, Pageable pageable);
    ArticleDO findArticleDOById(Long id);

}