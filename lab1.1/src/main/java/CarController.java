
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

    DrawPanel drawPanel;

    public CarController(String framename, CarViewGraphics cvg, int X, int Y) {
        drawPanel = new DrawPanel(X, Y);
        cvg.initComponents(framename, drawPanel);
        cars.add(volvo);
        cars.add(saab);
        cars.add(scania);
        int y = 0;
        for (Car car : cars) {
            //Point point = new Point(0,y);
            //carPoints.put(car,point);
            car.yCoordinate = y;
            y += 100;
        }
        // Start the timer
        timer.start();
        cvg.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gas(cvg.gasAmount);
            }
        });

        cvg.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brake(cvg.gasAmount);
            }
        });

        cvg.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turboOn();
            }
        });

        cvg.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turboOff();
            }
        });

        cvg.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liftBedUp();
            }
        });

        cvg.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lowerBed();
            }
        });

        cvg.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startAllCars();
            }
        });

        cvg.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopAllCars();
            }
        });
    }
    protected Timer timer = new Timer(delay, new TimerListener(this));

    // The frame that represents this instance View of the MVC pattern

    // A list of cars, modify if needed
    public static ArrayList<Car> cars = new ArrayList<>();
    Saab95 saab = new Saab95();
    Volvo240 volvo = new Volvo240();
    Scania scania = new Scania();

    //public Dictionary<Car, Point> carPoints = new Hashtable<>();

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