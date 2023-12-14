import java.awt.*;

public class Scania extends Trucks{

    private double platform;
    public Scania(){
        nrDoors = 2;
        color = Color.pink;
        enginePower = 80;
        modelName = "Scania";
        platform = 0;
        stopEngine();
    }

    public double getPlatformAngle() {
        return platform;
    }

    public void raisePlatformAngle(double degrees) {
        if (currentSpeed == 0) {
            platform = Math.min(platform + degrees, 70);
        }
    }

    public void lowerPlatformAngle(double degrees) {
        if (currentSpeed == 0) {
            platform = Math.max(platform - degrees, 0);
        }
    }

    public void gas(double amount) {
        if (platform == 0) {
            incrementSpeed(amount);
        }
    }
}
