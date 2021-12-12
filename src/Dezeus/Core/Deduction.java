package Dezeus.Core;

public class Deduction {

    public Statements knowns = new Statements();

    public Deduction() {
    }

    public Deduction(Statements knowns) {
        this.knowns = knowns;
    }

    // Mirroring

    private Deduction(Deduction mirror) {
        this(mirror.knowns);
    }

    // Utility

    public Deduction copy() {
        return new Deduction(this);
    }

    public void addKnown(Statement known) {
        this.knowns.add(known);
    }
}
