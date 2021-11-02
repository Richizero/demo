package com.example.demo.app.documents.services;

import com.example.demo.app.documents.dtos.DocumentDto;
import com.example.demo.app.documents.models.Document;
import com.example.demo.app.documents.repos.DocumentRepository;
import com.example.demo.components.FileManager;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class DocumentService {
    private final DocumentRepository documentRepository;
    private final FileManager fileManager;

    public DocumentService(DocumentRepository documentRepository, FileManager fileManager) {
        this.documentRepository = documentRepository;
        this.fileManager = fileManager;
    }
    /**
     * recibe un multipartfile y lo envia al filemanager para encargarlo en el filesystem
     */
    public Integer save(MultipartFile multipartFile){
        String filepath = fileManager.upload(multipartFile);
        DocumentDto documentDto = new DocumentDto();
        documentDto.setPath(filepath);
        documentDto.setFileName(multipartFile.getOriginalFilename());
    }
}
