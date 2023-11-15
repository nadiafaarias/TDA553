public class Trucks extends Car {

    public double platform; // 0 when up, 70 when down, in between is angles

    private double speedFactor(){
        return enginePower * 0.01;
    }

    protected void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    public void brake(double amount){
        decrementSpeed(amount);

    }
    public void gas(double amount){
        if (platform == 0){
            incrementSpeed(amount);
        }

    }
}
