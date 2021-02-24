package jm.stockx.http.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jm.stockx.feign.AuthRestVKServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthRestVKService {
    private final AuthRestVKServiceClient authRestVKServiceClient;
    private final ObjectMapper mapper;

    @Autowired
    public AuthRestVKService(AuthRestVKServiceClient authRestVKServiceClient, ObjectMapper mapper) {
        this.authRestVKServiceClient = authRestVKServiceClient;
        this.mapper = mapper;
    }

    public String getUrl() {
        try {
            return authRestVKServiceClient.getUrl();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
