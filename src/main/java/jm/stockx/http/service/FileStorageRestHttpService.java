package jm.stockx.http.service;

import jm.stockx.feign.FileStorageRestHttpServiceClient;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static org.springframework.util.MimeTypeUtils.APPLICATION_OCTET_STREAM_VALUE;

@Service
public class FileStorageRestHttpService {


    private final FileStorageRestHttpServiceClient client;

    public FileStorageRestHttpService(FileStorageRestHttpServiceClient client) {
        this.client = client;
    }

    public String uploadItemPicture(Long id, MultipartFile file) {
        try {
            return client.uploadItemPicture(id, file);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid file or type", e);
        }
    }

    public MultipartFile downloadItemPicture(String filename) {

        FileItem fileItem = new DiskFileItemFactory().createItem("file",
                APPLICATION_OCTET_STREAM_VALUE, true, filename);
        try (InputStream input = client.downloadItemPicture(filename).getInputStream();
             OutputStream os = fileItem.getOutputStream()) {
            input.transferTo(os);
        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid filename or type", e);
        }
        return new CommonsMultipartFile(fileItem);
    }

}
