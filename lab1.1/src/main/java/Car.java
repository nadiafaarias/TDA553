import java.awt.*;

    public class Car implements Movable{

        protected double xCoordinate;
        protected double yCoordinate;
        protected String position;

        protected Car(){
            xCoordinate = 0;
            yCoordinate = 0;
            position = "North";
        }

        protected int nrDoors; // Number of doors on the car
        protected double enginePower; // Engine power of the car
        protected double currentSpeed; // The current speed of the car
        protected Color color; // Color of the car
        protected String modelName; // The car model name

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


        public int getNrDoors(){
            return nrDoors;
        }
        public double getEnginePower(){
            return enginePower;
        }

        public double getCurrentSpeed(){
            return currentSpeed;
        }

        public Color getColor(){
            return color;
        }

        public void setColor(Color clr){
            color = clr;
        }

        public void startEngine(){
            currentSpeed = 0.1;
        }

        public void stopEngine() {
            currentSpeed = 0;
        }
    }

