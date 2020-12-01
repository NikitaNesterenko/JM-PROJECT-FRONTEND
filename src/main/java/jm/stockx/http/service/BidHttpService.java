package jm.stockx.http.service;

import jm.stockx.dto.BidPostDto;
import jm.stockx.feign.BidHttpServiceClient;
import lombok.SneakyThrows;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

@Service
public class BidHttpService {

    @Value("${basic.url}")
    private String basicUrl;

    private final BidHttpServiceClient client;
    private final UtilService utilService;

    @Autowired
    public BidHttpService(BidHttpServiceClient client, UtilService utilService) {
        this.client = client;
        this.utilService = utilService;
    }

    @SneakyThrows
    public void sendBid() {
        String result = "";

        //Temporary dto construction for testing
        BidPostDto bidDto = new BidPostDto();
        bidDto.setUserId(1L);
        bidDto.setItemInfoId(1L);
        bidDto.setPrice("USD 200.0");

        try {
                        result =client.sendBid(
                    bidDto);
                        System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
