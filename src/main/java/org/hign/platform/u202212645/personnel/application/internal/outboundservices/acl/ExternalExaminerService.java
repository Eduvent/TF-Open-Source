package org.hign.platform.u202212645.personnel.application.internal.outboundservices.acl;

import org.hign.platform.u202212645.personnel.domain.model.valueobjects.ExaminerNationalProviderIdentifier;
import org.hign.platform.u202212645.assesment.interfaces.acl.ExaminersContextFacade;
import org.springframework.stereotype.Service;

@Service
public class ExternalExaminerService {

    private final ExaminersContextFacade examinersContextFacade;

    public ExternalExaminerService(ExaminersContextFacade examinersContextFacade) {
        this.examinersContextFacade = examinersContextFacade;
    }

    /**
     * Checks if an examiner exists by their national provider identifier (NPI)
     *
     * @param nationalProviderIdentifier the NPI
     * @return true if the examiner exists, false otherwise
     */
    public boolean existsByNationalProviderIdentifier(ExaminerNationalProviderIdentifier nationalProviderIdentifier) {
        return examinersContextFacade.existsByNationalProviderIdentifier(nationalProviderIdentifier.getValue());
    }
}