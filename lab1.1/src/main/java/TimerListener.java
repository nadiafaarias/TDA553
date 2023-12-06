import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* Each step the TimerListener moves all the cars in the list and tells the
 * view to update its images. Change this method to your needs.
 * */
class TimerListener implements ActionListener {

    CarController carController;

    public TimerListener(CarController carController) {
        this.carController = carController;
    }

    public void actionPerformed(ActionEvent e) {
        for (Car car : CarController.cars) {
            if (car.getYCoordinate() < 500 && car.getYCoordinate() > 0) {
                car.move();
                int x = (int) Math.round(car.getXCoordinate());
                int y = (int) Math.round(car.getYCoordinate());
                //CarApplication.frame.drawPanel.moveIt(x, y, car);
                CarApplication.frame.drawPanel.repaint();
            } else {
                car.invertPosition();
                car.move();
                int x = (int) Math.round(car.getXCoordinate());
                int y = (int) Math.round(car.getYCoordinate());
                //CarApplication.frame.drawPanel.moveIt(x, y, car);
            }
            car.move();
            CarApplication.frame.drawPanel.repaint();
        }
    }
}
