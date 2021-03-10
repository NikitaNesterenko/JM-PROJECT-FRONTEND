package jm.stockx.components.errors;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.ErrorParameter;
import com.vaadin.flow.router.HasErrorParameter;
import com.vaadin.flow.router.NotFoundException;

import javax.servlet.http.HttpServletResponse;

@Tag(Tag.DIV)
public class RouteNotFoundError extends Component
        implements HasErrorParameter<NotFoundException> {


    @Override
    public int setErrorParameter(BeforeEnterEvent event,
                                 ErrorParameter<NotFoundException> parameter) {
        Notification notification = new Notification(
                "Что-то пошло не так", 3000);
        notification.open();
        notification.setPosition(Notification.Position.MIDDLE);

        return HttpServletResponse.SC_NOT_FOUND;
    }
}
