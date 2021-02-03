package jm.stockx.feign;

import jm.stockx.dto.UserLoginDto;
import jm.stockx.dto.UserTokenDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "Aut", url = "http://localhost:8080")
public interface AuthRestHttpServiceClient {

    @PostMapping(value = "/api/auth/login",  consumes = "application/json")
    UserTokenDto getToken(@RequestBody UserLoginDto userLoginDto);
}