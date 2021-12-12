import Dezeus.Core.*;
import Dezeus.Logic.*;

public class Dezeus_Tests {

    public static void main(String[] args) {

        Sentential a = new Sentential("A");
        Sentential b = new Sentential("B");
        Sentential c = new Sentential("C");

        Statement p = new Cond(a, b);
        Statement q = new Cond(b, c);
        Statement r = new Cond(a, c);

        Statements premise = new Statements(p, q);
        Statement conclusion = r;

        Proposition p1 = new Proposition(premise, conclusion);
        try {
            Theorem t1 = p1.prove();
        } catch (Invalidation invalidation) {
            Debug.log("The proposition is invalid.");
        }
    }
}
