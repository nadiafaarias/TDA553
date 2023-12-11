import java.awt.*;

public class Volvo240 extends Car implements CarFactory{

    private final double trimFactor = 1.25;

    public Volvo240(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
    }

    public static Car createCar() {
        return new Volvo240();
    }

    protected double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

}
