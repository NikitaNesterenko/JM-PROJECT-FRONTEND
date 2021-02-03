package jm.stockx.components.purchase;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.RouterLink;
import jm.stockx.controller.purchase.PurchasePage;
import jm.stockx.dto.ItemInfoDtoDecimal;
import jm.stockx.feign.PurchaseFeignRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//import java.awt.*;


@EnableFeignClients
@Scope("prototype")
@Component
public class TestPurshase extends VerticalLayout {
    private final VerticalLayout headPage = new VerticalLayout();
    private final Div buttonDivItem = new Div();
    //private Anchor blogItem = new Anchor();
    private final Div blogItem = new Div();
    PurchaseFeignRestClient servicePurchase;

    public void configurationPage() {
        final Grid<ItemInfoDtoDecimal> listItem = new Grid<>(ItemInfoDtoDecimal.class);
        TextField valueField = new TextField();
        valueField.setValue("ведите id товара");
        List<ItemInfoDtoDecimal> list = servicePurchase.getWeather().getBody();
        listItem.setItems(list);
        List<Long> listId = new ArrayList<>();
        for (ItemInfoDtoDecimal dtoDec: list) {
            listId.add(dtoDec.getId());
        }
        headPage.add(listItem);

        final Button buttoItemInfo = new Button("get Item",
                e -> {
                    Long idItem = Long.valueOf(valueField.getValue());
                    ItemInfoDtoDecimal itemInfoDtoDecimal = servicePurchase.getItemInfoDtoDec(idItem).getBody();
                    buttonDivItem.add(itemInfoDtoDecimal.toString());
                    headPage.add(buttonDivItem);
                });

        configureItemLink(listId);
        headPage.add(valueField, buttoItemInfo, blogItem);


    }

    @Autowired
    public TestPurshase(PurchaseFeignRestClient servicePurchase) {
        this.servicePurchase = servicePurchase;
        configurationPage();
        add(headPage);

    }

    public void configureItemLink(List<Long> list) {
       // blogItem.add("get ItemInfo");
       // blogItem.setHref("http://localhost:4446/purchase?id=1");
        for (Long aLong : list) {
            blogItem.add(new RouterLink(" id = " + aLong, PurchasePage.class, aLong.toString()));
            blogItem.add("|    |");
        }
       //blogItem.add(new RouterLink("Gei Item", PurchasePage.class, "5"));

    }


}
