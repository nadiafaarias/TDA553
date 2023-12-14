import java.util.ArrayList;

public class CarApplication {

    public static ArrayList<Car> cars = new ArrayList<>();

    static CarController frame;

    public void initializeApplication() {
        // Instance of this class
        CarViewGraphics cvg = new CarViewGraphics();
        frame = new CarController("CarSim 1.0", cvg, cvg.X, cvg.Y - 240);
    }

    public static void main(String[] args) {
        CarApplication instance = new CarApplication();
        instance.initializeApplication();
        cars.add(CarFactory.createVolvo240());
        cars.add(CarFactory.createSaab95());
        cars.add(CarFactory.createScania());
        int y = 0;
        for (Car car : cars) {
            car.yCoordinate = y;
            y += 100;
        }
    }

}
