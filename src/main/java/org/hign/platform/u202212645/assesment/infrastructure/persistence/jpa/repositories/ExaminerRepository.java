package org.hign.platform.u202212645.assesment.infrastructure.persistence.jpa.repositories;

import org.hign.platform.u202212645.assesment.domain.model.aggregates.Examiner;
import org.hign.platform.u202212645.assesment.domain.model.valueobjects.NationalProviderIdentifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExaminerRepository extends JpaRepository<Examiner, Long> {
    Optional<Examiner> findByNationalProviderIdentifier(NationalProviderIdentifier nationalProviderIdentifier);

    boolean existsByNationalProviderIdentifier(NationalProviderIdentifier nationalProviderIdentifier);
}