package Dezeus.Core;

public abstract class Statement {

    public abstract Proof show(Deduction deduction) throws Invalidity;
}