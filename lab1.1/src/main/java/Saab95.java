import java.awt.*;

    public class Saab95 extends Car{

        protected boolean turboOn;

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
            currentSpeed = getCurrentSpeed() + speedFactor() * amount;
        }

        private void decrementSpeed(double amount){
            currentSpeed = getCurrentSpeed() - speedFactor() * amount;
        }


        // TODO fix this method according to lab pm
        public void gas(double amount){
            incrementSpeed(amount);
        }

        // TODO fix this method according to lab pm
        public void brake(double amount){
            decrementSpeed(amount);
        }
    }

