import java.awt.*;

    public abstract class  Car implements Movable{

        protected double xCoordinate;
        protected double yCoordinate;
        protected String position;

        protected Car(){
            xCoordinate = 0;
            yCoordinate = 0;
            position = "East";
        }

        protected int nrDoors; // Number of doors on the car
        protected double enginePower; // Engine power of the car
        protected double currentSpeed; // The current speed of the car
        protected Color color; // Color of the car
        protected String modelName; // The car model name


        public double getXCoordinate() {
            return xCoordinate;
        }

        public double getYCoordinate() {
            return yCoordinate;
        }

        public String getPosition() {
            return position;
        }
        public void move() {
            switch (position) {
                case "North":
                    yCoordinate += currentSpeed;
                    break;
                case "South":
                    yCoordinate -= currentSpeed;
                    break;
                case "West":
                    xCoordinate -= currentSpeed;
                    break;
                case "East":
                    xCoordinate += currentSpeed;
                    break;
            }

        }

        public void turnLeft() {
            switch (position) {
                case "North":
                    position = "West";
                    break;
                case "West":
                    position = "South";
                    break;
                case "South":
                    position = "East";
                    break;
                case "East":
                    position = "North";
                    break;
            }
        }

        public void turnRight() {
            switch (position) {
                case "North":
                    position = "East";
                    break;
                case "East":
                    position = "South";
                    break;
                case "South":
                    position = "West";
                    break;
                case "West":
                    position = "North";
                    break;

            }
        }

        public void invertPosition() {
            switch (position) {
                case "North":
                    position = "South";
                    break;
                case "South":
                    position = "North";
                    break;
                case "West":
                    position = "East";
                    break;
                case "East":
                    position = "West";
                    break;
            }
        }




        protected int getNrDoors(){
            return nrDoors;
        }
        protected double getEnginePower(){
            return enginePower;
        }

        public double getCurrentSpeed(){
            return currentSpeed;
        }

        protected Color getColor(){
            return color;
        }

        protected void setColor(Color clr){
            color = clr;
        }

        public void startEngine(){
            currentSpeed = 0.1;
        }

        public void stopEngine() {
            currentSpeed = 0;
        }
        protected abstract double speedFactor();

        protected void incrementSpeed(double amount){
            currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
        }

        protected void decrementSpeed(double amount){
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


