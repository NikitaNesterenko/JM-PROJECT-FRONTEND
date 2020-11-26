package jm.stockx.http.service;

import jm.stockx.feign.FileStorageRestHttpServiceClient;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;

import static org.springframework.util.MimeTypeUtils.APPLICATION_OCTET_STREAM_VALUE;

@Service
public class FileStorageRestHttpService {
    private String requestUrl;
    private final FileStorageRestHttpServiceClient client;

    public FileStorageRestHttpService(String requestMappingUrl, FileStorageRestHttpServiceClient client) {
        requestUrl = requestMappingUrl;
        this.client = client;
    }

    @Autowired
    public FileStorageRestHttpService(FileStorageRestHttpServiceClient client) {
        this.client = client;
    }

    public String uploadItemPicture(String url, String type, Long id, File file) {
        HttpEntity entity = MultipartEntityBuilder.create()
                .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                .addBinaryBody("file", file)
                .build();

        try {
            return EntityUtils.toString(client.uploadItemPicture(requestUrl, url, type, id, entity));
        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid file or type", e);
        }
    }

    public MultipartFile downloadItemPicture(String url, String filename, String type) {

        FileItem fileItem = new DiskFileItemFactory().createItem("file",
                APPLICATION_OCTET_STREAM_VALUE, true, filename);
        try (InputStream input =
                     new ByteArrayInputStream(
                             client.downloadItemPicture(requestUrl, url, type, filename, fileItem).getBytes()
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
