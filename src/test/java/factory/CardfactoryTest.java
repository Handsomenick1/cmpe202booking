package factory;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardfactoryTest {

    @Test
    public void cardValidHappy() {
        Cardfactory cardfactory = new Cardfactory("5410000000000000");
        assertTrue(cardfactory.cardValid());
    }

    @Test
    public void cardValidFailed() {
        Cardfactory cardfactory = new Cardfactory("123123123");
        assertFalse(cardfactory.cardValid());
    }
}