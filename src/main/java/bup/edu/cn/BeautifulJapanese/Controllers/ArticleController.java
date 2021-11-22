package bup.edu.cn.BeautifulJapanese.Controllers;

import bup.edu.cn.BeautifulJapanese.framework.RestResponse;
import bup.edu.cn.BeautifulJapanese.framework.SC;
import bup.edu.cn.BeautifulJapanese.repository.ArticleRepository;
import bup.edu.cn.BeautifulJapanese.repository.ArticleTagRepository;
import bup.edu.cn.BeautifulJapanese.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/article")
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleService articleService;

    @GetMapping(path = "/hot")
    RestResponse getHot() {
        return new RestResponse().success(articleRepository.findArticleDOByHot(true));
    }

    @GetMapping
    RestResponse get(
            @RequestParam(name = "tagId", required = false) Long tagId,
            @RequestParam(defaultValue = "1", required = false) Integer pageNo,
            @RequestParam(defaultValue = "5", required = false) Integer pageSize
    ) {
        if (pageNo <= 0) {
            return RestResponse.error(SC.INVALID_PARAM_VALUE,"pageNo取值应为[1,N]");
        }
        if (tagId == null) {
            return new RestResponse().success(articleService.getAllDTO1(pageNo - 1, pageSize));
        }
        return new RestResponse().success(articleService.getAllDTO1ByTag(tagId, pageNo-1, pageSize));
    }
}
