package jm.stockx.controller.purchase;

import jm.stockx.dto.ItemInfoDtoDecimal;
import jm.stockx.feign.PurchaseFeignRestClient;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
//@RestController


@Component
@Scope("prototype")

public class ServicePurchase implements PurchaseFeignRestClient {
    @Override
    public ResponseEntity<List<ItemInfoDtoDecimal>> getWeather() {
        return null;
    }

    @Override
    public ResponseEntity<ItemInfoDtoDecimal> getItemInfoDtoDec(Long id) {
        return null;
    }
}
