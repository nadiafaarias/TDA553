import java.util.ArrayList;

public class CarRepairShop<A extends Car> {

    public int maxAmountCars;
    public ArrayList<A> carsInShop;

    public CarRepairShop(int numberCars){
        maxAmountCars = numberCars;
        carsInShop = new ArrayList<>();
    }

    public void turnInCar(A car) {
        if(carsInShop.size() < maxAmountCars) {
            carsInShop.add(car);
        }
    }

    public void reclaimCar(A car) {
        carsInShop.remove(car);
    }
}
