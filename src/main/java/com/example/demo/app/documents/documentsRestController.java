package com.example.demo.app.documents;

import com.example.demo.components.FileManager;
import com.example.demo.utils.Router;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping(Router.DOCUMENTS)
public class documentsRestController {

    @Value("${bucket}")
    private String bucket;

    private FileManager fileManager;

    public documentsRestController(FileManager fileManager) {
        this.fileManager = fileManager;
    }


    @PostMapping("upload")
    public void upload(@RequestParam("file") MultipartFile multipartfile,
                       @RequestParam("name") String name){
        try {
            fileManager.upload(multipartfile,name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
