package jm.stockx.http.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jm.stockx.feign.AuthRestGoogleServiceClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthRestGoogleService {

    private final AuthRestGoogleServiceClient authRestGoogleServiceClient;
    private final ObjectMapper mapper;

    @Autowired
    public AuthRestGoogleService(AuthRestGoogleServiceClient authRestGoogleServiceClient, ObjectMapper mapper) {
        this.authRestGoogleServiceClient = authRestGoogleServiceClient;
        this.mapper = mapper;
    }

    public String getUrl() {
        try {
//            return EntityUtils.toString(authRestGoogleServiceClient.getUrl());
            return authRestGoogleServiceClient.getUrl();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
