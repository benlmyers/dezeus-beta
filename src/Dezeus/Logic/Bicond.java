package Dezeus.Logic;

import Dezeus.Core.Statement;

public class Bicond extends And {

    public Bicond(Statement a, Statement b) {
        super(new Cond(a, b), new Cond(b, a));
    }

    // Implementation

    @Override
    public String toString() {
        return a + " <=> " + b;
    }
}
