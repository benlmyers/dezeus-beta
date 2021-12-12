package Dezeus.Core;

public class Sentential extends Statement {

    private String name;

    public Sentential(String name) {
        this.name = name;
    }

    // Implementation

    @Override
    public Justification show(Deduction deduction) throws Invalidation {
        // TODO: Show a variable
        return null;
    }

    @Override
    public String toString() {
        return name;
    }
}