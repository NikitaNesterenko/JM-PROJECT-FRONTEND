package jm.stockx.http.service;

import com.vaadin.flow.component.notification.Notification;
import jm.stockx.dto.UserRegistrationDto;
import jm.stockx.feign.UserRegistrationServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class UserRegistrationService {

    private final UserRegistrationServiceClient client;

    @Autowired
    public UserRegistrationService(UserRegistrationServiceClient client) {
        this.client = client;
    }

    public void registerUser(UserRegistrationDto userRegistrationDto) {
        try {
            ResponseEntity<?> response = client.registrationNewUser(userRegistrationDto);
            if (response.getStatusCodeValue() == 200){
                Notification.show("You have been successfully registered");
            }
        } catch (Exception e) {
            Notification.show("Something went wrong");
            e.printStackTrace();
        }
    }
}