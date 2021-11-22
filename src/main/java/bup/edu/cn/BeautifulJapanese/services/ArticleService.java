package bup.edu.cn.BeautifulJapanese.services;

import bup.edu.cn.BeautifulJapanese.models.ArticleDO;
import bup.edu.cn.BeautifulJapanese.models.ArticleDTO;
import bup.edu.cn.BeautifulJapanese.models.ArticleDTO1;
import bup.edu.cn.BeautifulJapanese.models.TagDO;
import bup.edu.cn.BeautifulJapanese.repository.ArticleRepository;
import bup.edu.cn.BeautifulJapanese.repository.ArticleTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 文章服务
 *
 * @author 萨达木（sadam)
 * @date 2021/11/21 12:35
 */
@Service
public class ArticleService {
    @Value("${BASE_URL}")
    private String BASE_URL;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CollectionService collectionService;
    @Autowired
    private ArticleTagRepository articleTagRepository;

    public Pageable getPageable(Integer pageNo, Integer pageSize) {
        Sort.Order order = Sort.Order.desc("createdAt");
        Sort.Order order1 = Sort.Order.desc("hot");
        Sort sort = Sort.by(order, order1);
        return PageRequest.of(pageNo, pageSize, sort);
    }

    public Page<ArticleDO> getAll(Boolean hot, Long tagId, Integer pageNo, Integer pageSize) {
        if (hot == null) {
            if (tagId == null) {
                return articleRepository.findAll(getPageable(pageNo, pageSize));
            }
            TagDO tag = articleTagRepository.findArticleTagDOById(tagId);
            return articleRepository.findAllByTag(tag, getPageable(pageNo, pageSize));
        } else {
            if (tagId == null) {
                return articleRepository.findAllByHot(hot, getPageable(pageNo, pageSize));
            }
            TagDO tag = articleTagRepository.findArticleTagDOById(tagId);
            return articleRepository.findAllByTagAndHot(tag, hot, getPageable(pageNo, pageSize));
        }
    }

    public Page<ArticleDTO1> getAllDTO1(Boolean hot, Long tagId, Integer pageNo, Integer pageSize) {
        Page<ArticleDO> page = getAll(hot, tagId, pageNo, pageSize);
        return new PageImpl<>(getDTO1s(page.getContent()), page.getPageable(), page.getTotalElements());
    }

    public ArticleDTO getDTO(ArticleDO article) {
        ArticleDTO dto = new ArticleDTO();
        dto.setId(article.getId());
        dto.setTitle(article.getTitle());
        dto.setSubTitle(article.getSubTitle());
        dto.setHot(article.getHot());
        dto.setUrl(article.getUrl());
        dto.setPublishedAt(article.getPublishedAt());
        dto.setTag(article.getTag());
        if (article.getCover().startsWith("http")) {
            dto.setCover(article.getCover());
        } else {
            dto.setCover(BASE_URL + article.getCover());
        }
        return dto;
    }

    public List<ArticleDTO> getDTOs(List<ArticleDO> articles) {
        List<ArticleDTO> DTOs = new ArrayList<>();
        for (ArticleDO article :
                articles) {
            DTOs.add(getDTO(article));
        }
        return DTOs;
    }

    public ArticleDTO1 getDTO1(ArticleDO article) {
        ArticleDTO dto = getDTO(article);
        ArticleDTO1 dto1 = new ArticleDTO1(dto);
        dto1.setCollection(collectionService.getDTO(article.getCollection()));
        return dto1;
    }

    public List<ArticleDTO1> getDTO1s(List<ArticleDO> articles) {
        List<ArticleDTO1> dto1s = new ArrayList<>();
        for (ArticleDO article : articles) {
            dto1s.add(getDTO1(article));
        }
        return dto1s;
    }
}
