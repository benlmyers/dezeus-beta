package Dezeus.Test;

import Dezeus.Core.*;

public class Dezeus_Example {

    public static void main(String[] args) {

        Sentential a = new Sentential("A");
        Sentential b = new Sentential("B");
        Sentential c = new Sentential("C");
        Sentential d = new Sentential("D");

        Statement p = a.implies(b);
        Statement q = b.implies(c);
        Statement r = a.implies(c);
        Statement s = a.and(d);

        Statements premise = new Statements(a, p, q, d);
        Statement conclusion = s;

        Proposition p1 = new Proposition(premise, conclusion);

        try {
            Theorem t1 = p1.prove();
        } catch (Invalidation invalidation) {
            Debug.log("The proposition is invalid. Reason: " + invalidation);
        }
    }
}
