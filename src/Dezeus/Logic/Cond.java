package Dezeus.Logic;

import Dezeus.Core.*;

public class Cond implements Statement {

    private Statement ant, cons;

    public Cond(Statement ant, Statement cons) {
        this.ant = ant;
        this.cons = cons;
    }
    
    // Implementation

    @Override
    public Proof show(Deduction deduction) throws Invalidity {
        return null;
    }
}
