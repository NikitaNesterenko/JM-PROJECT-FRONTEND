package jm.stockx.controller.registration;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("registration")
@CssImport("./styles/shared-styles.css")
public class RegistrationView extends VerticalLayout {

    Anchor toMainPage = new Anchor("https://stockx.com", "Back To Main Page");
    HorizontalLayout backToMainLayout = new HorizontalLayout(toMainPage);

    private RegistrationForm registrationForm;

    public RegistrationView() {
        addClassName("registration-view");
        setSizeUndefined();
        toMainPage.addClassName("toMainPage");
        backToMainLayout.addClassName("backToMainLayout");
        registrationForm = new RegistrationForm();
        registrationForm.setDefaultHorizontalComponentAlignment(
                Alignment.CENTER);

        Div content = new Div(registrationForm);
        content.addClassName("content");

        add(backToMainLayout, content);
    }
}
