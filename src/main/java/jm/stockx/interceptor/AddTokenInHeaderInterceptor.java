
package jm.stockx.interceptor;

import com.vaadin.flow.server.VaadinService;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import java.util.Arrays;

@Configuration
@Slf4j
public class AddTokenInHeaderInterceptor implements RequestInterceptor{

    private String token;
    @Value("${cookie.token.name}")
    private String cookieTokenName;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        final Cookie[] cookies = VaadinService.getCurrentRequest().getCookies();
        final String url = requestTemplate.request().url();
        final String authUrl = "/auth/login";
        final String googleAuthUrl = "/auth/url/google";

        if (url.equals(authUrl) | url.equals(googleAuthUrl)) {
            return;
        }

        Arrays.stream(cookies).forEach(e -> {
            if (e.getName().equals(cookieTokenName))
                token = e.getValue();
        });

        requestTemplate.header("Authorization", token);
        System.out.println("hello intercepted2");
    }
}

