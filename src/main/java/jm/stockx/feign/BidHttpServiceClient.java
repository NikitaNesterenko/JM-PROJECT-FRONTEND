package jm.stockx.feign;

import jm.stockx.dto.BidPostDto;
import org.apache.http.HttpEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "bid",url = "http://localhost:8080")
public interface BidHttpServiceClient {

    @PostMapping(value = "/api/bid", consumes = "application/json")
    String sendBid(
                    @RequestBody BidPostDto bidPostDto);
}
