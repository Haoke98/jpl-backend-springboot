package iniedu.link.jpl.framework.auth;

import iniedu.link.jpl.framework.SC;
import iniedu.link.jpl.framework.ServiceCode;
import iniedu.link.jpl.models.UserDO;
import iniedu.link.jpl.models.VisitorDO;
import iniedu.link.jpl.repository.RedisRepository;
import iniedu.link.jpl.repository.VisitorRepository;
import iniedu.link.jpl.services.UserService;
import iniedu.link.jpl.services.VisitorService;
import iniedu.link.jpl.utils.IPUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 请求拦截器
 * 主要作用是：鉴权
 *
 * @author 萨达木（Sadam)
 * @date 2021/11/11 10:38
 */
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisRepository redisRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private VisitorRepository visitorRepository;
    @Autowired
    private VisitorService visitorService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        boolean loginRequired = method.isAnnotationPresent(LoginRequired.class);
        boolean accessTokenRequired = method.isAnnotationPresent(AccessTokenRequired.class);
        if (accessTokenRequired) {
            String accessToken = request.getHeader("AccessToken");
            boolean access = redisRepository.getAccessToken().equals(accessToken);
            if (access) {
                //只要有正确的accessToken就通过
                return true;
            }
            //如果没有accessToken不正确就继续进行认证
        }
        //如果没有AccessTokenRequired注解  or  accessToken不正确，将继续执行以下步骤
        if (loginRequired) {
            //需要登录，而不需要accessToken，即普通用户访问
            UserDO user = userService.getLoginUser(request.getSession());
            if (user == null) {
                PrintWriter writer;
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json;charset=utf-8");
                writer = response.getWriter();
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("status", SC.UNAUTHORIZED);
                Field[] fields = SC.class.getDeclaredFields();
                for (Field field : fields) {
                    int x = field.getInt(new SC());
                    if (x == SC.UNAUTHORIZED) {
                        jsonObject.put("msg", field.getAnnotation(ServiceCode.class).msg());
                    }
                }
                writer.print(jsonObject);
                return false;
            } else {
                //如果需要登录，而且确实查询到了用户已登录状态，则准许请求继续
                return true;
            }
        }
        String ipAddress = IPUtils.getIpAddr(request);
        VisitorDO visitor = visitorService.getVisitor(request.getSession());
        if (visitor == null) {
            visitor = new VisitorDO();
            visitor.visit();
        }
        visitor.setIp(ipAddress);
        visitor.breath();
        visitorRepository.save(visitor);
        visitorService.setVisitor(request.getSession(), visitor);
        //如果不需要登录，也不需要accessToken，则直接让请求通过。
        return true;
    }
}
