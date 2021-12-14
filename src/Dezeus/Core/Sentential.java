package Dezeus.Core;

public class Sentential extends Statement {

    private String name;

    public Sentential(String name) {
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