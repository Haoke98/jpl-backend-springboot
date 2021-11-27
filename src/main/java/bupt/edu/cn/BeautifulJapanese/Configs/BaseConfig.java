package bupt.edu.cn.BeautifulJapanese.Configs;

public class BaseConfig {
    public static class API {
        public static final String VERSION = "v1.0.0";
        public static final String ENCODING = "UTF-8";

    }
    public static class REDIS {
        public static final String KEY_ACCESS_TOKEN = "redis_key_access_token";
    }
    public static class SESSION {
        public static final String KEY_LOGIN_USER="session_key_login_user";
        public static final String KEY_VISITOR="session_key_visitor";
    }
}
