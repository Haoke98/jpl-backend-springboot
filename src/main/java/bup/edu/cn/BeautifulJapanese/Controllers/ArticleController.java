package bup.edu.cn.BeautifulJapanese.Controllers;

import bup.edu.cn.BeautifulJapanese.Model.RestResponseDTO;
import bup.edu.cn.BeautifulJapanese.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/article")
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping(path = "/hot")
    RestResponseDTO getHot() {
        return RestResponseDTO.success(articleRepository.findArticleDOByHot(true));
    }
}
