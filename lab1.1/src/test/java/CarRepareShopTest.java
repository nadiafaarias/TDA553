import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CarRepareShopTest {

    @Test
    public void createACarShop() {
        CarRepareShop<Car> carShop = new CarRepareShop<>(10);
        assertEquals(10, carShop.maxAmountCars);
    }

    @Test
    public void createAVolvoShop() {
        CarRepareShop<Volvo240> volvoShop = new CarRepareShop<>(7);
        assertEquals(7, volvoShop.maxAmountCars);
    }

    @Test
    public void turnInTooManyCar() {
        CarRepareShop<Car> carCarRepareShop = new CarRepareShop<>(1);
        Car car = new Car();
        Scania scania = new Scania();
        carCarRepareShop.turnInCar(car);
        carCarRepareShop.turnInCar(scania);
        assertEquals(1, carCarRepareShop.carsInShop.size());
    }
    @Test
    public void turnInCar() {
        CarRepareShop<Car> carCarRepareShop = new CarRepareShop<>(5);
        Car car = new Car();
        carCarRepareShop.turnInCar(car);
        assertEquals(1, carCarRepareShop.carsInShop.size());

    }

    @Test
    public void removeNonExistingCar() {
        CarRepareShop<Trucks> truckShop = new CarRepareShop<>(3);
        Scania scania = new Scania();
        Trucks trucks = new Trucks();
        truckShop.turnInCar(trucks);
        truckShop.reclaimCar(scania);
        ArrayList<Trucks> testList = new ArrayList<>();
        testList.add(trucks);
        assertEquals(truckShop.carsInShop, testList);
    }
    @Test
    public void removeCar() {
        CarRepareShop<Carrier> carrierShop = new CarRepareShop<>(3);
        Carrier carrier1 = new Carrier();
        Carrier carrier2 = new Carrier();
        carrierShop.turnInCar(carrier1);
        carrierShop.turnInCar(carrier2);
        carrierShop.reclaimCar(carrier1);
        ArrayList<Carrier> testList = new ArrayList<>();
        testList.add(carrier2);
        assertEquals(carrierShop.carsInShop, testList);
    }

}