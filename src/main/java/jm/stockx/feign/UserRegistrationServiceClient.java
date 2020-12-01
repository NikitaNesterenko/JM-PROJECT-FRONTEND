package jm.stockx.feign;

import jm.stockx.dto.Response;
import jm.stockx.dto.UserRegistrationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "registration", url = "http://localhost:8080")
public interface UserRegistrationServiceClient {

    @PostMapping(value = "/registration",  consumes = "application/json")
    String registerUser(@RequestBody UserRegistrationDto userRegistrationDto);

}