package org.hign.platform.u202212645.personnel.interfaces.rest.transform;

import org.hign.platform.u202212645.personnel.domain.model.commands.CreateMentalStateExamCommand;
import org.hign.platform.u202212645.personnel.interfaces.rest.resources.CreateMentalStateExamResource;

public class CreateMentalStateExamCommandFromResourceAssembler {
    public static CreateMentalStateExamCommand toCommandFromResource(CreateMentalStateExamResource resource) {
        return new CreateMentalStateExamCommand(
                resource.patientId(),
                resource.examinerNationalProviderIdentifier(),
                resource.examDate(),
                resource.orientationScore(),
                resource.registrationScore(),
                resource.attentionAndCalculationScore(),
                resource.recallScore(),
                resource.languageScore()
        );
    }
}