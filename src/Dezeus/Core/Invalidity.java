package Dezeus.Core;

public abstract class Invalidity extends Throwable {

    private String reason;

    public Invalidity(String reason) {
        this.reason = reason;
    }

    // Getters

    public String getReason() {
        return reason;
    }
}
