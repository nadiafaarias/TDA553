import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private Car car;

    @BeforeEach
    public void createInstance() {
        car = new Volvo240();
    }

    @Test
    public void getX() {
        assertEquals(0, car.xCoordinate);
    }
    @Test
    public void getY() {
        assertEquals(0, car.yCoordinate);
    }
    @Test
    public void getPos() {
        assertEquals("North", car.position);
    }
    @Test
    public void turnNorthToWest() {
        car.turnLeft();
        assertEquals("West", car.position);
    }
    @Test
    public void turnWestToSouth() {
        car.position = "West";
        car.turnLeft();
        assertEquals("South", car.position);
    }
    @Test
    public void turnSouthToEast() {
        car.position = "South";
        car.turnLeft();
        assertEquals("East", car.position);
    }
    @Test
    public void turnEastToNorth() {
        car.position = "East";
        car.turnLeft();
        assertEquals("North", car.position);
    }
    @Test
    public void turnNorthToEast() {
        car.turnRight();
        assertEquals("East", car.position);
    }
    @Test
    public void turnEastToSouth() {
        car.position = "East";
        car.turnRight();
        assertEquals("South", car.position);
    }
    @Test
    public void turnSouthToWest() {
        car.position = "South";
        car.turnRight();
        assertEquals("West", car.position);
    }
    @Test
    public void turnWestToNorth() {
        car.position = "West";
        car.turnRight();
        assertEquals("North", car.position);
    }
    @Test
    public void moveNorth() {
        car.currentSpeed = 5;
        car.move();
        assertEquals(5, car.yCoordinate);
    }
    @Test
    public void moveSouth() {
        car.position = "South";
        car.currentSpeed = 5;
        car.move();
        assertEquals(-5, car.yCoordinate);
    }
    @Test
    public void moveWest() {
        car.position = "West";
        car.currentSpeed = 5;
        car.move();
        assertEquals(-5, car.xCoordinate);
    }
    @Test
    public void moveEast() {
        car.position = "East";
        car.currentSpeed = 5;
        car.move();
        assertEquals(5, car.xCoordinate);
    }
    @Test
    public void getNrDoors() {
        car.nrDoors = 2;
        assertEquals(2, car.getNrDoors());
    }
    @Test
    public void getEnginePower() {
        car.enginePower = 100;
        assertEquals(100, car.getEnginePower());
    }
    @Test
    public void getCurrentSpeed() {
        car.currentSpeed = 50;
        assertEquals(50, car.getCurrentSpeed());
    }
    @Test
    public void getColor() {
        car.color = Color.red;
        assertEquals(Color.red, car.getColor());
    }

    @Test
    public void setColor(){
        car.setColor(Color.red);
        assertEquals(Color.red, car.color);
    }

    @Test
    public void startEngine() {
        car.startEngine();
        assertEquals(0.1, car.currentSpeed);
    }

    @Test
    public void stopEngine() {
        car.stopEngine();
        assertEquals(0, car.currentSpeed);
    }
}