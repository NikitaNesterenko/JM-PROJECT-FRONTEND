package jm.stockx.controller;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;
import jm.stockx.components.news.news_header.HeaderRowNewsPage;
import jm.stockx.controller.purchase.AllItemController;
import jm.stockx.controller.purchase.PurchasePage;

public class MainLayout extends AppLayout {

    HeaderRowNewsPage headerRowNewsPage = new HeaderRowNewsPage();

    public MainLayout() {
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        H1 logo = new H1("StockX CRM");
        logo.addClassName("logo");
        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), headerRowNewsPage);
        header.addClassName("header");
        header.setWidth("100%");
        header.expand(logo);
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        addToNavbar(header);
    }

    private void createDrawer() {
        RouterLink listLink = new RouterLink("List", AllItemController.class);
        listLink.setHighlightCondition(HighlightConditions.sameLocation());

        VerticalLayout createdLayout = new VerticalLayout(
                listLink,
                new RouterLink("Get Item", PurchasePage.class, "5"));
        addToDrawer(createdLayout);
    }
}
