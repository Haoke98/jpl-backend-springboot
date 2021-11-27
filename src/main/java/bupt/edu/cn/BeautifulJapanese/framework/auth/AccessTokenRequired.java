package bupt.edu.cn.BeautifulJapanese.framework.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 需要accessToken认证注解
 * @author 萨达木（sadam）
 * @date 2021/11/13 14:03
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AccessTokenRequired {
}
