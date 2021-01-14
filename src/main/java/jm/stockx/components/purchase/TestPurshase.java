package jm.stockx.components.purchase;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import jm.stockx.dto.ItemInfoDtoDecimal;
import jm.stockx.feign.PurchaseFeignRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//import java.awt.*;


@EnableFeignClients
@Scope("prototype")
@Component
public class TestPurshase extends VerticalLayout {
    private VerticalLayout headPage = new VerticalLayout();
    private Div buttonDivItem = new Div();
    private Anchor blogItem = new Anchor();


   // final
    PurchaseFeignRestClient servicePurchase;

    public void configurationPage() {
        final Grid<ItemInfoDtoDecimal> listItem = new Grid<ItemInfoDtoDecimal>(ItemInfoDtoDecimal.class);
        TextField valueField = new TextField();
        valueField.setValue("ведите id товара");

                    listItem.setItems(servicePurchase.getWeather().getBody());
                    headPage.add(listItem);

        final Button buttoItemInfo = new Button("get Item",
                e -> {
                    Long idItem = Long.valueOf(valueField.getValue());
                    ItemInfoDtoDecimal itemInfoDtoDecimal = servicePurchase.getItemInfoDtoDec(idItem).getBody();
                    buttonDivItem.add(itemInfoDtoDecimal.toString());
                    headPage.add(buttonDivItem);
                });

        configureItemLink ();
        headPage.add(valueField, buttoItemInfo, blogItem);

    }

    @Autowired
    public TestPurshase(PurchaseFeignRestClient servicePurchase) {
        this.servicePurchase = servicePurchase;
        configurationPage();
        add(headPage);

    }

    public void configureItemLink () {
        blogItem.add("get ItemInfo");
        blogItem.setHref("http://localhost:4446/purchase?id=1");

    }



}
