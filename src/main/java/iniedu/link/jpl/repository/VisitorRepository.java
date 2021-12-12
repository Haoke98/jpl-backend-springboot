package iniedu.link.jpl.repository;

import iniedu.link.jpl.models.VisitorDO;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VisitorRepository extends PagingAndSortingRepository<VisitorDO, Long> {
    VisitorDO findVisitorDOById(Long id);
}
