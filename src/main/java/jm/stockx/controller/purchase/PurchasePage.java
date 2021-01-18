package jm.stockx.controller.purchase;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import jm.stockx.components.purchase.InfoProductPage;
import jm.stockx.dto.ItemInfoDtoDecimal;
import jm.stockx.feign.PurchaseFeignRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Route("purchase")
@Scope("prototype")
@Component
public class PurchasePage extends VerticalLayout implements HasUrlParameter<String> {


    //final
    PurchaseFeignRestClient servicePurchase;
    private InfoProductPage productPageInfo;
    ItemInfoDtoDecimal itemInfoDtoDecimal;
    Long par;

    @Override
    public void setParameter(BeforeEvent event,
                             @OptionalParameter String parameter) {

        Location location = event.getLocation();
        QueryParameters queryParameters = location
                .getQueryParameters();

        Map<String, List<String>> parametersMap =
                queryParameters.getParameters();
        par = Long.valueOf(parametersMap.get("id").get(0));
        itemInfoDtoDecimal = servicePurchase.getItemInfoDtoDec(par).getBody();
        productPageInfo = new InfoProductPage(itemInfoDtoDecimal);
        add(productPageInfo);


    }

    @Autowired
    public PurchasePage(InfoProductPage productPage, PurchaseFeignRestClient servicePurchase) {
        this.servicePurchase = servicePurchase;
    }

}
