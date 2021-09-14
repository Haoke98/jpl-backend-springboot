package bup.edu.cn.BeautifulJapanese.repository;

import bup.edu.cn.BeautifulJapanese.Model.ArticleTagDO;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ArticleTagRepository extends PagingAndSortingRepository<ArticleTagDO, Long> {
    ArticleTagDO findArticleTagDOById(Long id);
}
