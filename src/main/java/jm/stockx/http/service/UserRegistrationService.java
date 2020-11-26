package jm.stockx.http.service;

import com.vaadin.flow.component.notification.Notification;
import jm.stockx.dto.UserRegistrationDto;
import jm.stockx.feign.UserRegistrationServiceClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserRegistrationService {

    private UserRegistrationServiceClient client;
    private CloseableHttpResponse response;

    @Autowired
    public UserRegistrationService(UserRegistrationServiceClient client) {
        this.client = client;
    }

    public UserRegistrationService() {
    }

    public boolean registerUser(UserRegistrationDto userRegistrationDto) {

        try {
            response = client.registerUser("Accept",
                    "Content-type",
                    userRegistrationDto);

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
