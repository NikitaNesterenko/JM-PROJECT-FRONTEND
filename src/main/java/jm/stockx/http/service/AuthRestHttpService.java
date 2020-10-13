package jm.stockx.http.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.flow.server.VaadinService;
import jm.stockx.controller.login.LoginView;
import jm.stockx.dto.UserLoginDto;
import jm.stockx.dto.UserTokenDto;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;

@Service
public class AuthRestHttpService {
    private CloseableHttpClient httpClient;
    private ObjectMapper mapper;
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer_";
    private static final String URI = "http://localhost:8080/auth/login";

    public AuthRestHttpService() {
        this.httpClient = HttpClients.createDefault();
        this.mapper = new ObjectMapper();
    }

    public String getToken(String username, String password) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            HttpPost httpPost = new HttpPost(URI);
            String jsonEntity = mapper.writeValueAsString(new UserLoginDto(username, password, true));
            httpPost.setEntity(new StringEntity(jsonEntity));
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            HttpResponse response = httpClient.execute(httpPost);
            UserTokenDto userTokenDto = mapper.readValue(response.getEntity().getContent(), UserTokenDto.class);

            return userTokenDto.getToken();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private String getTokenFromCookie() {
        Cookie[] cookies = VaadinService.getCurrentRequest().getCookies();
        for (Cookie cookie : cookies) {
            if (LoginView.COOKIE_TOKEN_NAME.equals(cookie.getName())) {
                return cookie.getValue();
            }
        }
        return null;
    }

    public <T extends HttpRequestBase> T addTokenInHeader(T t) {
        String token = getTokenFromCookie();
        if (token != null) {
            t.setHeader(AUTHORIZATION_HEADER, TOKEN_PREFIX + token);
            return t;
        }
        return null;
    }
}
