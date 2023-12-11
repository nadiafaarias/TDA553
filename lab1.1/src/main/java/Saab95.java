import java.awt.*;

    public class Saab95 extends Car implements CarFactory{

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

        protected double speedFactor(){
            double turbo = 1;
            if(turboOn) turbo = 1.3;
            return enginePower * 0.01 * turbo;
        }

        public static Car createCar() {
            return new Saab95();
        }
    }

