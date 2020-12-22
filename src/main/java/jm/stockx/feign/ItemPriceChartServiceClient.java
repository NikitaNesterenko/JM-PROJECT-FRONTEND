package jm.stockx.feign;

import jm.stockx.dto.ItemPriceChartDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Component
@FeignClient(name = "chart", url = "http://localhost:8080")
public interface ItemPriceChartServiceClient {

    @GetMapping(value = "/api/rest/chart/get")
    ItemPriceChartDto getDto(@RequestParam Long id);

}
