import java.awt.*;
import java.util.ArrayList;

public class Carrier extends Trucks{
    private final int maxNumberCars = 10;

    private boolean platformDown;
    private ArrayList <Car> listOfCars = new ArrayList<>();
    public Carrier() {
        nrDoors = 2;
        color = Color.green;
        modelName = "Carrier";
        enginePower = 80;
        platformDown = false;
        stopEngine();
    }


    public int getMaxNumberCars() {
        return maxNumberCars;
    }

    public ArrayList<Car> getListOfCars() {
        return listOfCars;
    }

    public boolean getPlatformPosition() {
        return platformDown;
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
            platformDown = !platformDown;
        }
    }

    public void loadCar(Car car) {
        if ((platformDown && distanceFromCarrier(car)) &&
                (listOfCars.size() < maxNumberCars) && car.getClass() != Carrier.class) {
            listOfCars.add(car);
            car.xCoordinate = xCoordinate;
            car.yCoordinate = yCoordinate;
        }
    }

    public void unLoadCar() {
        if(platformDown) {
            Car other = listOfCars.get(listOfCars.size() - 1);
            other.xCoordinate = xCoordinate + 1;
            other.yCoordinate = yCoordinate - 1;
            listOfCars.remove(listOfCars.size() - 1);
        }
    }

    public void move() {
        switch (position) {
            case "North":
                yCoordinate += currentSpeed;
                break;
            case "South":
                yCoordinate -= currentSpeed;
                break;
            case "West":
                xCoordinate -= currentSpeed;
                break;
            case "East":
                xCoordinate += currentSpeed;
                break;
        }
        for (Car car : listOfCars) {
            car.xCoordinate = xCoordinate;
            car.yCoordinate = yCoordinate;
            car.position = position;
        }
    }

    public void gas(double amount) {
        if (!platformDown) {
            incrementSpeed(amount);
        }
    }

}
