import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarrierTest {
    private Carrier carrier;

    @BeforeEach
    public void createCarrier() {
        carrier = new Carrier();
    }

    @Test
    public void testGetPlatformPosition() {
        assertFalse(carrier.getPlatformPosition());
    }


    @Test
    public void tooFarFromCarrierX() {
        Car car = new Volvo240();
        car.xCoordinate = 3;
        assertFalse(carrier.distanceFromCarrier(car));
    }

    @Test
    public void tooFarFromCarrierY() {
        Car car = new Volvo240();
        car.yCoordinate = 3;
        assertFalse(carrier.distanceFromCarrier(car));
    }

    @Test
    public void distanceFromCarrierTrue() {
        Car car = new Saab95();
        car.xCoordinate = 1.5;
        assertTrue(carrier.distanceFromCarrier(car));
    }

    @Test
    public void changePlatformTrue() {
        carrier.currentSpeed = 0;
        carrier.changePlatform();
        assertTrue(carrier.getPlatformPosition());
    }
    @Test
    public void changePlatformWhileMoving() {
        carrier.currentSpeed = 10;
        carrier.changePlatform();
        assertFalse(carrier.getPlatformPosition());
    }
    @Test
    public void changePlatformFalse() {
        carrier.currentSpeed = 0;
        carrier.changePlatform();
        carrier.changePlatform();
        assertFalse(carrier.getPlatformPosition());
    }


    @Test
    public void testLoadCarWhilePlatformUp() {
        Car car = new Volvo240();
        carrier.loadCar(car);
        assertEquals(0, carrier.getListOfCars().size());
    }

    @Test
    public void testLoadCarToFarAway() {
        Car car = new Volvo240();
        car.xCoordinate = 5;
        carrier.changePlatform();
        carrier.loadCar(car);
        assertEquals(0, carrier.getListOfCars().size());
    }

    @Test
    public void testLoadToManyCars() {
        Car car1 = new Saab95();
        Car car2 = new Volvo240();
        Car car3 = new Saab95();
        Car car4 = new Volvo240();
        Car car5 = new Saab95();
        Car car6 = new Volvo240();
        Car car7 = new Saab95();
        Car car8 = new Volvo240();
        Car car9 = new Saab95();
        Car car10 = new Volvo240();
        Car car11 = new Saab95();
        carrier.changePlatform();
        carrier.loadCar(car1);
        carrier.loadCar(car2);
        carrier.loadCar(car3);
        carrier.loadCar(car4);
        carrier.loadCar(car5);
        carrier.loadCar(car6);
        carrier.loadCar(car7);
        carrier.loadCar(car8);
        carrier.loadCar(car9);
        carrier.loadCar(car10);
        carrier.loadCar(car11);
        assertEquals(10, carrier.getListOfCars().size());
    }

    @Test
    public void testLoadingACarrier() {
        Carrier carrier1 = new Carrier();
        carrier.changePlatform();
        carrier.loadCar(carrier1);
        assertEquals(0, carrier.getListOfCars().size());
    }

    @Test
    public void testLoadAVolvo240() {
        Volvo240 volvo240 = new Volvo240();
        carrier.changePlatform();
        carrier.loadCar(volvo240);
        assertEquals(1, carrier.getListOfCars().size());
    }

    @Test
    public void testUnloadingCarWhilePlatformUp() {
        Car car = new Saab95();
        carrier.changePlatform();
        carrier.loadCar(car);
        carrier.changePlatform();
        carrier.unLoadCar();
        assertEquals(1, carrier.getListOfCars().size());
    }

    @Test
    public void unloadCorrectCar() {
        Car car1 = new Volvo240();
        Car car2 = new Saab95();
        carrier.changePlatform();
        carrier.loadCar(car1);
        carrier.loadCar(car2);
        carrier.unLoadCar();
        assertEquals(car1, carrier.getListOfCars().get(0));
        assertEquals(1, carrier.getListOfCars().size());
    }

    @Test
    public void unloadedCarsCoordinates() {
        Car car = new Saab95();
        carrier.changePlatform();
        carrier.loadCar(car);
        carrier.unLoadCar();
        assertEquals(car.xCoordinate, carrier.xCoordinate + 1);
        assertEquals(car.yCoordinate, carrier.yCoordinate - 1);
    }


    @Test
    public void driveCarrier() {
        carrier.changePlatform();
        Car car1 = new Volvo240();
        Car car2 = new Saab95();
        carrier.loadCar(car1);
        carrier.loadCar(car2);
        carrier.changePlatform();
        carrier.gas(2);
        carrier.move();
        assertEquals(carrier.xCoordinate, car1.xCoordinate);
        assertEquals(carrier.yCoordinate, car1.yCoordinate );
        assertEquals(carrier.xCoordinate, car2.xCoordinate);
        assertEquals(carrier.yCoordinate, car2.yCoordinate );
    }
    @Test
    public void testMovingCar() {
        carrier.gas(2);
        carrier.move();
        assertEquals(1.6, carrier.yCoordinate);
    }
    @Test
    public void gasWhilePlatformDown() {
        carrier.changePlatform();
        carrier.gas(1);
        assertEquals(0, carrier.currentSpeed);
    }

    @Test
    public void gasWhilePlatformUp() {
        carrier.gas(2);
        assertEquals(1.6, carrier.currentSpeed);
    }
}


