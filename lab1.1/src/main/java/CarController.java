
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    ButtonModel buttonModel = new ButtonModel();

    public CarController(String framename, CarViewGraphics cvg, int X, int Y) {
        drawPanel = new DrawPanel(X, Y);
        cvg.initComponents(framename, drawPanel);
        cars.add(Volvo240.createCar());
        cars.add(Saab95.createCar());
        cars.add(Scania.createCar());
        int y = 0;
        for (Car car : cars) {
            car.yCoordinate = y;
            y += 100;
        }
        // Start the timer
        timer.start();
        cvg.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonModel.gas(cvg.gasAmount);
            }
        });

        cvg.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonModel.brake(cvg.gasAmount);
            }
        });

        cvg.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonModel.turboOn();
            }
        });

        cvg.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonModel.turboOff();
            }
        });

        cvg.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonModel.liftBedUp();
            }
        });

        cvg.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonModel.lowerBed();
            }
        });

        cvg.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonModel.startAllCars();
            }
        });

        cvg.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonModel.stopAllCars();
            }
        });
        cvg.addCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonModel.addCar(cvg.carModel);
            }
        });
        cvg.removeCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonModel.removeCar();
            }
        });
    }
    protected Timer timer = new Timer(delay, new TimerListener(this));

    // The frame that represents this instance View of the MVC pattern

    // A list of cars, modify if needed
    public static ArrayList<Car> cars = new ArrayList<>();


}