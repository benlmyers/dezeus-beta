package Dezeus.Logic;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import Dezeus.Core.Deduction;
import Dezeus.Core.Invalidation;
import Dezeus.Core.Justification;
import Dezeus.Core.Statement;
import Dezeus.Core.Statements;

public class And extends Statement {

    protected Statement a, b;

    @JsonCreator
    public And(@JsonProperty("left") Statement a, @JsonProperty("right") Statement b) {
        this.a = a;
        this.b = b;
    }

    // Implementation

    @Override
    protected Justification _show(Deduction deduction) throws Invalidation {
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
        return a + " ∧ " + b;
    }

    @Override
    public Statements getComponents() {
        return new Statements(a, b);
    }

    @Override
    public String getStatementType() {
        return "And";
    }

    // Getters

    public Statement getLeft() {
        return a;
    }

    public Statement getRight() {
        return b;
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

        public Invalidation getInvalidation() {
            return invalidation;
        }
    }
}
