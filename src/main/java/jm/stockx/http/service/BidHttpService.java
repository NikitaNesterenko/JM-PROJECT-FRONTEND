package jm.stockx.http.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jm.stockx.dto.BidPostDto;
import lombok.SneakyThrows;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class BidHttpService {

    @Value("${basic.url}")
    private String basicUrl;

    private final ObjectMapper mapper;

    public BidHttpService(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @SneakyThrows
    public void sendBid() {
        String result = "";

        HttpPost httpPost = new HttpPost(basicUrl + "/api/bid");
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        BidPostDto bidDto = new BidPostDto();
        bidDto.setUserId(1L);
        bidDto.setItemInfoId(1L);
        bidDto.setPrice("USD 200.0");

        String jsonEntity = mapper.writeValueAsString(bidDto);
        httpPost.setEntity(new StringEntity(jsonEntity));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(httpPost)) {
            result = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
