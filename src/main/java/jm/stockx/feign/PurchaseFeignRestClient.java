package jm.stockx.feign;

import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import jm.stockx.dto.ItemInfoDtoDecimal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@Scope("prototype")
@VaadinSessionScope

//@FeignClient(name = "data", url = "localhost:8080/api/item/allItem")
@FeignClient(name = "data", url = "localhost:8080")
public interface PurchaseFeignRestClient {
   // @Headers("Content-Type: application/json")
  //  @RequestMapping(method = RequestMethod.GET)
    @GetMapping (value = "/rest/api/item/allItem", consumes = "application/json")
    ResponseEntity<List<ItemInfoDtoDecimal>> getWeather();

    @GetMapping (value = "/rest/api/item/item", consumes = "application/json")
    ResponseEntity<ItemInfoDtoDecimal> getItemInfoDtoDec(@RequestParam(value="id") Long id);

}
