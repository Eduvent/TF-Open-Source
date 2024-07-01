package org.hign.platform.u202212645.assesment.domain.model.aggregates;

import org.hign.platform.u202212645.assesment.domain.model.commands.CreateExaminerCommand;
import org.hign.platform.u202212645.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import org.hign.platform.u202212645.assesment.domain.model.valueobjects.NationalProviderIdentifier;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
public class Examiner extends AuditableAbstractAggregateRoot<Examiner> {

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Embedded
    @Column(nullable = false, unique = true)
    private NationalProviderIdentifier nationalProviderIdentifier;

    public Examiner(String firstName, String lastName, NationalProviderIdentifier nationalProviderIdentifier) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalProviderIdentifier = nationalProviderIdentifier;
    }
}
