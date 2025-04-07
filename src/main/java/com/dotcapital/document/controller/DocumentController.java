package com.dotcapital.document.controller;

import com.dotcapital.document.model.Document;
import com.dotcapital.document.services.DocumentService;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Min;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/* carlpeters created on 07/04/2025 inside the package - com.dotcapital.document.controller */
@Transactional
@RestController
@RequestMapping(value="/documents")
@Validated
@Slf4j
public class DocumentController {
    private final DocumentService documentService;
    
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping(value="/create")
    public Document create(@Validated @RequestBody Document document){
        log.debug("create document {}", document);
        Document savedDocument = documentService.save(document);
        log.debug("saved document {}", savedDocument);
        return savedDocument;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Document>> getAll() {
        log.debug("get all users");
        List<Document> documents = documentService.findAll();
        if (documents.isEmpty()) {
            return  ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(documents);
    }

    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Document> findById(@PathVariable @Min(value = 1, message = "Id must be greater than 0") Long id) {
        log.debug("findById {}", id);
        return ResponseEntity.ok(this.documentService.findById(id));
    }
}
