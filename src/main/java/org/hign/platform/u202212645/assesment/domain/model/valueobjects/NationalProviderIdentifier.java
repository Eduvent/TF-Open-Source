package org.hign.platform.u202212645.assesment.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.UUID;

@Embeddable
@Getter
public class NationalProviderIdentifier {
    private final String value;

    public NationalProviderIdentifier() {
        this.value = UUID.randomUUID().toString();
    }

    public NationalProviderIdentifier(String value) {
        if (!isValidUUID(value)) {
            throw new IllegalArgumentException("Invalid UUID format");
        }
        this.value = value;
    }

    private boolean isValidUUID(String value) {
        try {
            UUID.fromString(value);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }
}