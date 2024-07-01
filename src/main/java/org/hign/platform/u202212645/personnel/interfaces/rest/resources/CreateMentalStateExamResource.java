package org.hign.platform.u202212645.personnel.interfaces.rest.resources;

import java.util.Date;

public record CreateMentalStateExamResource(
        Long patientId,
        String examinerNationalProviderIdentifier,
        Date examDate,
        Integer orientationScore,
        Integer registrationScore,
        Integer attentionAndCalculationScore,
        Integer recallScore,
        Integer languageScore) {
}