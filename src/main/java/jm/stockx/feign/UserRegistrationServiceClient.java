package jm.stockx.feign;

import jm.stockx.dto.UserRegistrationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "Reg", url = "http://localhost:8080")
public interface UserRegistrationServiceClient {

    @PostMapping(value = "/api/registration",  consumes = "application/json")
    ResponseEntity<?> registrationNewUser(@RequestBody UserRegistrationDto userRegistrationDto);

}

