package jm.stockx.http.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jm.stockx.dto.ItemSearchDto;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SearchService {
    private CloseableHttpClient httpClient;
    private ObjectMapper mapper;
    @Value("${basic.url}")
    private String basicUrl;
    private static final String postfixUrl = "/search?s=";

    public SearchService() {
        this.httpClient = HttpClients.createDefault();
        this.mapper = new ObjectMapper();
    }

    public List<ItemSearchDto> getItemSearchDtoBySearch(String search) {
        List<ItemSearchDto> searchItems = Collections.emptyList();
        try {
            HttpGet httpGet = new HttpGet(basicUrl + postfixUrl + search);
            HttpResponse execute = httpClient.execute(httpGet);

            searchItems = mapper.readValue(execute.getEntity().getContent(), mapper
                    .getTypeFactory()
                    .constructCollectionType(List.class, ItemSearchDto.class));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return searchItems;
    }
}
