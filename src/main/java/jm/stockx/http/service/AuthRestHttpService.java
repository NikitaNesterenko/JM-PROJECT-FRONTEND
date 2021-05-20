package jm.stockx.http.service;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import jm.stockx.dto.UserLoginDto;
import jm.stockx.dto.UserTokenDto;
import jm.stockx.feign.AuthRestHttpServiceClient;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Data
@Service
@Slf4j
public class AuthRestHttpService {

    private final AuthRestHttpServiceClient authRestHttpServiceClient;
    private String role;

    DateSecurityTokenGenerator dateSecurityTokenGenerator = new DateSecurityTokenGenerator();

    @Autowired
    public AuthRestHttpService(AuthRestHttpServiceClient authRestHttpServiceClient) {
        this.authRestHttpServiceClient = authRestHttpServiceClient;
    }
    @Bean
    public RequestInterceptor requestInterceptor() {

        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                template.header("Token", dateSecurityTokenGenerator.DateTokenCoder());
            }
        };
    }
    public String getToken(String username, String password) {

        UserLoginDto userLoginDto = new UserLoginDto(username, password, true);

        try {

            UserTokenDto userTokenDto =
                    authRestHttpServiceClient
                            .getToken( dateSecurityTokenGenerator.DateTokenCoder(),userLoginDto);
            this.role = userTokenDto.getRoleName();
            return userTokenDto.getToken();
        } catch (Exception e) {
            log.info(e.getMessage());
            return null;
        }
    }
}
