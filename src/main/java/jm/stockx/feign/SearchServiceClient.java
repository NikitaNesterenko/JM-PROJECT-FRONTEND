package jm.stockx.feign;

import jm.stockx.dto.ItemSearchDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "search",url = "http://localhost:8080")
public interface SearchServiceClient {

    @GetMapping(value = "/api/item/search")
    List<ItemSearchDto> getItemSearchDtoBySearch(@RequestParam(required = false, name = "s") String search);

}
