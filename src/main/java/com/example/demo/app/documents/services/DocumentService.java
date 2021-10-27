package com.example.demo.app.documents.services;

import com.example.demo.app.documents.models.Document;
import com.example.demo.app.documents.repos.DocumentRepository;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class DocumentService {
    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public Document findBy(Integer id) {return documentRepository.findById(id).get();}
    public List<Document> findAll(){
        return documentRepository.findAll();
    }

    public Document create(Document document){
        return documentRepository.save(document);
    }

    public Document update(Integer id, Document user) throws Exception {
        //localiza documento
        Document foundUser = documentRepository.findById(id).get();
        if(user!=null){
            return documentRepository.save(user);
        }else{
            throw new Exception("Usuario no Encontrado");
        }
    }
}
