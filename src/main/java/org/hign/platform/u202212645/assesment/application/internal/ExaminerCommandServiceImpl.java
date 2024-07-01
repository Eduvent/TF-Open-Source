package org.hign.platform.u202212645.assesment.application.internal;

import org.hign.platform.u202212645.assesment.domain.model.aggregates.Examiner;
import org.hign.platform.u202212645.assesment.domain.model.commands.CreateExaminerCommand;
import org.hign.platform.u202212645.assesment.domain.model.valueobjects.NationalProviderIdentifier;
import org.hign.platform.u202212645.assesment.domain.services.ExaminerCommandService;
import org.hign.platform.u202212645.assesment.infrastructure.persistence.jpa.repositories.ExaminerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExaminerCommandServiceImpl implements ExaminerCommandService {

    private final ExaminerRepository examinerRepository;

    public ExaminerCommandServiceImpl(ExaminerRepository examinerRepository) {
        this.examinerRepository = examinerRepository;
    }

    @Override
    public Optional<Examiner> handle(CreateExaminerCommand command) {
        NationalProviderIdentifier npi;
        try {
            npi = new NationalProviderIdentifier(command.nationalProviderIdentifier());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid National Provider Identifier: " + e.getMessage());
        }

        if (examinerRepository.existsByNationalProviderIdentifier(npi)) {
            throw new RuntimeException("Examiner with the same National Provider Identifier already exists");
        }
        var examiner = new Examiner(command.firstName(), command.lastName(), npi);
        examinerRepository.save(examiner);
        return Optional.of(examiner);
    }
}