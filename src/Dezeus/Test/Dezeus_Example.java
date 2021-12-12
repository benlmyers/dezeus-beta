package Dezeus.Test;

import Dezeus.Core.*;

public class Dezeus_Example {

    public static void main(String[] args) {

        Sentential a = new Sentential("A");
        Sentential b = new Sentential("B");
        Sentential c = new Sentential("C");

        Statement p = a.implies(b);
        Statement q = b.implies(c);
        Statement r = a.implies(c);

        Statements premise = new Statements(p, q);
        Statement conclusion = r;

        Proposition p1 = new Proposition(premise, conclusion);
        Debug.log(p1);

        try {
            Theorem t1 = p1.prove();
        } catch (Invalidation invalidation) {
            Debug.log("The proposition is invalid. Reason: " + invalidation);
        }
    }
}
