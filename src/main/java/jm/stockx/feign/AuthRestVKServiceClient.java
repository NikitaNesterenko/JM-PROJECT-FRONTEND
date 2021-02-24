package jm.stockx.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "vk", url = "http://localhost:8080")
public interface AuthRestVKServiceClient {

    @GetMapping("/api/auth/url/vk")
    String getUrl();

}
