import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CarRepairShopTest {

    @Test
    public void createACarShop() {
        CarRepairShop<Car> carShop = new CarRepairShop<>(10);
        assertEquals(10, carShop.maxAmountCars);
    }

    @Test
    public void createAVolvoShop() {
        CarRepairShop<Volvo240> volvoShop = new CarRepairShop<>(7);
        assertEquals(7, volvoShop.maxAmountCars);
    }

    @Test
    public void turnInTooManyCar() {
        CarRepairShop<Car> carCarRepairShop = new CarRepairShop<>(1);
        Car car = new Car();
        Scania scania = new Scania();
        carCarRepairShop.turnInCar(car);
        carCarRepairShop.turnInCar(scania);
        assertEquals(1, carCarRepairShop.carsInShop.size());
    }
    @Test
    public void turnInCar() {
        CarRepairShop<Car> carCarRepairShop = new CarRepairShop<>(5);
        Car car = new Car();
        carCarRepairShop.turnInCar(car);
        assertEquals(1, carCarRepairShop.carsInShop.size());

    }

    @Test
    public void removeNonExistingCar() {
        CarRepairShop<Trucks> truckShop = new CarRepairShop<>(3);
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
        CarRepairShop<Carrier> carrierShop = new CarRepairShop<>(3);
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