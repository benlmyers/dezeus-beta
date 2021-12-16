package Dezeus.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Dezeus.Core.Sentential;
import Dezeus.Core.Statement;

public class CharacteristicInt_Test {

    @Test
    public void oneVar() {

        Sentential a = new Sentential("A");

        Statement p = a.not();

        assertEquals(1, a.characteristicInt());
        assertEquals(0, p.characteristicInt());
    }

    @Test
    public void twoVar() {

        Sentential a = new Sentential("A");
        Sentential b = new Sentential("B");

        Statement p = a.implies(b);
        Statement q = a.and(b);
        Statement r = a.or(b);
        Statement s = a.iff(b);
        Statement t = a.provided(b);

        assertEquals(10, p.characteristicInt());
        assertEquals(1, q.characteristicInt());
        assertEquals(13, r.characteristicInt());
        assertEquals(0, s.characteristicInt());
        assertEquals(6, t.characteristicInt());
    }
}
