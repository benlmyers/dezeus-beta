package Dezeus.Core;

public abstract class Invalidation extends Throwable {

    private String reason;

    public Invalidation(String reason) {
        this.reason = reason;
    }

    // Getters

    public String getReason() {
        return reason;
    }

    // Implementation

    @Override
    public String toString() {
        return reason;
    }
}
