package jm.stockx.feign;

import com.netflix.ribbon.proxy.annotation.Http;
import feign.Headers;
import org.atmosphere.config.service.AtmosphereInterceptorService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "google", url = "http://localhost:8080")
public interface AuthRestGoogleServiceClient {

    @GetMapping("/auth/url/google")
    String getUrl();

}
