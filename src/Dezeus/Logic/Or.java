package Dezeus.Logic;

import Dezeus.Core.*;

public class Or implements Statement {
    
    private Statement a, b;

    public Or(Statement a, Statement b) {
        this.a = a;
        this.b = b;
    }

    // Implementation

    @Override
    public Proof show(Deduction deduction) throws Invalidity {
        return null;
    }
}
