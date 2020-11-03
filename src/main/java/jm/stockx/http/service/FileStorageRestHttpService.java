package jm.stockx.http.service;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;

import static org.springframework.util.MimeTypeUtils.APPLICATION_OCTET_STREAM_VALUE;

@Service
public class FileStorageRestHttpService {
    private String requestUrl;
    private final CloseableHttpClient httpClient;

    public FileStorageRestHttpService(String requestMappingUrl, CloseableHttpClient httpClient) {
        requestUrl = requestMappingUrl;
        this.httpClient = httpClient;
    }

    public FileStorageRestHttpService() {
        httpClient = HttpClients.createDefault();
    }

    public String uploadItemPicture(String url, String type, Long id, File file) {
        HttpEntity entity = MultipartEntityBuilder.create()
                .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                .addBinaryBody("file", file)
                .build();

        HttpPost request = new HttpPost(requestUrl + url + "?type=" + type + "&id=" + id);
        request.setEntity(entity);
        try {
            return EntityUtils.toString(httpClient.execute(request).getEntity());
        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid file or type", e);
        }
    }

    public MultipartFile downloadItemPicture(String url, String filename, String type) {
        HttpGet request = new HttpGet(requestUrl + url + "?type=" + type + "&filename=" + filename);

        FileItem fileItem = new DiskFileItemFactory().createItem("file",
                APPLICATION_OCTET_STREAM_VALUE, true, filename);
        try (InputStream input =
                     new ByteArrayInputStream(
                             httpClient.execute(request).getEntity().getContent().readAllBytes()
                     );
             OutputStream os = fileItem.getOutputStream()) {
            input.transferTo(os);
        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid filename or type", e);
        }
        return new CommonsMultipartFile(fileItem);
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }
}
