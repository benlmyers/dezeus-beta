package Dezeus.Core;

import Dezeus.Logic.*;

public abstract class Statement {

    public abstract Justification show(Deduction deduction) throws Invalidation;

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
}