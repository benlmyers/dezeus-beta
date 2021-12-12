package Dezeus.Core;

public interface Statement {

    public Justification show(Deduction deduction) throws Invalidation;
}