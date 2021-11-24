package bup.edu.cn.BeautifulJapanese.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CommonService {
    @Value("${BASE_URL}")
    private String BASE_URL;

    public String getFullCoverUrl(String shortUrl) {
        if (shortUrl.startsWith("http")) {
            return shortUrl;
        }
        return BASE_URL + shortUrl;
    }
}
