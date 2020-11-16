package jm.stockx.http.service;

import jm.stockx.dto.UserLoginDto;
import jm.stockx.feign.AuthRestHttpServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthRestHttpService {

    private final AuthRestHttpServiceClient authRestHttpServiceClient;

    @Autowired
    public AuthRestHttpService(AuthRestHttpServiceClient authRestHttpServiceClient) {
        this.authRestHttpServiceClient = authRestHttpServiceClient;
    }

    public String getToken(String username, String password) {

        UserLoginDto userLoginDto = new UserLoginDto(username, password, true);

        try {
            return authRestHttpServiceClient.getToken("application/json",
                    "application/json",
                    "Bearer_" + null,
                    userLoginDto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
