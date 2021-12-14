package Dezeus.Test;

import Dezeus.Core.*;

public class Dezeus_Example {

    public static void main(String[] args) {

        Sentential a = new Sentential("A");
        Sentential b = new Sentential("B");

        Statements premise = new Statements(a.implies(b), a);
        Statement conclusion = b;

        Proposition p1 = new Proposition(premise, conclusion);

        Theorem test = new Theorem(p1, Justification.manual);

        try {
            test.saveToFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
