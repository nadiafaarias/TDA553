import java.util.ArrayList;

public class CarRepairShop<A extends Car> {

    private int maxAmountCars;
    private ArrayList<A> carsInShop;

    public int getMaxAmountCars() {
        return maxAmountCars;
    }

    public ArrayList<A> getCarsInShop() {
        return carsInShop;
    }

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
