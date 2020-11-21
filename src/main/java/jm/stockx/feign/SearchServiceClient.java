package jm.stockx.feign;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080")
public interface SearchServiceClient {

    @GetMapping(value = "/search?s={search}")
    CloseableHttpResponse getItemSearchDtoBySearch(@PathVariable("search") String search);
}
