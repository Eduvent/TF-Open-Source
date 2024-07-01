package org.hign.platform.u202212645.assesment.application.internal;

import org.hign.platform.u202212645.assesment.domain.model.aggregates.Examiner;
import org.hign.platform.u202212645.assesment.domain.model.queries.GetExaminerByNPIQuery;
import org.hign.platform.u202212645.assesment.domain.services.ExaminerQueryService;
import org.hign.platform.u202212645.assesment.infrastructure.persistence.jpa.repositories.ExaminerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExaminerQueryServiceImpl implements ExaminerQueryService {

    private final ExaminerRepository examinerRepository;

    public ExaminerQueryServiceImpl(ExaminerRepository examinerRepository) {
        this.examinerRepository = examinerRepository;
    }

    @Override
    public Optional<Examiner> handle(GetExaminerByNPIQuery query) {
        return examinerRepository.findByNationalProviderIdentifier(query.nationalProviderIdentifier());
    }
}