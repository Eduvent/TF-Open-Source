package org.hign.platform.u202212645.assesment.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hign.platform.u202212645.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import org.hign.platform.u202212645.assesment.domain.model.valueobjects.NationalProviderIdentifier;
import org.hign.platform.u202212645.personnel.domain.model.aggregates.MentalStateExam;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
public class Examiner extends AuditableAbstractAggregateRoot<Examiner> {

    @Getter
    @Column(nullable = false)
    private String firstName;

    @Getter
    @Column(nullable = false)
    private String lastName;

    @Getter
    @Embedded
    @Column(nullable = false, unique = true)
    private NationalProviderIdentifier nationalProviderIdentifier;

    @OneToMany(mappedBy = "examinerNationalProviderIdentifier", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MentalStateExam> mentalStateExams = new HashSet<>();

    public Examiner(String firstName, String lastName, NationalProviderIdentifier nationalProviderIdentifier) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalProviderIdentifier = nationalProviderIdentifier;
    }

    public void addMentalStateExam(MentalStateExam exam) {
        mentalStateExams.add(exam);
        exam.setExaminerNationalProviderIdentifier(this.nationalProviderIdentifier);
    }

    public void removeMentalStateExam(MentalStateExam exam) {
        mentalStateExams.remove(exam);
        exam.setExaminerNationalProviderIdentifier(null);
    }
}