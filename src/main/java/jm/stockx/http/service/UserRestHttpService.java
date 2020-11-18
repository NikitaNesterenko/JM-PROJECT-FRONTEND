package jm.stockx.http.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jm.stockx.dto.UserDto;
import jm.stockx.http.service.exceptions.UserRestServiceException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserRestHttpService {
    private String requestUrl;
    private final CloseableHttpClient httpClient;

    public UserRestHttpService(CloseableHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public UserDto getLoggedInUser(String url) {
        HttpGet request = new HttpGet(requestUrl + url);
        String responseJson = null;
        try {
            responseJson = EntityUtils.toString(httpClient.execute(request).getEntity());
            return new ObjectMapper().readValue(responseJson, UserDto.class);
        } catch (IOException e) {
            throw new UserRestServiceException("Unauthorized user", e);
        }
    }

    public HttpResponse sendRecoveryLinkToEmail(String url, String email) {
        try {
            return httpClient.execute(new HttpGet(requestUrl + url + email));
        } catch (IOException e) {
            throw new UserRestServiceException("Invalid email", e);
        }
    }

    public HttpResponse activateAccountByToken(String url, int code) {
        try {
            return httpClient.execute(new HttpGet(requestUrl + url + code));
        } catch (IOException e) {
            throw new UserRestServiceException("Invalid token", e);
        }
    }

    public HttpResponse passwordRecovery(String url) {
        try {
            return httpClient.execute(new HttpPost(requestUrl + url));
        } catch (IOException e) {
            throw new UserRestServiceException("Password recovery error", e);
        }
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }
}
