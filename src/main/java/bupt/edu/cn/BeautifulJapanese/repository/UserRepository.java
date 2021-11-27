package bupt.edu.cn.BeautifulJapanese.repository;

import bupt.edu.cn.BeautifulJapanese.models.UserDO;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<UserDO,Long> {
}
