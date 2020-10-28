package jm.stockx.http.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.flow.component.notification.Notification;
import jm.stockx.dto.UserRegistrationDto;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    @Value("${basic.url}")
    String basicUrl;
    String postfix = "/registration";

    CloseableHttpClient httpClient;

    ObjectMapper objMapper;

    public UserRegistrationService() {
        this.httpClient = HttpClients.createDefault();
        this.objMapper = new ObjectMapper();
    }

    public void registerUser(UserRegistrationDto userRegistrationDto) {

        try {
            String jsonFromDto = objMapper.writeValueAsString(userRegistrationDto);

            StringEntity entity = new StringEntity(jsonFromDto);

            HttpPost httpPost = new HttpPost(basicUrl + postfix);

            httpPost.setEntity(entity);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json"); // вставляем заголовок

            CloseableHttpResponse response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == 200) {
                //HttpGet httpGet = new HttpGet(basicUrl + "/login");
                //httpClient.execute(httpGet);
            } else {
                Notification.show("Oops! Something went wrong.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
