package jm.stockx.http.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jm.stockx.dto.ItemSearchDto;
import jm.stockx.feign.SearchServiceClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SearchService {

    private final SearchServiceClient client;
    private final ObjectMapper mapper;

    public SearchService(SearchServiceClient client) {
        this.client = client;
        this.mapper = new ObjectMapper();
    }

    public List<ItemSearchDto> getItemSearchDtoBySearch(String search) {
        List<ItemSearchDto> searchItems = Collections.emptyList();
        try (CloseableHttpResponse execute = client.getItemSearchDtoBySearch(search)) {
            searchItems = mapper.readValue(execute.getEntity().getContent(), mapper
                    .getTypeFactory()
                    .constructCollectionType(List.class, ItemSearchDto.class));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return searchItems;
    }
}
