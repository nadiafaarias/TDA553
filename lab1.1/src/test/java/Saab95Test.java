import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {

    private Saab95 saab95;

    @BeforeEach
    public void createInstance() {
        saab95 = new Saab95();
    }

    @Test
    public void setTurboOn() {
        saab95.setTurboOn();
        assertTrue(saab95.turboOn);
    }
    @Test
    public void setTurboOff() {
        saab95.setTurboOff();
        assertFalse(saab95.turboOn);
    }
    @Test
    public void  gasZero() {
        saab95.gas(0);
        assertEquals(0, saab95.currentSpeed);
    }
    @Test
    public void gasOne() {
        saab95.gas(1);
        assertEquals(1.25, saab95.currentSpeed);
    }
    @Test
    public void gasNegative() {
        saab95.gas(-1);
        assertEquals(0, saab95.currentSpeed);
    }
    @Test
    public void gasPositive() {
        saab95.gas(2);
        assertEquals(0, saab95.currentSpeed);
    }
    @Test
    public void brakeZero() {
        saab95.brake(0);
        assertEquals(0, saab95.currentSpeed);
    }

    @Test
    public void brakeOne() {
        saab95.currentSpeed = 10;
        saab95.brake(1);
        assertEquals(8.75, saab95.currentSpeed);
    }


    @Test
    public void brakeNegative() {
        saab95.brake(-1);
        assertEquals(0, saab95.currentSpeed);
    }

    @Test
    public void brakeLargerThanOne() {
        saab95.currentSpeed = 10;
        saab95.brake(2);
        assertEquals(10, saab95.currentSpeed);
    }
}