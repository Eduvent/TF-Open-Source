package org.hign.platform.u202212645.personnel.domain.model.commands;

import java.util.Date;

public record CreateMentalStateExamCommand(
        Long patientId,
        String examinerNationalProviderIdentifier,
        Date examDate,
        Integer orientationScore,
        Integer registrationScore,
        Integer attentionAndCalculationScore,
        Integer recallScore,
        Integer languageScore) {
}