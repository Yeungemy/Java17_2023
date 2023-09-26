package OOP.carDealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private List<Car> cars;

    /**
     * Create a getCar method that takes an index as a parameter and
     * returns a deep copy of the Car object at that index.
     */
    public Car getCar(int index) {
        return new Car(this.cars.get(index));
    }

    /**
     * Create a setCar method that takes a Car object and
     * an index as parameters and
     * sets the Car object at the specified index to a deep copy of the given
     * object.
     */
    public void setCar(Car car, int index) {
        this.cars.set(index, new Car(car));
    }

    /**
     * Create a constructor for the CarDealership class that initializes the cars
     * field to an empty ArrayList.
     */
    public Dealership() {
        this.cars = new ArrayList<>();
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < this.cars.size(); i++) {
            temp += "\n\tParking Spot: " + (i + 1) + "\n" + this.cars.get(i).toString() + "\n\n";
        }
        return temp;
    }

    // public String toString(){
    // String temp = "";

    // for(int i = 0; i < this.cars.length; i++){
    // temp += this.cars[i].toString() + "\n\n";
    // }

    // return temp;
    // }

    public void sellCar(int index) {
        new Car(this.cars.get(index)).drive();
    }

    public void removeCar(int indexOfItemToRemove) {
        this.cars.remove(indexOfItemToRemove);
    }

    /**
     * Create an addCar method that takes a Car object as a parameter and
     * adds a deep copy of the object to the cars ArrayList.
     */
    public void addCar(Car car) {
        this.cars.add(new Car(car));
    }

    /**
     * Create an addCars method that takes a Car array as a parameter and
     * adds a deep copy of the object to the cars ArrayList.
     */
    public void addCars(Car[] cars) {
        for (Car car : cars) {
            addCar(car);
        }
    }
}
