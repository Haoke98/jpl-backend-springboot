package bupt.edu.cn.BeautifulJapanese.services;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



@Service
public class TagService {
    public Pageable getPageable(Integer pageNo, Integer pageSize) {
        Sort.Order order1 = Sort.Order.desc("weight");
        Sort.Order order = Sort.Order.desc("createdAt");
        Sort sort = Sort.by(order1, order);
        return PageRequest.of(pageNo, pageSize, sort);
    }
}
