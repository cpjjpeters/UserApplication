package com.dotcapital.document.services;

import com.dotcapital.document.model.Document;
import com.dotcapital.document.persistence.DocumentPersistenceFacade;
import com.dotcapital.exception.RecordNotFoundException;
import jakarta.validation.constraints.Min;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/* carlpeters created on 07/04/2025 inside the package - com.dotcapital.document.services */
@Slf4j
@Service
public class DocumentService {

    private final DocumentPersistenceFacade documentPersistenceFacade ;

    public DocumentService(DocumentPersistenceFacade documentPersistenceFacade) {
        this.documentPersistenceFacade = documentPersistenceFacade;
    }


    public Document save(Document document) {
        return this.documentPersistenceFacade.save(document);
    }
    public List<Document> findAll() {
        return this.documentPersistenceFacade.findAll();
    }

    public Document findById(@Min(value = 1, message = "Id must be greater than 0") Long id) {
        return this.documentPersistenceFacade.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(String.format("Document with id '%d' not found",id)));
//        return new Document();
    }
}
