package Dezeus.Logic;

import Dezeus.Core.*;

public class And implements Statement {

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
        } catch (Invalidation invalidity) {
            throw new AndInvalid(invalidity);
        }
        try {
            rightJustification = b.show(deduction);
        } catch (Invalidation invalidity) {
            throw new AndInvalid(invalidity);
        }
        return new AndJustification(leftJustification, rightJustification);
    }

    @Override
    public String toString() {
        return a + " ∧ ";
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

        private Invalidation invalidity;

        public AndInvalid(Invalidation invalidity) {
            super("One side of the AND is invalid");
            this.invalidity = invalidity;
        }

        // Getters

        public Invalidation getInvalidity() {
            return invalidity;
        }
    }
}
