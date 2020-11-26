package jm.stockx.feign;

import jm.stockx.dto.BidPostDto;
import org.apache.http.HttpEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url = "http://localhost:8080")
public interface BidHttpServiceClient {

    @PostMapping(value = "/api/bid")
    HttpEntity sendBid(@RequestHeader("Accept") String accept,
                       @RequestHeader("Content-type") String contentType,
                       @RequestHeader("Authorization") String bearerToken,
                       BidPostDto bidPostDto);
}
