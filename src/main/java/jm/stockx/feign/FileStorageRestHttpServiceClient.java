package jm.stockx.feign;

import org.apache.commons.fileupload.FileItem;
import org.apache.http.HttpEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "file")
public interface FileStorageRestHttpServiceClient {

    @PostMapping(value = "{requestUrl}{url}?type={type}&id={id}", consumes = "multipart/form-data")
    HttpEntity uploadItemPicture(@PathVariable("requestUrl") String requestUrl,
                                 @PathVariable("url") String url,
                                 @PathVariable("type") String type,
                                 @PathVariable("id") Long id,
                                 HttpEntity entity);

    @GetMapping(value = "{requestUrl}{url}?type={type}&filename={filename}", consumes = "multipart/form-data")
    MultipartFile downloadItemPicture(@PathVariable("requestUrl") String requestUrl,
                                      @PathVariable("url") String url,
                                      @PathVariable("type") String type,
                                      @PathVariable("filename") String filename,
                                      FileItem fileItem);
}
