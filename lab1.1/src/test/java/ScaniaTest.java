import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {

    private Scania scania;

    @BeforeEach
    public void createCar() {
        scania = new Scania();
    }

    @Test
    public void testGetPlatformAngle() {
        assertEquals(0, scania.getPlatformAngle());
    }

    @Test
    public void raisePlatformWhileDriving() {
        scania.currentSpeed = 30;
        scania.raisePlatformAngle(20);
        assertEquals(0, scania.platform);
    }

    @Test
    public void raisePlatformWhileNotDriving() {
        scania.raisePlatformAngle(20);
        assertEquals(20, scania.platform);
    }

    @Test
    public void lowerPlatformParked() {
        scania.platform = 42;
        scania.lowerPlatformAngle(4);
        assertEquals(38, scania.platform);
    }

    @Test
    public void lowerPlatformWhileDriving() {
        scania.currentSpeed = 25;
        scania.platform = 30;
        scania.lowerPlatformAngle(5);
        assertEquals(30, scania.platform);
    }

    @Test
    public void gasAngle() {
        scania.platform = 10;
        scania.gas(1);
        assertEquals(0, scania.currentSpeed);
    }

    @Test
    public void gas() {
        scania.gas(1);
        assertEquals(0.8, scania.currentSpeed);
    }

    @Test
    public void brake() {
        scania.currentSpeed = 10;
        scania.brake(1);
        assertEquals(9.2, scania.currentSpeed);
    }

}