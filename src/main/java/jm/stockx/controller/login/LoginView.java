package jm.stockx.controller.login;



import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinService;
import jm.stockx.http.service.AuthRestHttpService;
import org.apache.http.impl.client.HttpClients;

import javax.servlet.http.Cookie;

@Route("login")
@PageTitle("Login")
public class LoginView extends VerticalLayout implements BeforeEnterObserver {

    private LoginForm login = new LoginForm();
    private final AuthRestHttpService auth;
    public static final String COOKIE_TOKEN_NAME = "token";

    public LoginView(AuthRestHttpService auth) {
        this.auth = auth;
        addClassName("login-view");
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);


        login.addLoginListener(e -> {
            String token = auth.getToken(e.getUsername(), e.getPassword());
            if (token != null) {
                VaadinService.getCurrentResponse().addCookie(new Cookie(COOKIE_TOKEN_NAME, token));
                getUI().get().getPage().setLocation("/");
            } else {
                getUI().get().getPage().setLocation("/login");
            }
        });

        add(
                new H1("Vaadin Login"),
                login
        );
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if(beforeEnterEvent.getLocation()
                .getQueryParameters()
                .getParameters()
                .containsKey("error")) {
            login.setError(true);
        }
    }

}


