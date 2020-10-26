package jm.stockx.http.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AuthRestGoogleService {
    @Value("${basic.url}")
    private String basicUrl;

    private CloseableHttpClient httpClient;
    private ObjectMapper mapper;
    private final String postfixUrl = "/auth/url/google";


    public AuthRestGoogleService() {
        httpClient = HttpClients.createDefault();
        mapper = new ObjectMapper();
    }

    public String getUrl() {
        try {
            HttpGet httpGet = new HttpGet(basicUrl + postfixUrl);
            CloseableHttpResponse execute = httpClient.execute(httpGet);

            return EntityUtils.toString(execute.getEntity());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
