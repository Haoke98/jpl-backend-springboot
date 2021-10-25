package bup.edu.cn.BeautifulJapanese.Controllers;

import bup.edu.cn.BeautifulJapanese.Model.ArticleDO;
import bup.edu.cn.BeautifulJapanese.Model.TagDO;
import bup.edu.cn.BeautifulJapanese.framework.RestResponseDTO;
import bup.edu.cn.BeautifulJapanese.repository.ArticleRepository;
import bup.edu.cn.BeautifulJapanese.repository.ArticleTagRepository;
import bup.edu.cn.BeautifulJapanese.repository.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/article")
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CollectionRepository collectionRepository;
    @Autowired
    private ArticleTagRepository articleTagRepository;

    @GetMapping(path = "/hot")
    RestResponseDTO getHot() {
        return RestResponseDTO.success(articleRepository.findArticleDOByHot(true));
    }

    @GetMapping(path = "/collection")
    RestResponseDTO getCollections() {
        return RestResponseDTO.success(collectionRepository.findAll());
    }

    @GetMapping(path = "/ByTag")
    RestResponseDTO getArticlesByTag(@RequestParam(name = "tagId", required = true, defaultValue = "-1") Long tagId) {
        if (tagId == 0) {
            return RestResponseDTO.success(articleRepository.findAll());
        } else {
            TagDO tag = articleTagRepository.findArticleTagDOById(tagId);
            List<ArticleDO> articles = articleRepository.findArticleDOByTag(tag);
            return RestResponseDTO.success(articles);
        }
    }


    @GetMapping(path = "/tag")
    RestResponseDTO getAllTags() {
        Sort.Order order = Sort.Order.asc("id");
        Sort sort = Sort.by(order);
        Pageable pageable = PageRequest.of(0, 10, sort);
        return RestResponseDTO.success(articleTagRepository.findAll(pageable));
    }
}
