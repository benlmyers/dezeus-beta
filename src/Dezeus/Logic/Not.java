package Dezeus.Logic;

import Dezeus.Core.*;

public class Not extends Statement {
    
    private Statement a;

    public Not(Statement a) {
        this.a = a;
    }

    // Implementation

    @Override
    public Proof show(Deduction deduction) throws Invalidity {
        return null;
    }
}
