package Dezeus.Core;

public interface Statement {

    public Proof show(Deduction deduction) throws Invalidity;
}