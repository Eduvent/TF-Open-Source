package org.hign.platform.u202212645.assesment.domain.services;

import org.hign.platform.u202212645.assesment.domain.model.aggregates.Examiner;
import org.hign.platform.u202212645.assesment.domain.model.commands.CreateExaminerCommand;

import java.util.Optional;

public interface ExaminerCommandService {
    Optional<Examiner> handle(CreateExaminerCommand command);
}