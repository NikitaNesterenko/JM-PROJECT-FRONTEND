package jm.stockx.controller;

import com.vaadin.flow.component.charts.AbstractChartExample;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.ChartType;
import com.vaadin.flow.component.charts.model.Configuration;
import com.vaadin.flow.component.charts.model.ListSeries;
import jm.stockx.dto.ItemPriceChartDto;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Setter
@Component
public class TestChart extends AbstractChartExample {


    public TestChart(ItemPriceChartDto item) {

        Chart chart = new Chart();

        Configuration config = chart.getConfiguration();

        config.getSubTitle().setText(item.getBrandName() + " " + item.getModelName());
        config.getChart().setType(ChartType.COLUMN);
        config.getTitle().setText("График изменения цены");
        config.getxAxis().setCategories("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");

        ListSeries ls = new ListSeries();
        config.addSeries(ls);

        ls.setName(item.getBrandName() + " " + item.getModelName());
        ls.setData(item.getPrices());

        add(chart);

    }

    @Override
    public void initDemo() {


    }


}

