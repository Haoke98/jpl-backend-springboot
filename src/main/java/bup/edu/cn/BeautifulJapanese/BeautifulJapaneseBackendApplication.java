package bup.edu.cn.BeautifulJapanese;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@ComponentScan(basePackages = {"bup.edu.cn.BeautifulJapanese","bup.edu.cn.BeautifulJapanese.framework"})
public class BeautifulJapaneseBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeautifulJapaneseBackendApplication.class, args);
	}

}
