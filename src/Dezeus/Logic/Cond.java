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
        return cons.show(newDeduction);
    }

    // Justification

    public class ConditionalJustification extends Justification {

        private Justification cons;

        public ConditionalJustification(Justification cons) {
            super("Assuming the antecedent is valid, the consequent is valid", "CD");
            this.cons = cons;
        }

        // Getters

        public Justification getCons() {
            return cons;
        }
    }

    // Invalidation

    public class ConditionalInvalid extends Invalidation {

        private Invalidation invalidity;

        public ConditionalInvalid(String reason) {
            super(reason);
            this.invalidity = invalidity;
        }

        // Getters

        public Invalidation getInvalidity() {
            return invalidity;
        }
    }
}
