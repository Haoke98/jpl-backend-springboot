package bup.edu.cn.BeautifulJapanese.Controllers;

import bup.edu.cn.BeautifulJapanese.framework.RestResponse;
import bup.edu.cn.BeautifulJapanese.repository.ArticleTagRepository;
import bup.edu.cn.BeautifulJapanese.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/tag")
@RestController
public class TagController {
    @Autowired
    private ArticleTagRepository articleTagRepository;
    @Autowired
    private TagService tagService;

    @GetMapping
    RestResponse get(
            @RequestParam(required = false) Long id,
            @RequestParam(defaultValue = "1", required = false) Integer pageNo,
            @RequestParam(defaultValue = "5", required = false) Integer pageSize
    ) {
        if (id == null) {
            return new RestResponse().success(articleTagRepository.findAll(tagService.getPageable(pageNo-1, pageSize)));
        }
        return new RestResponse().success(articleTagRepository.findArticleTagDOById(id));
    }
}
