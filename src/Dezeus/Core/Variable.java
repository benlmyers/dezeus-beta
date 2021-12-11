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
}
