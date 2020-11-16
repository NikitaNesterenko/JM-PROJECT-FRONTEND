package jm.stockx.feign;

import jm.stockx.dto.UserLoginDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url = "http://localhost:8080")
public interface AuthRestHttpServiceClient {

    @PostMapping(value = "/auth/login")
    String getToken(@RequestHeader("Accept") String accept,
                    @RequestHeader("Content-type") String contentType,
                    @RequestHeader("Authorization") String bearerToken,
                    UserLoginDto userLoginDto);
}
