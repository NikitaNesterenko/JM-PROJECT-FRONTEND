package jm.stockx.http.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jm.stockx.dto.UserLoginDto;
import jm.stockx.dto.UserTokenDto;
import lombok.Data;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
@Data
@Service
public class AuthRestHttpService {
    @Value("${basic.url}")
    private String basicUrl;
    private String role;

    private CloseableHttpClient httpClient;
    private ObjectMapper mapper;
    private final String postfixUrl = "/auth/login";

    public AuthRestHttpService() {
        this.httpClient = HttpClients.createDefault();
        this.mapper = new ObjectMapper();
    }

    public String getToken(String username, String password) {
        try {
            String jsonEntity = mapper.writeValueAsString(new UserLoginDto(username, password, true));

            HttpPost httpPost = new HttpPost(basicUrl + postfixUrl);
            httpPost.setEntity(new StringEntity(jsonEntity));
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            HttpResponse response = httpClient.execute(httpPost);

            UserTokenDto userTokenDto = mapper.readValue(response.getEntity().getContent(), UserTokenDto.class);

            this.role = userTokenDto.getRole();

            return userTokenDto.getToken();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


}
