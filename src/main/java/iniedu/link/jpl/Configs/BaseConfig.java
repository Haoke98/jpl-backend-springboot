package iniedu.link.jpl.Configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

public class BaseConfig {
    @Component
    public static class API {
        public static String VERSION = "开心了吗:)";
        public static final String ENCODING = "UTF-8";
        @Value("${api_version}")
        private String _VERSION;

        @PostConstruct
        void initAIP() {
            VERSION = _VERSION;
            System.out.println(BaseConfig.API.VERSION);
        }
    }

    public static class REDIS {
        public static final String KEY_ACCESS_TOKEN = "redis_key_access_token";
    }

    public static class SESSION {
        public static final String KEY_LOGIN_USER = "session_key_login_user";
        public static final String KEY_LOGED_IN_USER_ID = "session_key_login_user_id";
        public static final String KEY_VISITOR = "session_key_visitor";
    }
}
