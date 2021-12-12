package Dezeus.Core;

public class Truth implements Value<Boolean> {

    private Boolean value;

    public Truth(Boolean value) {
        this.value = value;
    }

    public Truth() {
        this(true);
    }

    // Implementation

    @Override
    public Boolean getValue(Deduction deduction) {
        return value;
    }

    @Override
    public Justification show(Deduction deduction) throws Invalidation {
        if (value) {
            return new TruthJustification();
        } else {
            throw new TruthInvalid();
        }
    }

    @Override
    public String toString() {
        return value ? "T" : "F";
    }

    // Justification

    public class TruthJustification extends Justification {

        public TruthJustification() {
            super("The truth value is true", "T");
        }
    }

    // Invalidation

    public class TruthInvalid extends Invalidation {

        public TruthInvalid() {
            super("The truth value is false");
        }
    }
}
