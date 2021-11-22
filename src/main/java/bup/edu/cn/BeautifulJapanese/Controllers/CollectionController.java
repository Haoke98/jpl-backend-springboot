package bup.edu.cn.BeautifulJapanese.Controllers;

import bup.edu.cn.BeautifulJapanese.framework.RestResponse;
import bup.edu.cn.BeautifulJapanese.framework.SC;
import bup.edu.cn.BeautifulJapanese.models.CollectionDTO1;
import bup.edu.cn.BeautifulJapanese.services.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/collection")
public class CollectionController {
    @Autowired
    private CollectionService collectionService;

    @GetMapping
    RestResponse get(
            @RequestParam(required = false) Long id,
            @RequestParam(defaultValue = "1", required = false) Integer pageNo,
            @RequestParam(defaultValue = "5", required = false) Integer pageSize) {
        if (id != null) {
            CollectionDTO1 dto1 = collectionService.getDTO1(id);
            if (dto1 == null) {
                return RestResponse.error(SC.SOURCE_NOT_FOUND);
            }
            return new RestResponse().success(dto1);
        }
        return new RestResponse().success(collectionService.getAllDTO1s(pageNo-1, pageSize));
    }
}
