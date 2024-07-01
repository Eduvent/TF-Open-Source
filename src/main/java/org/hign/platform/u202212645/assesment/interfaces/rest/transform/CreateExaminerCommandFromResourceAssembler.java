package org.hign.platform.u202212645.assesment.interfaces.rest.transform;

import org.hign.platform.u202212645.assesment.domain.model.commands.CreateExaminerCommand;
import org.hign.platform.u202212645.assesment.interfaces.rest.resources.CreateExaminerResource;

public class CreateExaminerCommandFromResourceAssembler {
    public static CreateExaminerCommand toCommandFromResource(CreateExaminerResource resource) {
        return new CreateExaminerCommand(resource.firstName(), resource.lastName(), resource.nationalProviderIdentifier());
    }
}
