package jm.stockx.http.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuthRestGoogleService {
    @Value("${basic.url}")
    private String basicUrl;

    private final CloseableHttpClient httpClient;
    private ObjectMapper mapper;
    private final String postfixUrl = "/auth/url/google";


    public AuthRestGoogleService(CloseableHttpClient httpClient) {
        this.httpClient = httpClient;
        mapper = new ObjectMapper();
    }

    public String getUrl() {
        HttpGet httpGet = new HttpGet(basicUrl + postfixUrl);
        try(CloseableHttpResponse execute = httpClient.execute(httpGet);)
        {
            return EntityUtils.toString(execute.getEntity());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
