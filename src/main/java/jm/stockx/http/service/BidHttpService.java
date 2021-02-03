package jm.stockx.http.service;

import jm.stockx.dto.BidPostDto;
import jm.stockx.feign.BidHttpServiceClient;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BidHttpService {

    @Value("${basic.url}")
    private String basicUrl;

    @SneakyThrows
    public void sendBid() {

        //Temporary dto construction for testing
        BidPostDto bidDto = new BidPostDto();
        bidDto.setUserId(1L);
        bidDto.setItemInfoId(1L);
        bidDto.setPrice("USD 200.0");

    }
}
