package jm.stockx.feign;

import org.apache.http.HttpEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "google", url = "http://localhost:8080")
public interface AuthRestGoogleServiceClient {

    @GetMapping("/api/auth/url/google")
    String getUrl();
}
