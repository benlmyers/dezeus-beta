package Dezeus.Core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Justification {

    public static final Justification manual = new Justification("This is a manual justification", "!");

    protected String reason;
    private String symbol;

    @JsonCreator
    public Justification(@JsonProperty("reason") String reason, @JsonProperty("symbol") String symbol) {
        this.reason = reason;
        this.symbol = symbol;
    }

    // Implementation

    public String toString() {
        return reason + "(" + symbol + ")";
    }

    // Getters

    public final String getReason() {
        return reason;
    }

    public final String getSymbol() {
        return symbol;
    }
}