package jm.stockx.http.service;

import jm.stockx.feign.AuthRestGoogleServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthRestGoogleService {

    private final AuthRestGoogleServiceClient authRestGoogleServiceClient;

    @Autowired
    public AuthRestGoogleService(AuthRestGoogleServiceClient authRestGoogleServiceClient) {
        this.authRestGoogleServiceClient = authRestGoogleServiceClient;
    }

    public String getUrl() {
        try {
            return authRestGoogleServiceClient.getUrl();
        } catch (Exception e) {
            log.info(e.getMessage());
            return null;
        }
    }
}
