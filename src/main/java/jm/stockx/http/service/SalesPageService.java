package jm.stockx.http.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SalesPageService {
    @Value("${basic.url}/api/item/allItem")
    private String basicUrl;


}
