package jm.stockx.http.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.flow.component.notification.Notification;
import jm.stockx.dto.UserRegistrationDto;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserRegistrationService {

    @Value("${basic.url}")
    private  String basicUrl = "http://localhost:8080";
    @Value("${reg.path}")
    private  String regPath = "/registration";

    private CloseableHttpClient httpClient;
    private ObjectMapper objMapper;
    private CloseableHttpResponse response;

    public UserRegistrationService() {
        this.httpClient = HttpClients.createDefault();
        this.objMapper = new ObjectMapper();
    }

    public boolean registerUser(UserRegistrationDto userRegistrationDto)  {

        try {
            String jsonFromDto = objMapper.writeValueAsString(userRegistrationDto);

            StringEntity entity = new StringEntity(jsonFromDto);

            HttpPost httpPost = new HttpPost(basicUrl + regPath);

            httpPost.setEntity(entity);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");

            response = httpClient.execute(httpPost);

            if (response.getStatusLine().getStatusCode() == 200) {
                Notification.show("You have been successfully registered");
                return true;
            }
        } catch (Exception e) {
            Notification.show("Something went wrong");
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
