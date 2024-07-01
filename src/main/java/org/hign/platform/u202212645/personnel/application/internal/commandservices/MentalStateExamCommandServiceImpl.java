package org.hign.platform.u202212645.personnel.application.internal.commandservices;

import org.hign.platform.u202212645.personnel.domain.model.aggregates.MentalStateExam;
import org.hign.platform.u202212645.personnel.domain.model.commands.CreateMentalStateExamCommand;
import org.hign.platform.u202212645.personnel.domain.model.valueobjects.ExaminerNationalProviderIdentifier;
import org.hign.platform.u202212645.personnel.domain.services.MentalStateExamCommandService;
import org.hign.platform.u202212645.personnel.infrastructure.persistence.jpa.repositories.MentalStateExamRepository;
import org.hign.platform.u202212645.personnel.application.internal.outboundservices.acl.ExternalExaminerService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class MentalStateExamCommandServiceImpl implements MentalStateExamCommandService {

    private final MentalStateExamRepository mentalStateExamRepository;
    private final ExternalExaminerService externalExaminerService;

    public MentalStateExamCommandServiceImpl(MentalStateExamRepository mentalStateExamRepository, ExternalExaminerService externalExaminerService) {
        this.mentalStateExamRepository = mentalStateExamRepository;
        this.externalExaminerService = externalExaminerService;
    }

    @Override
    public Optional<MentalStateExam> handle(CreateMentalStateExamCommand command) {
        ExaminerNationalProviderIdentifier examinerNPI = new ExaminerNationalProviderIdentifier(command.examinerNationalProviderIdentifier());

        // Validar que el UUID corresponda a un examiner registrado
        if (!externalExaminerService.existsByNationalProviderIdentifier(examinerNPI)) {
            throw new RuntimeException("Examiner not found for the given National Provider Identifier");
        }

        // Validar que examDate no sea mayor que la fecha actual
        if (command.examDate().after(new Date())) {
            throw new IllegalArgumentException("Exam date cannot be in the future");
        }

        // Validar los puntajes
        validateScores(command.orientationScore(), 0, 10);
        validateScores(command.registrationScore(), 0, 3);
        validateScores(command.attentionAndCalculationScore(), 0, 5);
        validateScores(command.recallScore(), 0, 3);
        validateScores(command.languageScore(), 0, 9);

        var mentalStateExam = new MentalStateExam(
                command.patientId(),
                examinerNPI,
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

    private void validateScores(int score, int min, int max) {
        if (score < min || score > max) {
            throw new IllegalArgumentException("Score must be between " + min + " and " + max);
        }
    }
}