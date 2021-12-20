package iniedu.link.jpl;

import iniedu.link.jpl.repository.VisitorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JplApplicationTests {
    @Autowired
    private VisitorRepository visitorRepository;

    @Test
    void testFirst() {
        System.out.println("visitors:" + visitorRepository.countBy());
    }
}
