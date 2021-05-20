package jm.stockx.controller.purchase;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.Route;
import jm.stockx.components.purchase.InfoProductPage;
import jm.stockx.controller.MainLayout;
import jm.stockx.dto.ItemInfoDtoDecimal;
import jm.stockx.feign.PurchaseFeignRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Route(value = "purchase", layout = MainLayout.class)
@Scope("prototype")
@Component
public class PurchasePage extends VerticalLayout implements HasUrlParameter<String> {


    private final PurchaseFeignRestClient servicePurchase;

    @Override
    public void setParameter(BeforeEvent event,
                             @OptionalParameter String parameter) {


        Long par = Long.valueOf(parameter);
        ItemInfoDtoDecimal itemInfoDtoDecimal = servicePurchase.getItemInfoDtoDec(par).getBody();
        InfoProductPage productPageInfo = new InfoProductPage(itemInfoDtoDecimal);
        add(productPageInfo);
    }


    @Autowired
    public PurchasePage(PurchaseFeignRestClient servicePurchase) {
        this.servicePurchase = servicePurchase;
    }

}
