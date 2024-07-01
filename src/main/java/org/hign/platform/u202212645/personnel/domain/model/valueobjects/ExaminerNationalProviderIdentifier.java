package org.hign.platform.u202212645.personnel.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.UUID;

@Embeddable
@Getter
public class ExaminerNationalProviderIdentifier {
    private String value;

    public ExaminerNationalProviderIdentifier() {
    }

    public ExaminerNationalProviderIdentifier(String value) {
        if (!isValidUUID(value)) {
            throw new IllegalArgumentException("Invalid UUID format");
        }
        this.value = value;
    }

    private boolean isValidUUID(String value) {
        try {
            UUID.fromString(value);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}