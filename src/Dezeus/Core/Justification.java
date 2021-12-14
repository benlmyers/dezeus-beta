package Dezeus.Core;

public class Justification {

    public static final Justification manual = new Justification("This is a manual justification", "!");

    protected String reason;
    private String symbol;

    public Justification(String reason, String symbol) {
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