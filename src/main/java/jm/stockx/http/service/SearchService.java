package jm.stockx.http.service;

import jm.stockx.dto.ItemSearchDto;
import jm.stockx.feign.SearchServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class SearchService {

    private final SearchServiceClient client;

    @Autowired
    public SearchService(SearchServiceClient client) {
        this.client = client;
    }



    public List<ItemSearchDto> getItemSearchDtoBySearch(String search) {
        List<ItemSearchDto> searchItems = Collections.emptyList();

        try{

             searchItems = client.getItemSearchDtoBySearch(search);

        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return searchItems;
    }
}
