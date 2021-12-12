package Dezeus.Core;

public class Proposition {
    
    private Statement premise;
    private Statement conclusion;

    public Proposition(Statement premise, Statement conclusion) {
        this.premise = premise;
        this.conclusion = conclusion;
    }

    public Theorem prove() throws Invalidation {
        return null;
    }

    // Getters

    public Statement getPremise() {
        return premise;
    }

    public Statement getConclusion() {
        return conclusion;
    }

    // Utility Methods
}
