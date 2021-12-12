package Dezeus.Core;

public class Proposition {

    private Statements premises;
    private Statement conclusion;

    public Proposition(Statements premises, Statement conclusion) {
        this.premises = premises;
        this.conclusion = conclusion;
    }

    public Proposition(Statement premise, Statement conclusion) {
        this(new Statements(premise), conclusion);
    }

    public Theorem prove() throws Invalidation {
        // TODO: Implement
        return null;
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
}
