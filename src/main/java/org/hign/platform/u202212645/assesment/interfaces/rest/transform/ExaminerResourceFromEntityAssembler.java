package org.hign.platform.u202212645.assesment.interfaces.rest.transform;

import org.hign.platform.u202212645.assesment.domain.model.aggregates.Examiner;
import org.hign.platform.u202212645.assesment.interfaces.rest.resources.ExaminerResource;

public class ExaminerResourceFromEntityAssembler {
    public static ExaminerResource toResourceFromEntity(Examiner entity) {
        return new ExaminerResource(entity.getId(), entity.getFirstName(), entity.getLastName(), entity.getNationalProviderIdentifier().getValue());
    }
}
