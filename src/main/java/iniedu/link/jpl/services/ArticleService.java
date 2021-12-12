package iniedu.link.jpl.services;

import iniedu.link.jpl.models.ArticleDO;
import iniedu.link.jpl.models.ArticleDTO;
import iniedu.link.jpl.models.ArticleDTO1;
import iniedu.link.jpl.models.TagDO;
import iniedu.link.jpl.repository.ArticleRepository;
import iniedu.link.jpl.repository.ArticleTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CollectionService collectionService;
    @Autowired
    private ArticleTagRepository articleTagRepository;
    @Autowired
    private CommonService commonService;

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
        return new ArticleDTO(article, commonService.getFullCoverUrl(article.getCover()));
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
        return new ArticleDTO1(article, commonService.getFullCoverUrl(article.getCover()), collectionService.getDTO(article.getCollection()));
    }

    public List<ArticleDTO1> getDTO1s(List<ArticleDO> articles) {
        List<ArticleDTO1> dto1s = new ArrayList<>();
        for (ArticleDO article : articles) {
            dto1s.add(getDTO1(article));
        }
        return dto1s;
    }

    public ArticleDTO1 getDTO1(Long id) {
        ArticleDO article = articleRepository.findArticleDOById(id);
        if (article != null) {
            article.read();
            articleRepository.save(article);
            return getDTO1(article);
        }
        return null;
    }
}
