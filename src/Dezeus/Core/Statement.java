package Dezeus.Core;

import Dezeus.Logic.*;

public abstract class Statement {

    public final Justification show(Deduction deduction) throws Invalidation {
        Deduction newDeduction = deduction.copy();
        newDeduction.depth += 1;
        Debug.log(empty(newDeduction.depth) + "SHOW " + this);
        return _show(newDeduction);
    }

    protected abstract Justification _show(Deduction deduction) throws Invalidation;

    public abstract Statements getComponents();

    public int logicalSize() {
        return getComponents().logicalSize();
    }

    // Utility

    public And and(Statement b) {
        return new And(this, b);
    }

    public Or or(Statement b) {
        return new Or(this, b);
    }

    public Not not() {
        return new Not(this);
    }

    public Cond provided(Statement ant) {
        return new Cond(ant, this);
    }

    public Cond implies(Statement cons) {
        return new Cond(this, cons);
    }

    public Bicond iff(Statement b) {
        return new Bicond(this, b);
    }

    // Private Utility

    private static String empty(int count) {
        String str = "";
        for (int i = 0; i < count; i++) {
            str += " ";
        }
        return str;
    }
}