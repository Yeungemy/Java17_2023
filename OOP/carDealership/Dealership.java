package OOP.carDealership;

public class Dealership {
    private Car[] cars;

    public Car getCar(int index) {
        return new Car(this.cars[index]);
    }

    public void setCar(Car car, int index) {
        Car copy = new Car(car);
        this.cars[index] = copy;
    }

    public Dealership(Car[] cars){
        this.cars = new Car[cars.length];

        for(int i = 0; i < cars.length; i++){
            setCar(cars[i], i);
            // this.cars[i] = new Car(cars[i]);
        }
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < this.cars.length; i++) {
            temp += "\n\tParking Spot: " + (i + 1) + "\n" + this.cars[i].toString() + "\n\n";
        }
        return temp;
    }

    // public String toString(){
    //     String temp = "";
        
    //     for(int i = 0; i < this.cars.length; i++){
    //         temp += this.cars[i].toString() + "\n\n";
    //     }

    //     return temp;
    // }

    public void sellCar(int index){
        this.cars[index].drive();
    }

    public void removeCar(int indexOfItemToRemove){
        // deep copy with a temp array
        // hold a new array without the car sold
        Car[] temp = new Car[this.cars.length - 1];
        int j = 0;

        for(int i = 0; i < this.cars.length; i++){
            if(i != indexOfItemToRemove){
                temp[j++] = new Car(this.cars[i]);
            }
        }

        // update the new inventory
        this.cars = temp;

        // this.cars = new Car[temp.length];

        // for(int i = 0; i < temp.length; i++){
        //     this.cars[i] = new Car(temp[i]);
        // }
    }
}
