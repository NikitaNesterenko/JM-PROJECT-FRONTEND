package jm.stockx.http.service;

import com.vaadin.flow.server.VaadinService;
import org.apache.http.client.methods.HttpRequestBase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;

@Service
public class UtilService {
    @Value("${authorization.header}")
    private String authorizationHeader;
    @Value("${token.prefix}")
    private String prefixToken;
    @Value("${cookie.token.name}")
    private String cookieTokenName;
    private String token;

    private void setTokenFromCookie() {
        Cookie[] cookies = VaadinService.getCurrentRequest().getCookies();
        for (Cookie cookie : cookies) {
            if (cookieTokenName.equals(cookie.getName())) {
                token = cookie.getValue();
            }
        }
    }

    public <T extends HttpRequestBase> void addTokenInHeader(T t) {
        setTokenFromCookie();
        if (token != null) {
            t.setHeader(authorizationHeader, prefixToken + token);
        }
    }
}
