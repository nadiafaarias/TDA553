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
            if (car.getXCoordinate() < 700 && car.getXCoordinate() > 0) {
                car.move();
                CarApplication.frame.drawPanel.repaint();
            } else {
                car.invertPosition();
                car.move();
            }
            car.move();
            CarApplication.frame.drawPanel.repaint();
        }
    }
}
