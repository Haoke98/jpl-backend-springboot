package bup.edu.cn.BeautifulJapanese.repository;

import bup.edu.cn.BeautifulJapanese.Model.ArticleDO;
import bup.edu.cn.BeautifulJapanese.Model.TagDO;
import bup.edu.cn.BeautifulJapanese.Model.CollectionDO;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ArticleRepository extends PagingAndSortingRepository<ArticleDO, Long> {
    List<ArticleDO> findArticleDOByHot(boolean isHot);

    List<ArticleDO> findArticleDOByCollection(CollectionDO collection);

    List<ArticleDO> findArticleDOByTag(TagDO tag);
}
