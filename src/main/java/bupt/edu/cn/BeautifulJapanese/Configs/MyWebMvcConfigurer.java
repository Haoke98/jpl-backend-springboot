package bupt.edu.cn.BeautifulJapanese.Configs;


import bupt.edu.cn.BeautifulJapanese.framework.auth.AuthenticationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器注册配置
 *
 * @author 萨达木（Sadam)
 * @date 2021/11/11 10:37
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
    @Bean
    AuthenticationInterceptor addInterceptor() {
        return new AuthenticationInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(addInterceptor());
        registration.addPathPatterns("/**");
        registration.excludePathPatterns(
                "/swagger-ui/**",
                "/swagger-resources/**",
                "/v2/**"
        );
    }
}
