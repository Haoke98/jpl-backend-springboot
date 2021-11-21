package bup.edu.cn.BeautifulJapanese.repository;

import bup.edu.cn.BeautifulJapanese.models.CollectionDO;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CollectionRepository extends PagingAndSortingRepository<CollectionDO, Long> {
    CollectionDO findCollectionDOById(Long id);
}
