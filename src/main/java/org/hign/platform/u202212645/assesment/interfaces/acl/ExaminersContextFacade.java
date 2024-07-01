package org.hign.platform.u202212645.assesment.interfaces.acl;

import org.hign.platform.u202212645.assesment.domain.model.aggregates.Examiner;
import org.hign.platform.u202212645.assesment.domain.model.valueobjects.NationalProviderIdentifier;
import org.hign.platform.u202212645.assesment.domain.services.ExaminerQueryService;
import org.hign.platform.u202212645.assesment.domain.model.queries.GetExaminerByNPIQuery;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExaminersContextFacade {
    private final ExaminerQueryService examinerQueryService;

    public ExaminersContextFacade(ExaminerQueryService examinerQueryService) {
        this.examinerQueryService = examinerQueryService;
    }

    public Optional<Examiner> fetchExaminerByNationalProviderIdentifier(NationalProviderIdentifier npi) {
        var query = new GetExaminerByNPIQuery(npi);
        return examinerQueryService.handle(query);
    }

    public boolean existsByNationalProviderIdentifier(String nationalProviderIdentifier) {
        NationalProviderIdentifier npi = new NationalProviderIdentifier(nationalProviderIdentifier);
        var query = new GetExaminerByNPIQuery(npi);
        return examinerQueryService.handle(query).isPresent();
    }
}