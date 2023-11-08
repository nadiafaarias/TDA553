import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Volvo240Test {

    private Volvo240 volvo240;

    @BeforeEach
    public void createInstance() {
        volvo240 = new Volvo240();
    }
    @Test
    public void getNrDoors() {
        assertEquals(4, volvo240.nrDoors);
    }
    @Test
    public void getColor() {
        assertEquals(Color.black, volvo240.color);
    }
    @Test
    public void getEnginePower() {
        assertEquals(100, volvo240.enginePower);
    }
    @Test
    public void getModelName() {
        assertEquals("Volvo240", volvo240.modelName);
    }
    @Test
    public void gas() {
        volvo240.gas(10);
        assertEquals(10, volvo240.currentSpeed);
    }

}