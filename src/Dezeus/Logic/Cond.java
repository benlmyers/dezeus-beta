package Dezeus.Logic;

import Dezeus.Core.*;

public class Cond implements Statement {

    private Statement ant, cons;

    public Cond(Statement ant, Statement cons) {
        this.ant = ant;
        this.cons = cons;
    }

    // Implementation

    @Override
    public Justification show(Deduction deduction) throws Invalidation {
        Deduction newDeduction = deduction.copy();
        newDeduction.addKnown(ant);
        try {
            return cons.show(newDeduction);
        } catch (Invalidation invalidation) {
            throw new CondInvalid(invalidation);
        }
    }

    @Override
    public String toString() {
        return ant + " => " + cons;
    }

    // Justification

    public class CondJustification extends Justification {

        private Justification cons;

        public CondJustification(Justification cons) {
            super("Assuming the antecedent is valid, the consequent is valid", "CD");
            this.cons = cons;
        }

        // Getters

        public Justification getCons() {
            return cons;
        }
    }

    // Invalidation

    public class CondInvalid extends Invalidation {

        private Invalidation invalidation;

        public CondInvalid(Invalidation invalidation) {
            super("Assuming the antecedent is valid, the consequent is invalid");
            this.invalidation = invalidation;
        }

        // Getters

        public Invalidation getinvalidation() {
            return invalidation;
        }
    }
}
