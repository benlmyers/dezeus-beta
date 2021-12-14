package Dezeus.Test;

import Dezeus.Core.*;

import java.io.File;

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

        Theorem test2;

        try {
            test2 = Theorem.load(new File("resources/theorems/test.json"));
            Debug.log(test2.getName());
            Debug.log(test2.getProposition());
            Debug.log(test2.getProof());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
