package jm.stockx.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;


@FeignClient(name = "locale", url = "http://localhost:8080")
public interface LocaleModalWindowService {

}
