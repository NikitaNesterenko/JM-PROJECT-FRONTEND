package jm.stockx.feign;

import jm.stockx.dto.UserRegistrationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url = "http://localhost:8080")
public interface UserRegistrationServiceClient {

    @PostMapping(value = "/registration")
    boolean registerUser(@RequestHeader("Accept") String accept,
                         @RequestHeader("Content-type") String contentType,
                         UserRegistrationDto userRegistrationDto);
}
