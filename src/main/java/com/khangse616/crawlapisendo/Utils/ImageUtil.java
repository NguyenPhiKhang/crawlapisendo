package com.khangse616.crawlapisendo.Utils;

import com.khangse616.crawlapisendo.messages.ResponseMessage;
import com.khangse616.crawlapisendo.models.Image;
import com.khangse616.crawlapisendo.services.ImageService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ImageUtil {
    public static ResponseEntity<ResponseMessage<Image>> uploadImage(ImageService imageService, MultipartFile file) {
        String message = "";
        try {
            Image image = imageService.store(file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage<>(message, image));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage<>(message));
        }
    }

    public static ResponseEntity<ResponseMessage<List<Image>>> uploadImages(ImageService imageService, List<MultipartFile> files) {
        String message = "";
        try {
            List<Image> images = imageService.stores(files);

            message = "Uploaded the "+files.size() +" file successfully";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage<>(message, images));
        } catch (Exception e) {
            message = "Could not upload the file!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage<>(message));
        }
    }

    public static MultipartFile createMultipartFileFromUrl(ImageService imageService, String url) throws IOException {
        if(url.equals("")||url.isEmpty())
            return null;
        URL imageUrl = url.contains("media3.scdn.vn") ? new URL(url) : new URL("https://media3.scdn.vn" + url);

        System.out.println(imageUrl);
        /*******************Multipart Upload Method*********************************
         **              To resources like minio or DB
         ***************************************************************************/

        String[] typesImage = url.split("\\.");
        String typeImage = typesImage[typesImage.length - 1];
        System.out.println(typeImage);
//        String[] namesImage = url.split("/");
//        String fileName = namesImage[namesImage.length - 1];
//        System.out.println(fileName);
        /********
         * Step 1
         * Create Buffered Image by Reading from Url using ImageIO library
         ********/
        BufferedImage image = ImageIO.read(imageUrl);

        /********
         * Step 2
         * Create ByteArrayOutputStream object to handle Image data
         ********/
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        /********
         * Step 3
         * Write as Image with Jpeg extension to byteArrayOutputStream created in previous step
         ********/
        ImageIO.write(image, typeImage, byteArrayOutputStream);

        /********
         * Step 4
         * Flush image created to byteArrayOutoputStream
         ********/
        byteArrayOutputStream.flush();

        /********
         * Step 5
         * Create Random file name but unique by adding timestamp with extension
         ********/

        String fileName = fileName(imageService).concat(".").concat(typeImage.toLowerCase());

        /********
         * Step 6
         * Now Create MultipartFile using MockMultipartFile by providing
         * @param fileName name of the file
         * @param imageType like "image/jpg"
         * @param ByteArray from ByteArrayOutputStream
         ********/
        MultipartFile multipartFile = new MockMultipartFile(fileName, fileName, "image/" + typeImage, byteArrayOutputStream.toByteArray());
        byteArrayOutputStream.close(); // Close once it is done saving
        return multipartFile;
    }

    public static List<MultipartFile> createMultipartFileFromUrls(ImageService imageService, String[] urls) throws IOException {
        List<MultipartFile> multipartFiles = new ArrayList<MultipartFile>();
        for (String url : urls) {
            multipartFiles.add(createMultipartFileFromUrl(imageService, url));
        }
        return multipartFiles;
    }

    public static String fileName(ImageService imageService) {
//        String filename = "";
//        do {
//            filename = RandomStringUtils.randomAlphanumeric(20);
//        }while (imageService.checkExistsId(filename));
//        return filename;

        return RandomStringUtils.randomAlphanumeric(20);
    }
}
