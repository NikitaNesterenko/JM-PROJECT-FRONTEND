package jm.stockx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication()
@EnableFeignClients
@EntityScan("jm.stockx")
public class JmProjectFrontendApplication {
    public static void main(String[] args) {
        SpringApplication.run(JmProjectFrontendApplication.class, args);
    }
}
