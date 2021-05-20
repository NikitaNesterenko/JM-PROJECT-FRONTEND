package jm.stockx.controller;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import jm.stockx.dto.ItemPriceChartDto;
import jm.stockx.http.service.ItemPriceChartService;
import org.springframework.beans.factory.annotation.Autowired;

@Route("test-chart")
public class TestView extends VerticalLayout {

    @Autowired
    public TestView(ItemPriceChartService itemPriceChartService, Long id) {
        ItemPriceChartDto item = itemPriceChartService.getItemPriceChartDto(id);
        add(new TestChart(item));
    }
}

