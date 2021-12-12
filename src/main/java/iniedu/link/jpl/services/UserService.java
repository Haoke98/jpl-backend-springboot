package iniedu.link.jpl.services;

import iniedu.link.jpl.Configs.BaseConfig;
import iniedu.link.jpl.models.UserDO;
import iniedu.link.jpl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public UserDO getLoginUser(HttpSession session) {
        Long id = (Long) session.getAttribute(BaseConfig.SESSION.KEY_LOGED_IN_USER_ID);
        if (id == null) {
            return null;
        }
        return userRepository.findUserDOById(id);
    }

    public void setLoginUser(HttpSession session, UserDO user) {
        session.setAttribute(BaseConfig.SESSION.KEY_LOGED_IN_USER_ID, user.getId());
    }

    public void setVisitor(HttpSession session, UserDO user) {
        session.setAttribute(BaseConfig.SESSION.KEY_VISITOR, user);
    }

    public UserDO getVisitor(HttpSession session) {
        return (UserDO) session.getAttribute(BaseConfig.SESSION.KEY_VISITOR);
    }
}
