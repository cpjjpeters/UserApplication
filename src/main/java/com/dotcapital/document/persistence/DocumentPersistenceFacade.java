package com.dotcapital.document.persistence;

import com.dotcapital.document.entities.DocumentJpaEntity;
import com.dotcapital.document.model.Document;

import java.util.List;
import java.util.Optional;

/* carlpeters created on 07/04/2025 inside the package - com.dotcapital.document.persistence */
public interface DocumentPersistenceFacade {
    Document save(Document document);

    List<Document> findAll();

    Optional<Document> findById(Long id);

    void delete(Document document);

    void deleteById(Long id);

    Document update(Document document);
}


