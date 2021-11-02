package com.example.demo.app.documents.services;

import com.example.demo.app.documents.dtos.DocumentDto;
import com.example.demo.app.documents.repos.DocumentRepository;
import com.example.demo.components.FileManager;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;


@Service
public class DocumentService {
    private final DocumentRepository documentRepository;
    private final FileManager fileManager;

    public DocumentService(DocumentRepository documentRepository, FileManager fileManager) {
        this.documentRepository = documentRepository;
        this.fileManager = fileManager;
    }
    /**
     * recibe un multipartfile y lo envia al filemanager para cargarlo en el filesystem
     * @param multipartFile
     * @return
     */
    public Integer save(MultipartFile multipartFile, DocumentDto documentDto) throws IOException {
        String filepath = fileManager.upload(multipartFile);
        documentDto.setPath(filepath);
        documentDto.setFileName(multipartFile.getOriginalFilename());
        return documentRepository.save(documentDto.toEntity()).getId();
    }

    /**
     *devuelve el archivo, con base en el id
     * @param id
     * @return
     * @throws IOException
     */
    public ResponseEntity<Resource> download(Integer id) throws IOException{
        return fileManager.download(documentRepository.getById(id).getFilename());
    }
}
