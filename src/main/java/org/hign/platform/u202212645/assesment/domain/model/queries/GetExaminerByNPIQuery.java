package org.hign.platform.u202212645.assesment.domain.model.queries;

import org.hign.platform.u202212645.assesment.domain.model.valueobjects.NationalProviderIdentifier;

public record GetExaminerByNPIQuery(NationalProviderIdentifier nationalProviderIdentifier) {
}