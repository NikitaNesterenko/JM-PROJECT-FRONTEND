package jm.stockx.feign;

import org.apache.commons.fileupload.FileItem;
import org.apache.http.HttpEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@FeignClient
public interface FileStorageRestHttpServiceClient {

    @PostMapping("{requestUrl}{url}?type={type}&id={id}")
    HttpEntity uploadItemPicture(@PathVariable("requestUrl") String requestUrl,
                                 @PathVariable("url") String url,
                                 @PathVariable("type") String type,
                                 @PathVariable("id") Long id,
                                 HttpEntity entity);

    @GetMapping("{requestUrl}{url}?type={type}&filename={filename}")
    MultipartFile downloadItemPicture(@PathVariable("requestUrl") String requestUrl,
                                      @PathVariable("url") String url,
                                      @PathVariable("type") String type,
                                      @PathVariable("filename") String filename,
                                      FileItem fileItem);
}
