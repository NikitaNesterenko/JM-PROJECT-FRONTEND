package jm.stockx.http.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jm.stockx.dto.UserDto;
import jm.stockx.feign.UserRestHttpServiceClient;
import jm.stockx.http.service.exceptions.UserRestServiceException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserRestHttpService {
    private String requestUrl;
    private final UserRestHttpServiceClient client;

    @Autowired
    public UserRestHttpService(UserRestHttpServiceClient client) {
        this.client = client;
    }

    public UserDto getLoggedInUser(String url) {
        String responseJson = null;
        try {
            responseJson = EntityUtils.toString((HttpEntity) client.getLoggedInUser(requestUrl, url));
            return new ObjectMapper().readValue(responseJson, UserDto.class);
        } catch (IOException e) {
            throw new UserRestServiceException("Unauthorized user", e);
        }
    }

    public HttpResponse sendRecoveryLinkToEmail(String url, String email) {
        try {
            return client.sendRecoveryLinkToEmail(requestUrl, url, email);
        } catch (Exception e) {
            throw new UserRestServiceException("Invalid email", e);
        }
    }

    public HttpResponse activateAccountByToken(String url, int code) {
        try {
            return client.activateAccountByToken(requestUrl, url, code);
        } catch (Exception e) {
            throw new UserRestServiceException("Invalid token", e);
        }
    }

    public HttpResponse passwordRecovery(String url) {
        try {
            return client.passwordRecovery(requestUrl, url);
        } catch (Exception e) {
            throw new UserRestServiceException("Password recovery error", e);
        }
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }
}
