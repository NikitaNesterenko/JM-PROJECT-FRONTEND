package jm.stockx.controller;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.server.VaadinService;
import jm.stockx.http.service.ItemPriceChartService;
import org.springframework.beans.factory.annotation.Autowired;

@Route("test-chart")
public class TestView extends VerticalLayout {

    public TestView(ItemPriceChartService service) {

        add(new TestChart(service.getItemPriceChartDto(1L)));

    }

}

