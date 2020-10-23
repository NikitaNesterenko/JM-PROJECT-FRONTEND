package jm.stockx.controller.registration;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;

public class RegistrationForm extends VerticalLayout {
    private static final String googleOAuth2 = "/oauth2/authorization/google";
    private static final String facebookOAuth2 = "/oauth2/authorization/facebook";
    private static final String appleOAuth2 = "/oauth2/authorization/apple";
    private static final String twitterOAuth2 = "/oauth2/authorization/twitter";

    Anchor googleLoginButton = new Anchor(googleOAuth2, "Login with Google");
    Anchor facebookLoginButton = new Anchor(facebookOAuth2, "Login with Facebook");
    Anchor appleLoginButton = new Anchor(appleOAuth2, "Login with Apple");
    Anchor twitterLoginButton = new Anchor(twitterOAuth2, "Login with Twitter");
    Text text = new Text("- or -");

    TextField firstName = new TextField();
    TextField lastName = new TextField();
    EmailField email = new EmailField();
    PasswordField password = new PasswordField();

    Checkbox checkbox = new Checkbox();
    Text text1 = new Text("By signing up, you agree to the");
    Anchor terms = new Anchor("https://stockx.com/terms", "Terms of Service");
    Text text2 = new Text("and");
    Anchor privacyPolicy = new Anchor("https://stockx.com/privacy", "Privacy Policy");
    HorizontalLayout checkboxLayout1 = new HorizontalLayout(checkbox, text1);
    HorizontalLayout checkboxLayout2 = new HorizontalLayout(terms, text2, privacyPolicy);

    Button signUp = new Button("Sign Up");

    public RegistrationForm() {
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
        password.setPlaceholder("Password");
        password.addClassName("password");
        checkboxLayout1.addClassName("checkboxLayout1");
        checkboxLayout2.addClassName("checkboxLayout2");
        terms.addClassName("terms");
        privacyPolicy.addClassName("privacyPolicy");
        signUp.addClickShortcut(Key.ENTER); // defines keyboard shortcut: enter to sign up
        signUp.addClassName("signUp");
        addClassName("registration-form");
        add(googleLoginButton,
                facebookLoginButton,
                appleLoginButton,
                twitterLoginButton,
                text,
                firstName,
                lastName,
                email,
                password,
                checkboxLayout1,
                checkboxLayout2,
                signUp
        );
    }
}