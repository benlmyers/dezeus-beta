package Dezeus.Core;

public abstract class Justification {

    protected String reason;
    private String symbol;

    public Justification(String reason, String symbol) {
        this.reason = reason;
        this.symbol = symbol;
    }

    public String getReason() {
        return reason;
    }

    public String getSymbol() {
        return symbol;
    }

    // Implementation

    public String toString() {
        return reason + "(" + symbol + ")";
    }
}
