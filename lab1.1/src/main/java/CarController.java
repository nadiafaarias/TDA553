
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

/*
* This class represents the Controller part in the MVC pattern.
* Its responsibilities are to listen to the View and responds in an appropriate manner by
* modifying the model state and the updating the view.
*/

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 8;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.

    DrawPanel drawPanel;

    public CarController(String framename, CarViewGraphics cvg, int X, int Y) {
        drawPanel = new DrawPanel(X, Y);
        cvg.initComponents(framename, drawPanel);
        // Start the timer
        timer.start();
        cvg.addActionListenerToGasButton();
        cvg.addActionListenerToBrakeButton();
        cvg.addActionListenerToTurboOnButton();
        cvg.addActionListenerToTurboOffButton();
        cvg.addActionListenerToLiftBedButton();
        cvg.addActionListenerToLowerBedButton();
        cvg.addActionListenerToStartButton();
        cvg.addActionListenerToStopButton();
        cvg.addActionListenerToAddCarButton();
        cvg.addActionListenerToRemoveCarButton();
    }
    protected Timer timer = new Timer(delay, new TimerListener(this));

    // The frame that represents this instance View of the MVC pattern

    // A list of cars, modify if needed

    static void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : CarApplication.cars) {
            car.gas(gas);
        }
    }

    static void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : CarApplication.cars) {
            car.brake(brake);
        }
    }

    static void turboOn() {
        for (Car car : CarApplication.cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();

            }
        }
    }

    static void turboOff() {
        for (Car car : CarApplication.cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    static void liftBedUp() {
        for (Car car : CarApplication.cars) {
            if (car instanceof Scania) {
                ((Scania) car).raisePlatformAngle(5);
            }
        }
    }

    static void lowerBed() {
        for (Car car : CarApplication.cars) {
            if (car instanceof Scania) {
                ((Scania) car).lowerPlatformAngle(5);
            }
        }
    }

    static void startAllCars() {
        for (Car car : CarApplication.cars) {
            car.startEngine();
        }
    }

    static void stopAllCars() {
        for (Car car : CarApplication.cars) {
            car.stopEngine();
        }
    }

    static void addCar(String string) {
        int length = CarApplication.cars.size();
        if (length < 10) {
            switch (string) {
                case "Volvo240":
                    CarApplication.cars.add(CarFactory.createVolvo240());
                    CarApplication.cars.get(length).yCoordinate = length*100;
                    break;
                case "Saab95":
                    CarApplication.cars.add(CarFactory.createSaab95());
                    CarApplication.cars.get(length).yCoordinate = length*100;
                    break;
                case "Scania":
                    CarApplication.cars.add(CarFactory.createScania());
                    CarApplication.cars.get(length).yCoordinate = length*100;
                    break;
                case "Random":
                    List<String> stringList = Arrays.asList("Volvo240", "Saab95", "Scania");
                    int a = (int) Math.round(2 * Math.random());
                    addCar(stringList.get(a));
                    break;
            }
        }
    }
    static void removeCar() {
        int length = CarApplication.cars.size();
        if (length > 0) {
            CarApplication.cars.remove(length - 1);
        }
    }


}