package org.hign.platform.u202212645.personnel.application.internal.outboundservices;

import org.hign.platform.u202212645.personnel.domain.model.valueobjects.ExaminerNationalProviderIdentifier;
import org.hign.platform.u202212645.assesment.infrastructure.persistence.jpa.repositories.ExaminerRepository;
import org.springframework.stereotype.Service;

@Service
public class ExaminerExternalService {

    private final ExaminerRepository examinerRepository;

    public ExaminerExternalService(ExaminerRepository examinerRepository) {
        this.examinerRepository = examinerRepository;
    }

    public boolean existsByNationalProviderIdentifier(ExaminerNationalProviderIdentifier nationalProviderIdentifier) {
        return examinerRepository.existsByNationalProviderIdentifier(new org.hign.platform.u202212645.assesment.domain.model.valueobjects.NationalProviderIdentifier(nationalProviderIdentifier.getValue()));
    }
}