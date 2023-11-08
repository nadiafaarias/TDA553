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

}