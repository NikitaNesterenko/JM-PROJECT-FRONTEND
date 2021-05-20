package jm.stockx.controller.rest;

//import jm.stockx.FileStorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileStorageRestController {
//    private FileStorageService fileStorageService;

    @Autowired
    public FileStorageRestController(
//            FileStorageService fileStorageService
    ) {
//        this.fileStorageService = fileStorageService;
    }

//    @PostMapping("/item/img/upload")
//    public String uploadItemPicture(@RequestParam("id") Long id, MultipartFile file) {
//        return fileStorageService.storeFile(id, file);
//    }

//    @GetMapping("/item/img/download")
//    public ResponseEntity<Resource> downloadItemPicture(@RequestParam("filename") String filename,
//                                                        HttpServletRequest request)  throws Exception{
//        Resource resource = fileStorageService.loadFileAsResource(filename);

//        String contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());

//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(contentType))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
//                .body(resource);
//    }
}
