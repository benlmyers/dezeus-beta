package Dezeus.Core;

public class Variable<T> implements Value<T> {

    private String name;

    public Variable(String name) {
        this.name = name;
    }

    // Implementation

    @Override
    public T getValue() {
        return null;
    }

    @Override
    public Justification show(Deduction deduction) throws Invalidation {
        return null;
    }

    @Override
    public String toString() {
        return name;
    }

    // Getters

    public String getName() {
        return name;
    }
}
