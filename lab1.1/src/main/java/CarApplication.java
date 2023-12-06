public class CarApplication {

    static CarController frame;

    public void initializeApplication() {
        // Instance of this class
        CarViewGraphics cvg = new CarViewGraphics();
        frame = new CarController("CarSim 1.0", cvg, cvg.X, cvg.Y - 240);
    }

    public static void main(String[] args) {
        CarApplication instance = new CarApplication();
        instance.initializeApplication();

    }
}
