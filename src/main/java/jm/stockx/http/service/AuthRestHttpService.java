package jm.stockx.http.service;

import jm.stockx.dto.UserLoginDto;
import jm.stockx.dto.UserTokenDto;
import jm.stockx.feign.AuthRestHttpServiceClient;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
@Slf4j
public class AuthRestHttpService {

    private final AuthRestHttpServiceClient authRestHttpServiceClient;
    private String role;

    @Autowired
    public AuthRestHttpService(AuthRestHttpServiceClient authRestHttpServiceClient) {
        this.authRestHttpServiceClient = authRestHttpServiceClient;
    }

    public String getToken(String username, String password) {

        UserLoginDto userLoginDto = new UserLoginDto(username, password, true);
        try {
            UserTokenDto userTokenDto =
                    authRestHttpServiceClient.getToken(
                            userLoginDto);
            this.role = userTokenDto.getRoleName();
            return userTokenDto.getToken();
        } catch (Exception e) {
            log.info(e.getMessage());
            return null;
        }
    }
}
