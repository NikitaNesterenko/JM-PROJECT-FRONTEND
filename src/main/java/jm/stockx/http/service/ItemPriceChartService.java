package jm.stockx.http.service;


import jm.stockx.dto.ItemPriceChartDto;
import jm.stockx.feign.ItemPriceChartServiceClient;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class ItemPriceChartService {

    private final ItemPriceChartServiceClient client;

    @Autowired
    public ItemPriceChartService(ItemPriceChartServiceClient client) {

        this.client = client;

    }

    public ItemPriceChartDto getItemPriceChartDto(Long id) {

        return client.getDto(id);

    }

}
