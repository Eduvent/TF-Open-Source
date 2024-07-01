package org.hign.platform.u202212645.assesment.interfaces.acl;

import org.hign.platform.u202212645.assesment.domain.services.ExaminerQueryService;
import org.hign.platform.u202212645.assesment.domain.model.queries.GetExaminerByNPIQuery;
import org.hign.platform.u202212645.assesment.domain.model.valueobjects.NationalProviderIdentifier;
import org.springframework.stereotype.Service;

@Service
public class ExaminersContextFacade {

    private final ExaminerQueryService examinerQueryService;

    public ExaminersContextFacade(ExaminerQueryService examinerQueryService) {
        this.examinerQueryService = examinerQueryService;
    }

    /**
     * Fetches the examiner by national provider identifier (NPI)
     *
     * @param nationalProviderIdentifier the NPI
     * @return true if the examiner exists, false otherwise
     */
    public boolean existsByNationalProviderIdentifier(String nationalProviderIdentifier) {
        var getExaminerByNPIQuery = new GetExaminerByNPIQuery(new NationalProviderIdentifier(nationalProviderIdentifier));
        var examiner = examinerQueryService.handle(getExaminerByNPIQuery);
        return examiner.isPresent();
    }
}