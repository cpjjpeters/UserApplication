package com.dotcapital.document.persistence;

import com.dotcapital.document.entities.DocumentJpaEntity;
import com.dotcapital.document.mapper.DocumentJpaDaoMapper;
import com.dotcapital.document.model.Document;
import com.dotcapital.document.repository.DocumentJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/* carlpeters created on 07/04/2025 inside the package - com.dotcapital.document.persistence */
@Slf4j
@Service
public class DocumentJpaPersistenceService implements DocumentPersistenceFacade {

    private final DocumentJpaRepository documentJpaRepository;
    private final DocumentJpaDaoMapper documentJpaDaoMapper;

    public DocumentJpaPersistenceService(DocumentJpaRepository documentJpaRepository, DocumentJpaDaoMapper documentJpaDaoMapper) {
        this.documentJpaRepository = documentJpaRepository;
        this.documentJpaDaoMapper = documentJpaDaoMapper;
    }

    @Override
    public Document save(Document document) {
        final DocumentJpaEntity saved = documentJpaRepository.save(documentJpaDaoMapper.modelToJpaEntity(document));
        log.debug("save document: {}", saved);
        return documentJpaDaoMapper.jpaEntityToModel(documentJpaRepository.save(saved));
    }

    @Override
    public Optional<Document> findById(Long id) {
        log.debug("findById: {}", id);
        return this.documentJpaRepository.findById(id)
                .flatMap(documentJpaEntity -> Optional.of(this.documentJpaDaoMapper.jpaEntityToModel(documentJpaEntity)));

    }

    @Override
    public Document update(Document document) {
        return null;
    }

    @Override
    public void delete(Document document) {
        log.debug("delete: {}", document);

    }

    @Override
    public void deleteById(Long id) {
        log.debug("deleteById: {}", id);

    }

    @Override
    public List<Document> findAll() {
        log.debug("findAll");
        return List.of();
    }
}
