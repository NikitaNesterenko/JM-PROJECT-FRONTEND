package jm.stockx.feign;

import jm.stockx.dto.Response;
import jm.stockx.dto.UserRegistrationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "Reg", url = "http://localhost:8080")
public interface UserRegistrationServiceClient {

    @PostMapping(value = "/api/registration",  consumes = "application/json")
    Response registrationNewUser(@RequestBody UserRegistrationDto userRegistrationDto);

}