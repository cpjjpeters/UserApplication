package com.dotcapital.audit.web.in;

import com.dotcapital.audit.domain.AuditService;
import com.dotcapital.audit.domain.model.Audit;
import com.dotcapital.audit.web.in.mapper.AuditDtoMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/audits")
public class AuditController {

    private final AuditService auditService;
    private final AuditDtoMapper auditDtoMapper;

    public AuditController(AuditService auditService, AuditDtoMapper auditDtoMapper) {
        this.auditService = auditService;
        this.auditDtoMapper = auditDtoMapper;
    }



}
