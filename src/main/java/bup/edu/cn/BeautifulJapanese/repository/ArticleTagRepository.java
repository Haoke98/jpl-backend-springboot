package bup.edu.cn.BeautifulJapanese.repository;

import bup.edu.cn.BeautifulJapanese.Model.TagDO;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ArticleTagRepository extends PagingAndSortingRepository<TagDO, Long> {
    TagDO findArticleTagDOById(Long id);
}
