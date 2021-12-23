package iniedu.link.jpl.Configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

public class BaseConfig {
    @Component
    public static class API {
        public static String VERSION = "开心了吗:)";
        public static final String ENCODING = "UTF-8";

    }

    public static class REDIS {
        public static final String KEY_ACCESS_TOKEN = "redis_key_access_token";
    }

    public static class SESSION {
        public static final String KEY_LOGGED_IN_USER_ID = "session_key_login_user_id";
        public static final String KEY_VISITOR_ID = "session_key_visitor_id";
    }
}
