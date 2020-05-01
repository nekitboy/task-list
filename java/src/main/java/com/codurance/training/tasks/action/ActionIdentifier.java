package com.codurance.training.tasks.action;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ActionIdentifier {
    private final String identifier;

    public ActionIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return "Identifier: " + identifier;
    }
}