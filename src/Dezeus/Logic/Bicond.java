package Dezeus.Logic;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import Dezeus.Core.Statement;

public class Bicond extends And {

    @JsonCreator
    public Bicond(@JsonProperty("left") Statement a, @JsonProperty("right") Statement b) {
        super(new Cond(a, b), new Cond(b, a));
    }

    // Implementation

    @Override
    public String toString() {
        return a + " ↔ " + b;
    }

    @Override
    public String getStatementType() {
        return "Biconditional";
    }
}
