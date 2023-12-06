
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

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
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    private static ArrayList<Car> cars = new ArrayList<>();
    protected static Saab95 saab = new Saab95();
    protected static Volvo240 volvo = new Volvo240();
    protected static Scania scania = new Scania();

    public static Dictionary<Car, Point> carPoints = new Hashtable<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        cc.cars.add(volvo);
        cc.cars.add(saab);
        cc.cars.add(scania);
        int y = 0;
        for (Car car : cars) {
            Point point = new Point(0,y);
            carPoints.put(car,point);
            car.yCoordinate = y;
            y += 100;
        }

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                if (car.getYCoordinate() < 500 && car.getYCoordinate() > 0) {
                    car.move();
                    int x = (int) Math.round(car.getXCoordinate());
                    int y = (int) Math.round(car.getYCoordinate());
                    frame.drawPanel.moveIt(x, y, car);
                    frame.drawPanel.repaint();
                }
                else {
                    car.invertPosition();
                    car.move();
                    int x = (int) Math.round(car.getXCoordinate());
                    int y = (int) Math.round(car.getYCoordinate());
                    frame.drawPanel.moveIt(x, y, car);
                }
                car.move();
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
    }

    void turboOn() {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();

            }
        }
    }

    void turboOff() {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void liftBedUp() {
        for (Car car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).raisePlatformAngle(5);
            }
        }
    }

    void lowerBed() {
        for (Car car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).lowerPlatformAngle(5);
            }
        }
    }

    void startAllCars() {
        for (Car car : cars) {
            car.startEngine();
        }
    }

    void stopAllCars() {
        for (Car car : cars) {
            car.stopEngine();
        }
    }
}