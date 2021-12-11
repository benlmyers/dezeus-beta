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
    public Boolean getValue() {
        return value;
    }
}
