package Dezeus.Core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Proposition {

    private Statements premises;
    private Statement conclusion;

    @JsonCreator
    public Proposition(@JsonProperty("premises") Statements premises,
            @JsonProperty("conclusion") Statement conclusion) {
        this.premises = premises;
        this.conclusion = conclusion;
    }

    public Proposition(Statement premise, Statement conclusion) {
        this(new Statements(premise), conclusion);
    }

    public Theorem prove() throws Invalidation {
        Debug.log("PROVE " + this);
        Deduction deduction = new Deduction(premises);
        Justification justification = conclusion.show(deduction);
        return new Theorem(this, justification);
    }

    // Getters

    public Statements getPremises() {
        return premises;
    }

    public Statement getConclusion() {
        return conclusion;
    }

    // Implementation

    @Override
    public String toString() {
        return premises + " ⊢ " + conclusion;
    }

    // Utility

    @JsonIgnore
    public Statements getComponents() {
        Statements components = new Statements();
        for(Statement premise: premises) {
            components.addAll(premise.getComponents());
        }
        components.addAll(conclusion.getComponents());
        return components;
    }
}
