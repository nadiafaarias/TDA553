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
    public void  gasZero() {
        volvo240.gas(0);
        assertEquals(0, volvo240.currentSpeed);
    }
    @Test
    public void gasOne() {
        volvo240.gas(1);
        assertEquals(1.25, volvo240.currentSpeed);
    }
    @Test
    public void gasNegative() {
        volvo240.gas(-1);
        assertEquals(0, volvo240.currentSpeed);
    }
    @Test
    public void gasPositive() {
        volvo240.gas(2);
        assertEquals(0, volvo240.currentSpeed);
    }
    @Test
    public void brakeZero() {
        volvo240.brake(0);
        assertEquals(0, volvo240.currentSpeed);
    }

    @Test
    public void brakeOne() {
        volvo240.currentSpeed = 10;
        volvo240.brake(1);
        assertEquals(8.75, volvo240.currentSpeed);
    }
    @Test
    public void brakeNegative() {
        volvo240.brake(-1);
        assertEquals(0, volvo240.currentSpeed);
    }

    @Test
    public void brakeLargerThanOne() {
        volvo240.currentSpeed = 10;
        volvo240.brake(2);
        assertEquals(10, volvo240.currentSpeed);
    }
}