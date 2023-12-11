import java.util.Arrays;
import java.util.List;

public class ButtonModel {
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : CarController.cars) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : CarController.cars) {
            car.brake(brake);
        }
    }

    void turboOn() {
        for (Car car : CarController.cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();

            }
        }
    }

    void turboOff() {
        for (Car car : CarController.cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void liftBedUp() {
        for (Car car : CarController.cars) {
            if (car instanceof Scania) {
                ((Scania) car).raisePlatformAngle(5);
            }
        }
    }

    void lowerBed() {
        for (Car car : CarController.cars) {
            if (car instanceof Scania) {
                ((Scania) car).lowerPlatformAngle(5);
            }
        }
    }

    void startAllCars() {
        for (Car car : CarController.cars) {
            car.startEngine();
        }
    }

    void stopAllCars() {
        for (Car car : CarController.cars) {
            car.stopEngine();
        }
    }

    void addCar(String string) {
        int length = CarController.cars.size();
        if (length < 10) {
            switch (string) {
                case "Volvo240":
                    CarController.cars.add(Volvo240.createCar());
                    CarController.cars.get(length).yCoordinate = length*100;
                    break;
                case "Saab95":
                    CarController.cars.add(Saab95.createCar());
                    CarController.cars.get(length).yCoordinate = length*100;
                    break;
                case "Scania":
                    CarController.cars.add(Scania.createCar());
                    CarController.cars.get(length).yCoordinate = length*100;
                    break;
                case "Random":
                    List<String> stringList = Arrays.asList("Volvo240", "Saab95", "Scania");
                    int a = (int) Math.round(2 * Math.random());
                    addCar(stringList.get(a));
                    break;
            }
        }
    }
    void removeCar() {
        int length = CarController.cars.size();
        if (length > 0) {
            CarController.cars.remove(length - 1);
        }
    }
}
