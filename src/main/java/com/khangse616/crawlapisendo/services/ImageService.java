package com.khangse616.crawlapisendo.services;

import com.khangse616.crawlapisendo.models.Image;
import com.khangse616.crawlapisendo.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public Image store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath((Objects.requireNonNull(file.getOriginalFilename())));
        Image FileDB = new Image(fileName, fileName, file.getContentType(), file.getBytes());

        return imageRepository.save(FileDB);
    }

    public List<Image> stores(List<MultipartFile> multipartFiles) throws IOException {
        List<Image> images = new ArrayList<Image>();
        for (MultipartFile file : multipartFiles) {
            String fileName = StringUtils.cleanPath((Objects.requireNonNull(file.getOriginalFilename())));
            Image FileDB = new Image(fileName, fileName, file.getContentType(), file.getBytes());

            images.add(FileDB);
        }
        return imageRepository.saveAll(images);
    }

    public Optional<Image> getFile(String id) {
//        return imageRepository.findById(id).orElse(null);
        return imageRepository.findById(id);
    }

    public Stream<Image> getAllFiles() {
        return imageRepository.findAll().stream();
    }

    public List<Image> getAllImages(){
        return imageRepository.findAll();
    }

    public boolean checkExistsId(String id){return imageRepository.existsById(id);}

    public Image saveImageByLink(String[] file){
        Image FileDB = new Image(file[0], file[0], file[1], file[2]);

        return imageRepository.save(FileDB);
    }

    public List<Image> saveImagesByLink(List<String[]> files){
        List<Image> images = new ArrayList<Image>();
        for (String[] file : files) {
            Image FileDB = new Image(file[0], file[0], file[1], file[2]);
            images.add(FileDB);
        }
        return imageRepository.saveAll(images);
    }
}
