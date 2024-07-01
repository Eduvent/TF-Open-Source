package org.hign.platform.u202212645.personnel.application.internal.commandservices;

import org.hign.platform.u202212645.assesment.interfaces.acl.ExaminersContextFacade;
import org.hign.platform.u202212645.assesment.domain.model.valueobjects.NationalProviderIdentifier;
import org.hign.platform.u202212645.personnel.domain.model.aggregates.MentalStateExam;
import org.hign.platform.u202212645.personnel.domain.model.commands.CreateMentalStateExamCommand;
import org.hign.platform.u202212645.personnel.domain.services.MentalStateExamCommandService;
import org.hign.platform.u202212645.personnel.infrastructure.persistence.jpa.repositories.MentalStateExamRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MentalStateExamCommandServiceImpl implements MentalStateExamCommandService {

    private final MentalStateExamRepository mentalStateExamRepository;
    private final ExaminersContextFacade examinerContextFacade;

    public MentalStateExamCommandServiceImpl(MentalStateExamRepository mentalStateExamRepository, ExaminersContextFacade examinerContextFacade) {
        this.mentalStateExamRepository = mentalStateExamRepository;
        this.examinerContextFacade = examinerContextFacade;
    }

    @Override
    public Optional<MentalStateExam> handle(CreateMentalStateExamCommand command) {
        NationalProviderIdentifier npi = new NationalProviderIdentifier(command.examinerNationalProviderIdentifier());

        var examiner = examinerContextFacade.fetchExaminerByNationalProviderIdentifier(npi);
        if (examiner.isEmpty()) {
            throw new RuntimeException("Examiner with given National Provider Identifier not found");
        }

        MentalStateExam mentalStateExam = new MentalStateExam(
                command.patientId(),
                npi,
                command.examDate(),
                command.orientationScore(),
                command.registrationScore(),
                command.attentionAndCalculationScore(),
                command.recallScore(),
                command.languageScore()
        );

        mentalStateExamRepository.save(mentalStateExam);
        return Optional.of(mentalStateExam);
    }
}