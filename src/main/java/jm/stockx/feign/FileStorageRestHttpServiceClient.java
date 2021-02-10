package jm.stockx.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "file", url = "http://localhost:8080")
public interface FileStorageRestHttpServiceClient {

    @PostMapping(value = "/rest/api/item/img/upload/{id}", consumes = "multipart/form-data")
    String uploadItemPicture(@PathVariable("id") Long id,
                             @RequestPart(value = "file") MultipartFile file);


    @GetMapping(value = "/rest/api/item/img/download/{filename}", consumes = "multipart/form-data")
    Resource downloadItemPicture(@PathVariable("filename") String filename);

}
