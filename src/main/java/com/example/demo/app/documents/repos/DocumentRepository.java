package com.example.demo.app.documents.repos;

import com.example.demo.app.documents.models.Document;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DocumentRepository extends JpaRepository<Document, Integer> {
}