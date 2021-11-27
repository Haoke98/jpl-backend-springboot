package bupt.edu.cn.BeautifulJapanese.Controllers;

import bupt.edu.cn.BeautifulJapanese.framework.RestResponse;
import bupt.edu.cn.BeautifulJapanese.framework.SC;
import bupt.edu.cn.BeautifulJapanese.models.ArticleDTO1;
import bupt.edu.cn.BeautifulJapanese.services.ArticleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "文章管理")
@RestController
@RequestMapping(path = "/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping
    RestResponse get(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) Long tagId,
            @RequestParam(required = false) Boolean hot,
            @RequestParam(defaultValue = "1", required = false) Integer pageNo,
            @RequestParam(defaultValue = "5", required = false) Integer pageSize
    ) {
        if (id != null) {
            ArticleDTO1 dto1 = articleService.getDTO1(id);
            if (dto1 == null) {
                return RestResponse.error(SC.SOURCE_NOT_FOUND);
            }
            return new RestResponse().success(dto1);
        }
        if (pageNo <= 0) {
            return RestResponse.error(SC.INVALID_PARAM_VALUE, "pageNo取值应为[1,N]");
        }
        return new RestResponse().success(articleService.getAllDTO1(hot, tagId, pageNo - 1, pageSize));
    }
}
