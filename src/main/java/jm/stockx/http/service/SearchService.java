package jm.stockx.http.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jm.stockx.dto.ItemSearchDto;
import jm.stockx.feign.SearchServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SearchService {


    private final SearchServiceClient client;
    //private final ObjectMapper mapper;

    @Autowired
    public SearchService(SearchServiceClient client) {
        this.client = client;
        //this.mapper = new ObjectMapper();
    }



    public List<ItemSearchDto> getItemSearchDtoBySearch(String search) {
        List<ItemSearchDto> searchItems = Collections.emptyList();

        try{

             searchItems = client.getItemSearchDtoBySearch(search);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return searchItems;
    }
}
