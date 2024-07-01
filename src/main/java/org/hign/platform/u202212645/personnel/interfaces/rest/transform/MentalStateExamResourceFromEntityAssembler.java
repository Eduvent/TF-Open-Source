package org.hign.platform.u202212645.personnel.interfaces.rest.transform;

import org.hign.platform.u202212645.personnel.domain.model.aggregates.MentalStateExam;
import org.hign.platform.u202212645.personnel.interfaces.rest.resources.MentalStateExamResource;

public class MentalStateExamResourceFromEntityAssembler {
    public static MentalStateExamResource toResourceFromEntity(MentalStateExam entity) {
        return new MentalStateExamResource(
                entity.getId(),
                entity.getPatientId(),
                entity.getExaminerNationalProviderIdentifier().getValue(),
                entity.getExamDate(),
                entity.getOrientationScore(),
                entity.getRegistrationScore(),
                entity.getAttentionAndCalculationScore(),
                entity.getRecallScore(),
                entity.getLanguageScore(),
                null
        );
    }
}