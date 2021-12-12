package iniedu.link.jpl.services;

import iniedu.link.jpl.Configs.BaseConfig;
import iniedu.link.jpl.models.VisitorDO;
import iniedu.link.jpl.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class VisitorService {
    @Autowired
    private VisitorRepository visitorRepository;

    public void setVisitor(HttpSession session, VisitorDO visitor) {
        session.setAttribute(BaseConfig.SESSION.KEY_VISITOR_ID, visitor.getId());
    }

    public VisitorDO getVisitor(HttpSession session) {
        Long id = (Long) session.getAttribute(BaseConfig.SESSION.KEY_VISITOR_ID);
        return visitorRepository.findVisitorDOById(id);
    }

}
