package com.khangse616.crawlapisendo.controllers;

import com.khangse616.crawlapisendo.Utils.ImageUtil;
import com.khangse616.crawlapisendo.exceptions.ResourceNotFoundException;
import com.khangse616.crawlapisendo.messages.ResponseMessage;
import com.khangse616.crawlapisendo.models.Image;
import com.khangse616.crawlapisendo.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:3000")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @GetMapping("/images")
    public List<Image> getImages() {
        return imageService.getAllFiles().map(image -> new Image(image.getId(), image.getName(), image.getType(), image.getData())).collect(Collectors.toList());
//        return storageService.getAllFiles().collect(Collectors.toList());
//        return storageService.getAllImages();
    }

    @GetMapping("/images/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id) {
        Image image = imageService.getFile(id).orElseThrow(() -> new ResourceNotFoundException("khong tim thay image id: " + id));
        return ResponseEntity.ok().contentType(MediaType.valueOf(image.getType())).body(image.getData());
    }

    @PostMapping("/images/upload-url")
    public ResponseEntity<ResponseMessage<Image>> uploadFile(@RequestBody String url) throws IOException {
        MultipartFile file = ImageUtil.createMultipartFileFromUrl(imageService, url);
        return ImageUtil.uploadImage(imageService, file);
    }

    @PostMapping("/images/upload-multi-url")
    public ResponseEntity<ResponseMessage<List<Image>>> uploadFile(@RequestBody String[] urls) throws IOException {
        List<MultipartFile> files = ImageUtil.createMultipartFileFromUrls(imageService, urls);
        return ImageUtil.uploadImages(imageService, files);
    }

    @PostMapping("/images/upload-file")
    public ResponseEntity<ResponseMessage<Image>> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        String fileName = ImageUtil.fileName(imageService).concat(".").concat(Objects.requireNonNull(file.getContentType()).split("/")[1]);
        MultipartFile multipartFile = new MockMultipartFile(fileName, fileName, file.getContentType(), file.getInputStream());
        return ImageUtil.uploadImage(imageService, multipartFile);
    }

    @PostMapping("/images/upload-multi-file")
    public ResponseEntity<ResponseMessage<List<Image>>> uploadFile(@RequestParam("files") MultipartFile[] files) throws IOException {
        List<MultipartFile> multipartFiles = new ArrayList<>();

        Arrays.stream(files).forEach(file -> {
            String fileName = ImageUtil.fileName(imageService).concat(".").concat(Objects.requireNonNull(file.getContentType()).split("/")[1]);
            try {
                MultipartFile multipartFile = new MockMultipartFile(fileName, fileName, file.getContentType(), file.getInputStream());
                multipartFiles.add(multipartFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return ImageUtil.uploadImages(imageService, multipartFiles);
    }
}
