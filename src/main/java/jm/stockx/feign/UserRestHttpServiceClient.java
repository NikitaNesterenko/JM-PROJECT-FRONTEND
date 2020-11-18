package jm.stockx.feign;

import jm.stockx.dto.UserDto;
import org.apache.http.HttpResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url = "http://localhost:8080")
public interface UserRestHttpServiceClient {

    @GetMapping("/{requestUrl}/{url}")
    UserDto getLoggedInUser(@PathVariable("requestUrl") String requestUrl,
                            @PathVariable("url") String url);

    @GetMapping("/{requestUrl}/{url}/{email}")
    HttpResponse sendRecoveryLinkToEmail(@PathVariable("requestUrl") String requestUrl,
                                         @PathVariable("url") String url,
                                         @PathVariable("email") String email);

    @GetMapping("/{requestUrl}/{url}/{code}")
    HttpResponse activateAccountByToken(@PathVariable("requestUrl") String requestUrl,
                                        @PathVariable("url") String url,
                                        @PathVariable("code") String code);

    @PostMapping("/{requestUrl}/{url}")
    HttpResponse passwordRecovery(@PathVariable("requestUrl") String requestUrl,
                                  @PathVariable("url") String url);
}
