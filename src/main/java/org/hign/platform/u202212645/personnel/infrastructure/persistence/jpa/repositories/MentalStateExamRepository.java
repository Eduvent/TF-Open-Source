package org.hign.platform.u202212645.personnel.infrastructure.persistence.jpa.repositories;

import org.hign.platform.u202212645.personnel.domain.model.aggregates.MentalStateExam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentalStateExamRepository extends JpaRepository<MentalStateExam, Long> {
}