import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage volvo240;
    BufferedImage scania;
    BufferedImage saab95;

    Map<String, BufferedImage> imageList = new HashMap<>();


   /* void moveIt(int x, int y, Car car) {
        Point point = new Point(x, y);
        CarController.carPoints.put(car, point);
    }*/


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvo240 = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            scania = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            saab95 = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            imageList.put("Volvo240", volvo240);
            imageList.put("Scania", scania);
            imageList.put("Saab95", saab95);
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Car car : CarController.cars) {
            for (String key : imageList.keySet()) {
                if(Objects.equals(key, car.modelName)) {
                    g.drawImage(imageList.get(key), (int) Math.ceil(car.getXCoordinate()), (int) Math.ceil(car.getYCoordinate()),null);
                }
            }

        }
    }
}
