package Dezeus.Logic;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import Dezeus.Core.Deduction;
import Dezeus.Core.Invalidation;
import Dezeus.Core.Justification;
import Dezeus.Core.Sentential;
import Dezeus.Core.Statement;
import Dezeus.Core.Statements;

public class Or extends Statement {

    private Statement a, b;

    @JsonCreator
    public Or(@JsonProperty("left") Statement a, @JsonProperty("right") Statement b) {
        this.a = a;
        this.b = b;
    }

    // Implementation

    @Override
    protected Justification _show(Deduction deduction) throws Invalidation {
        try {
            Justification left = a.show(deduction);
            return new OrJustification(left, true);
        } catch (Invalidation leftinvalidation) {
            try {
                Justification right = b.show(deduction);
                return new OrJustification(right, false);
            } catch (Invalidation rightinvalidation) {
                throw new OrInvalid(leftinvalidation, rightinvalidation);
            }
        }
    }

    @Override
    public String toString() {
        return a + " ∨ " + b;
    }

    @Override
    public Statements getComponents() {
        return new Statements(a, b);
    }

    @Override
    public String getStatementType() {
        return "Or";
    }

    @Override
    public boolean isTrue(Set<Sentential> provisions) {
        return a.isTrue(provisions) || b.isTrue(provisions);
    }

    // Getters

    public Statement getLeft() {
        return a;
    }

    public Statement getRight() {
        return b;
    }

    // Justification

    public class OrJustification extends Justification {

        private Justification first;

        public OrJustification(Justification first, boolean isLeft) {
            super("A side of the OR is valid", "OR");
            this.first = first;
            if (isLeft)
                super.reason = "The left side of the OR is valid";
            else
                super.reason = "The right side of the OR is valid";
        }

        // Getters

        public Justification getFirst() {
            return first;
        }
    }

    // Invalidation

    public class OrInvalid extends Invalidation {

        private Invalidation left;
        private Invalidation right;

        public OrInvalid(Invalidation left, Invalidation right) {
            super("Both sides of the OR are invalid");
            this.left = left;
            this.right = right;
        }

        // Getters

        public Invalidation getLeft() {
            return left;
        }

        public Invalidation getRight() {
            return right;
        }
    }
}