package jm.stockx;

import jm.stockx.dto.BidPostDto;
import jm.stockx.feign.BidHttpServiceClient;
import jm.stockx.http.service.BidHttpService;
import jm.stockx.http.service.UtilService;
//import jm.stockx.http.service.configuration.FeignConfig;
import jm.stockx.http.service.configuration.FeignConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication()
@EnableFeignClients(defaultConfiguration = FeignConfig.class)
@EntityScan("jm.stockx")
public class JmProjectFrontendApplication {

    public static void main(String[] args) {
        SpringApplication.run(JmProjectFrontendApplication.class, args);

    }


}
