package com.dotcapital.audit.domain;

import com.dotcapital.audit.domain.model.Audit;
import com.dotcapital.audit.persistence.AuditPersistenceFacade;
import com.dotcapital.exception.ErrorSeverity;
import com.dotcapital.exception.FunctionalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.lang.String.format;


@Slf4j
@Service
public class AuditService {

    private final AuditPersistenceFacade auditPersistenceFacade;

    public AuditService(AuditPersistenceFacade auditPersistenceFacade) {
        this.auditPersistenceFacade = auditPersistenceFacade;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Audit createAudit(final Audit audit) {
        return this.auditPersistenceFacade.save(audit);
    }

    public List<Audit> findAudits() {
        return this.auditPersistenceFacade.findAll();
    }


    public List<Audit> findSpecialAudits() {
        // TODO select all Audits not directly linked to a CONF, so probably linked to a CERT
        return this.auditPersistenceFacade.findAll();
    }

}
