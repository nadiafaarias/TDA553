import java.awt.*;
import java.util.ArrayList;

public class Carrier extends Trucks{
    public int maxNumberCars = 10;
    public ArrayList <Car> listOfCars = new ArrayList<>();
    public Carrier() {
        nrDoors = 2;
        color = Color.green;
        modelName = "Carrier";
        enginePower = 80;
        platform = 0;
        stopEngine();
    }

    public double getPlatformPosition() {
        return platform;
    }

    public boolean distanceFromCarrier (Car other) {
        boolean distanceWithin2Meters = false;
        int d1 = Double.compare(xCoordinate, other.xCoordinate -2);
        int d2 = Double.compare(xCoordinate, other.xCoordinate + 2);
        int d3 = Double.compare(yCoordinate, other.yCoordinate - 2);
        int d4 = Double.compare(yCoordinate, other.yCoordinate + 2);
        if ((d1 >= 0 && d2 <= 0) && (d3 >= 0 && d4 <= 0)) {
            distanceWithin2Meters = true;
        }
        return distanceWithin2Meters;
    }
    public void changePlatform() {
        if (currentSpeed == 0) {
            platform = Math.abs(platform - 70);
        }
    }

    public void loadCar(Car car) {
        if ((platform == 70 && distanceFromCarrier(car)) &&
                (listOfCars.size() < maxNumberCars) && car.getClass() != Carrier.class) {
            listOfCars.add(car);
            car.xCoordinate = xCoordinate;
            car.yCoordinate = yCoordinate;
        }
    }

    public void unLoadCar() {
        if(platform == 70) {
            Car other = listOfCars.get(listOfCars.size() - 1);
            other.xCoordinate = xCoordinate + 1;
            other.yCoordinate = yCoordinate - 1;
            listOfCars.remove(listOfCars.size() - 1);
        }
    }

    public void driveCarrier() {
        move();
        for (Car car : listOfCars) {
            car.xCoordinate = xCoordinate;
            car.yCoordinate = yCoordinate;
            car.position = position;
        }
    }

}
