package org.hign.platform.u202212645.assesment.infrastructure.persistence.jpa.repositories;

import org.hign.platform.u202212645.assesment.domain.model.aggregates.Examiner;
import org.hign.platform.u202212645.assesment.domain.model.valueobjects.NationalProviderIdentifier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExaminerRepository extends JpaRepository<Examiner, Long> {
    boolean existsByNationalProviderIdentifier(NationalProviderIdentifier nationalProviderIdentifier);
}