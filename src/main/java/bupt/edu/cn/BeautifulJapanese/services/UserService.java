package bupt.edu.cn.BeautifulJapanese.services;

import bupt.edu.cn.BeautifulJapanese.Configs.BaseConfig;
import bupt.edu.cn.BeautifulJapanese.models.UserDO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserService {
    public UserDO getLoginUser(HttpSession session) {
        return (UserDO) session.getAttribute(BaseConfig.SESSION.KEY_LOGIN_USER);
    }

    public void setVisitor(HttpSession session, UserDO user) {
        session.setAttribute(BaseConfig.SESSION.KEY_VISITOR, user);
    }

    public UserDO getVisitor(HttpSession session) {
        return (UserDO) session.getAttribute(BaseConfig.SESSION.KEY_VISITOR);
    }
}
