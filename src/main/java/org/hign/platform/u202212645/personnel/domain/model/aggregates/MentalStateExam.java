package org.hign.platform.u202212645.personnel.domain.model.aggregates;

import org.hign.platform.u202212645.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import org.hign.platform.u202212645.personnel.domain.model.valueobjects.ExaminerNationalProviderIdentifier;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
public class MentalStateExam extends AuditableAbstractAggregateRoot<MentalStateExam> {

    @Column(nullable = false)
    private Long patientId;

    @Embedded
    @Column(nullable = false)
    private ExaminerNationalProviderIdentifier examinerNationalProviderIdentifier;

    @Column(nullable = false)
    private Date examDate;

    @Column(nullable = false)
    private Integer orientationScore;

    @Column(nullable = false)
    private Integer registrationScore;

    @Column(nullable = false)
    private Integer attentionAndCalculationScore;

    @Column(nullable = false)
    private Integer recallScore;

    @Column(nullable = false)
    private Integer languageScore;

    public MentalStateExam(Long patientId, ExaminerNationalProviderIdentifier examinerNationalProviderIdentifier, Date examDate, Integer orientationScore, Integer registrationScore, Integer attentionAndCalculationScore, Integer recallScore, Integer languageScore) {
        this.patientId = patientId;
        this.examinerNationalProviderIdentifier = examinerNationalProviderIdentifier;
        this.examDate = examDate;
        this.orientationScore = orientationScore;
        this.registrationScore = registrationScore;
        this.attentionAndCalculationScore = attentionAndCalculationScore;
        this.recallScore = recallScore;
        this.languageScore = languageScore;
    }
}