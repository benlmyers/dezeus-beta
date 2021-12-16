package Dezeus.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Dezeus.Core.Sentential;
import Dezeus.Core.Statement;

public class CharacteristicInt_Test {
    
    @Test
    public void test() {

        Sentential a = new Sentential("A");
        Sentential b = new Sentential("B");

        assertEquals(a.characteristicInt(), 1);
        // assertEquals(b.characteristicInt(), 2);
        // assertEquals(a.implies(b).characteristicInt(), 5);
    }
}
