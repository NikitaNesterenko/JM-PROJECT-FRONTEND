package jm.stockx.http.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jm.stockx.dto.UserLoginDto;
import jm.stockx.dto.UserTokenDto;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AuthRestHttpService {
    @Value("${basic.url}")
    private String basicUrl;

    private final CloseableHttpClient httpClient;
    private ObjectMapper mapper;
    private final String postfixUrl = "/auth/login";

    public AuthRestHttpService(CloseableHttpClient httpClient) {
        this.httpClient = httpClient;
        this.mapper = new ObjectMapper();
    }

    public String getToken(String username, String password) {
        CloseableHttpResponse response = null;
        try {
            String jsonEntity = mapper.writeValueAsString(new UserLoginDto(username, password, true));

            HttpPost httpPost = new HttpPost(basicUrl + postfixUrl);
            httpPost.setEntity(new StringEntity(jsonEntity));
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            response = httpClient.execute(httpPost);

            UserTokenDto userTokenDto = mapper.readValue(response.getEntity().getContent(), UserTokenDto.class);
            return userTokenDto.getToken();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            try {
                assert response != null;
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
