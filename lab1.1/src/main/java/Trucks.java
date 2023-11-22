public class Trucks extends Car {

    public double platform; // 0 when up, 70 when down, in between is angles

    protected double speedFactor(){
        return enginePower * 0.01;
    }

    public void gas(double amount){
        if (platform == 0){
            incrementSpeed(amount);
        }

    }
}
