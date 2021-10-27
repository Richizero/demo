package com.example.demo.components;

import  org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**componente para subir y bajar archivos del servidor*/

@Component
public class FileManager {

    @Value("${bucket}")
    private String bucket;
    /**metodo para subir un archivo al servidor
     */
    public String upload(MultipartFile multipartFile, String name) throws IOException{

        String pathname;
        File newFile = new File(bucket + File.separator + multipartFile.getOriginalFilename());
        Files.copy(multipartFile.getInputStream(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        return newFile.getName();
    }

    public Resource download(String fullPathFileName) throws MalformedURLException {
        Path path = Paths.get(fullPathFileName).normalize();
        return new UrlResource(path.toUri());
    }
}
