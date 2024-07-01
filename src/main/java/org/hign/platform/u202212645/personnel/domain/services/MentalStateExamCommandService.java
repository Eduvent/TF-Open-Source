package org.hign.platform.u202212645.personnel.domain.services;

import org.hign.platform.u202212645.personnel.domain.model.aggregates.MentalStateExam;
import org.hign.platform.u202212645.personnel.domain.model.commands.CreateMentalStateExamCommand;

import java.util.Optional;

public interface MentalStateExamCommandService {
    Optional<MentalStateExam> handle(CreateMentalStateExamCommand command);
}