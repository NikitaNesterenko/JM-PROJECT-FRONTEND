package jm.stockx.controller.purchase;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import jm.stockx.components.purchase.TestPurshase;
import jm.stockx.controller.MainLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Route(value = "bids", layout = MainLayout.class)
public class AllItemController extends VerticalLayout {

    private final TestPurshase productPage;

    @Autowired
    public AllItemController(TestPurshase productPage) {
        this.productPage = productPage;
        add(productPage);
    }
}
