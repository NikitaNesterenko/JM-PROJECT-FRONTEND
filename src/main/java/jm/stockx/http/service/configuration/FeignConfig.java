
package jm.stockx.http.service.configuration;

import jm.stockx.interceptor.AddTokenInHeaderInterceptor;

import okhttp3.OkHttpClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients
public class FeignConfig {

   @Bean
    public AddTokenInHeaderInterceptor getInterceptor() {
        return new AddTokenInHeaderInterceptor();
    }

/*    @Bean
    public OkHttpClient.Builder okHttpClientBuilder(AddTokenInHeaderInterceptor addTokenInHeaderInterceptor) {
        return new OkHttpClient
                .Builder()
                .addInterceptor(addTokenInHeaderInterceptor);
    }*/


}

