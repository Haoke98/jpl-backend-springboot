package iniedu.link.jpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@ComponentScan(basePackages = {"iniedu.link","io.github.Haoke98"})
public class JplApplication {

    public static void main(String[] args) {
        SpringApplication.run(JplApplication.class, args);
    }

}
