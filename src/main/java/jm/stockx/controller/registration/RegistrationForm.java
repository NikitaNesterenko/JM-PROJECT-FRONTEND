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

    private final UserRegistrationService userRegistrationService;


    @Value("${google.oauth2}")
    private String googleOAuth2 = "/oauth2/authorization/google";
    @Value("${facebook.oauth2}")
    private String facebookOAuth2 = "/oauth2/authorization/facebook";
    @Value("${apple.oauth2}")
    private String appleOAuth2 = "/oauth2/authorization/apple";
    @Value("${twitter.oauth2}")
    private String twitterOAuth2 = "/oauth2/authorization/twitter";

    private Anchor googleLoginButton = new Anchor(googleOAuth2, "Login with Google");
    private Anchor facebookLoginButton = new Anchor(facebookOAuth2, "Login with Facebook");
    private Anchor appleLoginButton = new Anchor(appleOAuth2, "Login with Apple");
    private Anchor twitterLoginButton = new Anchor(twitterOAuth2, "Login with Twitter");

    private Text text = new Text("- or -");
    private TextField firstName = new TextField();
    private TextField lastName = new TextField();
    private EmailField email = new EmailField();
    private Checkbox checkbox = new Checkbox();
    private Text text1 = new Text("By signing up, you agree to the");
    private Anchor terms = new Anchor("https://stockx.com/terms", "Terms of Service");
    private Text text2 = new Text("and");
    private Anchor privacyPolicy = new Anchor("https://stockx.com/privacy", "Privacy Policy");
    private HorizontalLayout checkboxLayout1 = new HorizontalLayout(checkbox, text1);
    private HorizontalLayout checkboxLayout2 = new HorizontalLayout(terms, text2, privacyPolicy);
    private Button signUp = new Button("Sign Up");

    public RegistrationForm(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
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

