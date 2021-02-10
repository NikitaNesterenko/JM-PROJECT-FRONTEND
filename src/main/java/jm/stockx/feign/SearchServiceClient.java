package jm.stockx.feign;

import jm.stockx.dto.ItemSearchDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "search",url = "http://localhost:8080")
public interface SearchServiceClient {

    @GetMapping(value = "/rest/api/item/search?s={search}")
    List<ItemSearchDto> getItemSearchDtoBySearch(@PathVariable("search") String search);

}
