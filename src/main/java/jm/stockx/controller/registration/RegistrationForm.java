package jm.stockx.controller.registration;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import jm.stockx.dto.UserRegistrationDto;
import jm.stockx.http.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Controller
public class RegistrationForm extends VerticalLayout {



    @Value("${google.oauth2}")
    private static final String OAUTH_2_AUTHORIZATION_GOOGLE = "/oauth2/authorization/google";
    @Value("${facebook.oauth2}")
    private static final String OAUTH_2_AUTHORIZATION_FACEBOOK = "/oauth2/authorization/facebook";
    @Value("${apple.oauth2}")
    private static final String OAUTH_2_AUTHORIZATION_APPLE = "/oauth2/authorization/apple";
    @Value("${twitter.oauth2}")
    private static final String OAUTH_2_AUTHORIZATION_TWITTER = "/oauth2/authorization/twitter";

    private final Anchor googleLoginButton = new Anchor(OAUTH_2_AUTHORIZATION_GOOGLE, "Login with Google");
    private final Anchor facebookLoginButton = new Anchor(OAUTH_2_AUTHORIZATION_FACEBOOK, "Login with Facebook");
    private final Anchor appleLoginButton = new Anchor(OAUTH_2_AUTHORIZATION_APPLE, "Login with Apple");
    private final Anchor twitterLoginButton = new Anchor(OAUTH_2_AUTHORIZATION_TWITTER, "Login with Twitter");

    private final Text text = new Text("- or -");
    private final TextField firstName = new TextField();
    private final TextField lastName = new TextField();
    private final EmailField email = new EmailField();
    private final Checkbox checkbox = new Checkbox();
    private final Text text1 = new Text("By signing up, you agree to the");
    private final Anchor terms = new Anchor("https://stockx.com/terms", "Terms of Service");
    private final Text text2 = new Text("and");
    private final Anchor privacyPolicy = new Anchor("https://stockx.com/privacy", "Privacy Policy");
    private final HorizontalLayout checkboxLayout1 = new HorizontalLayout(checkbox, text1);
    private final HorizontalLayout checkboxLayout2 = new HorizontalLayout(terms, text2, privacyPolicy);
    private final Button signUp = new Button("Sign Up");

    public RegistrationForm(UserRegistrationService userRegistrationService) {
        googleLoginButton.addClassName("googleLoginButton");
        facebookLoginButton.addClassName("facebookLoginButton");
        appleLoginButton.addClassName("appleLoginButton");
        twitterLoginButton.addClassName("twitterLoginButton");
        firstName.setPlaceholder("First Name");
        firstName.addClassName("firstName");
        lastName.setPlaceholder("Last Name");
        lastName.addClassName("lastName");
        email.setPlaceholder("Email Address");
        email.addClassName("email");
        checkboxLayout1.addClassName("checkboxLayout1");
        checkboxLayout2.addClassName("checkboxLayout2");
        terms.addClassName("terms");
        privacyPolicy.addClassName("privacyPolicy");

        signUp.addClickShortcut(Key.ENTER);
        signUp.addClassName("signUp");

        signUp.addClickListener(event -> userRegistrationService.registerUser(
                new UserRegistrationDto(firstName.getValue(), lastName.getValue(), email.getValue())
        ));

        addClassName("registration-form");
        add(googleLoginButton,
                facebookLoginButton,
                appleLoginButton,
                twitterLoginButton,
                text,
                firstName,
                lastName,
                email,
                checkboxLayout1,
                checkboxLayout2,
                signUp
        );
    }
}

