package com.example.demo.app.documents.models;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "adm_document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_seq_gen")
    @SequenceGenerator(name = "document_seq_gen", sequenceName = "document_id_seq",allocationSize = 1)
    private Integer Id;
    @Column(name = "path", columnDefinition = "varchar(255)")
    private String path;
    @Column(name = "file_name", columnDefinition = "varchar(255", nullable = false)
    private String filename;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
