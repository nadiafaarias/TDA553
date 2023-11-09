import java.awt.*;

    public class Saab95 extends Car{

        public boolean turboOn;

        public Saab95(){
            nrDoors = 2;
            color = Color.red;
            enginePower = 125;
            turboOn = false;
            modelName = "Saab95";
            stopEngine();
        }

        public void setTurboOn(){
            turboOn = true;
        }

        public void setTurboOff(){
            turboOn = false;
        }

        private double speedFactor(){
            double turbo = 1;
            if(turboOn) turbo = 1.3;
            return enginePower * 0.01 * turbo;
        }

        private void incrementSpeed(double amount){
            currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
        }

        private void decrementSpeed(double amount){
            currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
        }


        public void gas(double amount){
            if (amount >= 0 && amount <= 1) {
                incrementSpeed(amount);
            }

        }

        public void brake(double amount){
            if (amount >= 0 && amount <= 1) {
                decrementSpeed(amount);
            }

        }
    }

