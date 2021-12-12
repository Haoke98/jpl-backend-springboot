package iniedu.link.jpl.repository;

import iniedu.link.jpl.models.UserDO;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<UserDO, Long> {
    UserDO findUserDOById(Long id);
}
