package jm.stockx.components.templates;

import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import jm.stockx.components.news.news_header.HeaderRowNewsPage;
import jm.stockx.components.purchase.InfoProductPage;

@Route("purchase")
public class PurchasePage extends VerticalLayout {
    private HeaderRowNewsPage navPanel = new HeaderRowNewsPage();
    private InfoProductPage productPage = new InfoProductPage();

    public PurchasePage() {
        add(productPage);
    }
}
