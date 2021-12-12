package iniedu.link.jpl.repository;

import iniedu.link.jpl.models.CollectionDO;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CollectionRepository extends PagingAndSortingRepository<CollectionDO, Long> {
    CollectionDO findCollectionDOById(Long id);
}
