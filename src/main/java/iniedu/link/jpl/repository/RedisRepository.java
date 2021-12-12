package iniedu.link.jpl.repository;

import iniedu.link.jpl.Configs.BaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * @author 萨达木（Sadam）
 * @date 2021/11/22 18:10
 */
@Repository
public class RedisRepository {
    @Autowired
    private RedisTemplate<String, String> template;

    public void setAccessToken(String accessToken) {
        template.boundValueOps(BaseConfig.REDIS.KEY_ACCESS_TOKEN).set(accessToken);
    }

    public String getAccessToken() {
        return template.boundValueOps(BaseConfig.REDIS.KEY_ACCESS_TOKEN).get();
    }

    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        template.opsForValue().set(key, value, timeout, timeUnit);
    }

    public String get(String key) {
        return template.opsForValue().get(key);
    }
}
