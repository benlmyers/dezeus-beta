package Dezeus.Logic;

import Dezeus.Core.*;

public class Not implements Statement {

    private Statement a;

    public Not(Statement a) {
        this.a = a;
    }

    // Implementation

    @Override
    public Justification show(Deduction deduction) throws Invalidation {
        try {
            Justification anti = a.show(deduction);
            throw new NotInvalid(anti);
        } catch (Invalidation invalidation) {
            return new NotJustification(invalidation);
        }
    }

    @Override
    public String toString() {
        return "¬" + a;
    }

    // Justification

    public class NotJustification extends Justification {

        private Invalidation negated;

        public NotJustification(Invalidation negated) {
            super("The negated statement is invalid", "NOT");
            this.negated = negated;
        }

        // Getters

        public Invalidation getNegated() {
            return negated;
        }
    }

    // Invalidation

    public class NotInvalid extends Invalidation {

        private Justification negation;

        public NotInvalid(Justification negation) {
            super("The negated statement is valid");
            this.negation = negation;
        }

        // Getters

        public Justification getNegation() {
            return negation;
        }
    }
}