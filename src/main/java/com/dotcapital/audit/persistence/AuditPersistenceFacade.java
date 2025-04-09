package com.dotcapital.audit.persistence;


import com.dotcapital.audit.domain.model.Audit;

import java.time.Instant;
import java.util.List;

public interface AuditPersistenceFacade {
	
    Audit save(Audit audit);

    List<Audit> findAll();

}
