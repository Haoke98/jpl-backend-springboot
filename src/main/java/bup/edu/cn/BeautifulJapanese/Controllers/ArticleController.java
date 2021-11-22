package bup.edu.cn.BeautifulJapanese.Controllers;

import bup.edu.cn.BeautifulJapanese.framework.RestResponse;
import bup.edu.cn.BeautifulJapanese.framework.SC;
import bup.edu.cn.BeautifulJapanese.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping
    RestResponse get(
            @RequestParam(required = false) Long tagId,
            @RequestParam(required = false) Boolean hot,
            @RequestParam(defaultValue = "1", required = false) Integer pageNo,
            @RequestParam(defaultValue = "5", required = false) Integer pageSize
    ) {
        if (pageNo <= 0) {
            return RestResponse.error(SC.INVALID_PARAM_VALUE, "pageNo取值应为[1,N]");
        }
        return new RestResponse().success(articleService.getAllDTO1(hot, tagId, pageNo - 1, pageSize));
    }
}
