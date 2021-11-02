package com.example.demo.app.documents.dtos;


import com.example.demo.app.documents.models.Document;
import com.example.demo.utils.Messages;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class DocumentDto {
    private Integer id;
    @NotEmpty
    @Size(min = 8, max = 255, message = Messages.PATH_NOT_VALID)
    private String path;
    @NotEmpty
    @Size(min = 8, max = 255, message = Messages.PATH_NOT_VALID)
    private String fileName;


    public DocumentDto() {
    }

    public DocumentDto(Integer id, String path, String fileName) {
        this.id = id;
        this.path = path;
        this.fileName = fileName;
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

    public Document toEntity(){
        return new Document(
                this.id,
                this.path,
                this.fileName
        );
    }
}
