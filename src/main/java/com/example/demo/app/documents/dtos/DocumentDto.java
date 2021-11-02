package com.example.demo.app.documents.dtos;

import com.example.demo.app.documents.models.Document;

public class DocumentDto {
    private Integer id;
    private String path;
    private String fileName;

    public DocumentDto() {
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public Document toEntity() {
        return new Document(
                id,
                path,
                fileName
        );
    }
}