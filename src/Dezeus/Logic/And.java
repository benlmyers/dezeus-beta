package Dezeus.Logic;

import Dezeus.Core.*;

public class And extends Statement {

    protected Statement a, b;

    public And(Statement a, Statement b) {
        this.a = a;
        this.b = b;
    }

    // Implementation

    @Override
    public Justification show(Deduction deduction) throws Invalidation {
        Justification leftJustification, rightJustification;
        try {
            leftJustification = a.show(deduction);
        } catch (Invalidation invalidation) {
            throw new AndInvalid(invalidation);
        }
        try {
            rightJustification = b.show(deduction);
        } catch (Invalidation invalidation) {
            throw new AndInvalid(invalidation);
        }
        return new AndJustification(leftJustification, rightJustification);
    }

    @Override
    public String toString() {
        return a + " ∧ ";
    }

    @Override
    public Statements getComponents() {
        return new Statements(a, b);
    }

    // Justification

    public class AndJustification extends Justification {

        private Justification left, right;

        public AndJustification(Justification left, Justification right) {
            super("Both sides of the AND are valid", "AND");
            this.left = left;
            this.right = right;
        }

        // Getters

        public Justification getLeft() {
            return left;
        }

        public Justification getRight() {
            return right;
        }
    }

    // Invalidation

    public class AndInvalid extends Invalidation {

        private Invalidation invalidation;

        public AndInvalid(Invalidation invalidation) {
            super("One side of the AND is invalid");
            this.invalidation = invalidation;
        }

        // Getters

        public Invalidation getinvalidation() {
            return invalidation;
        }
    }
}
