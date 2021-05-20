package jm.stockx.http.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jm.stockx.feign.AuthRestVKServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthRestVKService {
    private final AuthRestVKServiceClient authRestVKServiceClient;

    @Autowired
    public AuthRestVKService(AuthRestVKServiceClient authRestVKServiceClient, ObjectMapper mapper) {
        this.authRestVKServiceClient = authRestVKServiceClient;
    }

    public String getUrl() {
        try {
            return authRestVKServiceClient.getUrl();
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }
}
