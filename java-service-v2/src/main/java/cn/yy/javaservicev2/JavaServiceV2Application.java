package cn.yy.javaservicev2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class JavaServiceV2Application {

    public static void main(String[] args) {
        SpringApplication.run(JavaServiceV2Application.class, args);
    }

    @Bean
    public RestTemplate RestTemplate(){
        return new RestTemplate();
    }
}
