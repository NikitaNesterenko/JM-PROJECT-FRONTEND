package jm.stockx.feign;

import jm.stockx.dto.UserDto;
import org.apache.http.HttpResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "userrest")
public interface UserRestHttpServiceClient {

    @GetMapping(value = "/rest/api/users/getLoggedInUser",  consumes = "application/json")
    UserDto getLoggedInUser();

    @GetMapping(value = "/rest/api/users/password-recovery/{email}",  consumes = "application/json")
    String sendRecoveryLinkToEmail(@PathVariable("email") String email);

    @GetMapping(value = "/rest/api/users/registration/{code}",  consumes = "application/json")
    HttpResponse activateAccountByToken(@PathVariable("code") int code);

    @PostMapping(value = "/rest/api/users/password-recovery",  consumes = "application/json")
    String passwordRecovery(@RequestParam(name = "token") String link,
                            @RequestParam(name = "password") String newPassword);
}
