package org.example.llm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.example.llm") // 최상위 패키지로 설정
public class LlmApplication {
	public static void main(String[] args) {
		SpringApplication.run(LlmApplication.class, args);
	}


}
