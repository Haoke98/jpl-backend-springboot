package bup.edu.cn.BeautifulJapanese.services;

import bup.edu.cn.BeautifulJapanese.models.CollectionDO;
import bup.edu.cn.BeautifulJapanese.models.CollectionDTO;
import bup.edu.cn.BeautifulJapanese.models.CollectionDTO1;
import bup.edu.cn.BeautifulJapanese.repository.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollectionService {
    @Value("${BASE_URL}")
    private String BASE_URL;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CollectionRepository collectionRepository;

    public CollectionDTO getDTO(CollectionDO collection) {
        CollectionDTO dto = new CollectionDTO();
        dto.setId(collection.getId());
        dto.setTitle(collection.getTitle());
        dto.setSubTitle(collection.getSubTitle());
        if (collection.getCover().startsWith("http")) {
            dto.setCover(collection.getCover());
        } else {
            dto.setCover(BASE_URL + collection.getCover());
        }
        return dto;
    }

    public CollectionDTO1 getDTO1(CollectionDO collection) {
        CollectionDTO dto = getDTO(collection);
        CollectionDTO1 dto1 = new CollectionDTO1(dto);
        dto1.setArticles(articleService.getDTOs(collection.getArticles()));
        return dto1;
    }

    public CollectionDTO1 getDTO1(Long id) {
        CollectionDO collection = collectionRepository.findCollectionDOById(id);
        if (collection != null) {
            return getDTO1(collection);
        }
        return null;
    }

    Pageable getPageable(Integer pageNo, Integer pageSize) {
        Sort.Order order = Sort.Order.desc("createdAt");
        Sort sort = Sort.by(order);
        return PageRequest.of(pageNo, pageSize, sort);
    }

    public Page<CollectionDO> getAll(Integer pageNo, Integer pageSize) {
        return collectionRepository.findAll(getPageable(pageNo, pageSize));
    }

    public List<CollectionDTO1> getDTO1s(List<CollectionDO> collections) {
        List<CollectionDTO1> dto1s = new ArrayList<>();
        for (CollectionDO c : collections) {
            dto1s.add(getDTO1(c));
        }
        return dto1s;
    }

    public Page<CollectionDTO1> getAllDTO1s(Integer pageNo, Integer pageSize) {
        Page<CollectionDO> page = getAll(pageNo, pageSize);
        return new PageImpl<>(getDTO1s(page.getContent()), page.getPageable(), page.getTotalElements());
    }
}
