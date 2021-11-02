package com.example.demo.app.documents.restcontrollers;


import com.example.demo.app.documents.services.DocumentService;
import com.example.demo.utils.ApiResponse;
import com.example.demo.utils.Router;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * restcontroller para cargar y descargar archivos
 * @since oct 20 de 2021
 */
@RestController
@RequestMapping(Router.DOCUMENTS)
public class documentsRestController {

    private ApiResponse apiResponse;
    private final DocumentService documentService;


    public documentsRestController(DocumentService documentService) {
        this.documentService = documentService;
    }
    @PostMapping("/upload")
    public ResponseEntity<Integer> upload(@RequestParam("file")MultipartFile multipartFile){
        try {
            apiResponse = new ApiResponse<Integer>(
                    "Archivo cargado con exito",
                    documentService.save(multipartFile),
                    false,
                    201
            );
        } catch (IOException e) {
            apiResponse = new ApiResponse<Integer>(
                    "hubo un error en la carga del archivo",
                    null,
                    false,
                    404
            );
        }
        return apiResponse.getResponseEntity();
    }
    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> download(@PathVariable("id")Integer id){
        try {
            return documentService.download(id);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
