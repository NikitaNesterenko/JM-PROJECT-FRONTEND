package jm.stockx.feign;

import jm.stockx.dto.UserDto;
import jm.stockx.interceptor.AddTokenInHeaderInterceptor;
import okhttp3.Interceptor;
import org.apache.http.HttpResponse;
import org.atmosphere.config.service.AtmosphereInterceptorService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "userrest")
public interface UserRestHttpServiceClient {

    @GetMapping(value = "{requestUrl}{url}", consumes = "application/json")
    UserDto getLoggedInUser(@PathVariable("requestUrl") String requestUrl,
                            @PathVariable("url") String url);

    @GetMapping(value = "{requestUrl}{url}{email}", consumes = "application/json")
    String sendRecoveryLinkToEmail(@PathVariable("requestUrl") String requestUrl,
                                   @PathVariable("url") String url,
                                   @PathVariable("email") String email);

    @GetMapping(value = "{requestUrl}{url}{code}", consumes = "application/json")
    HttpResponse activateAccountByToken(@PathVariable("requestUrl") String requestUrl,
                                        @PathVariable("url") String url,
                                        @PathVariable("code") int code);

    @PostMapping(value = "{requestUrl}{url}", consumes = "application/json")
    String passwordRecovery(@PathVariable("requestUrl") String requestUrl,
                            @PathVariable("url") String url);
}
