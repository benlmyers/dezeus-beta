package Dezeus.Core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Sentential extends Statement {

    private String name;

    @JsonCreator
    public Sentential(@JsonProperty("name") String name) {
        this.name = name;
    }

    // Implementation

    @Override
    protected Justification _show(Deduction deduction) throws Invalidation {
        return null;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int logicalSize() {
        return 1;
    }

    @Override
    public Statements getComponents() {
        return new Statements(this);
    }

    @Override
    public String getStatementType() {
        return "Sentential Variable";
    }

    // Getters

    public String getName() {
        return name;
    }
}