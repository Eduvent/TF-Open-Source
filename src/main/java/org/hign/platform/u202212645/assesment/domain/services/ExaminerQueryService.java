package org.hign.platform.u202212645.assesment.domain.services;

import org.hign.platform.u202212645.assesment.domain.model.aggregates.Examiner;
import org.hign.platform.u202212645.assesment.domain.model.queries.GetExaminerByNPIQuery;

import java.util.Optional;

public interface ExaminerQueryService {
    Optional<Examiner> handle(GetExaminerByNPIQuery query);
}