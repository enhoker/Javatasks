import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        Car c1 = new Car(1, "Volvo", "White Dash", 700, 300, 1);
        Car c2 = new Car(2, "Volvo", "Black Night", 800, 310, 2);
        Car c3 = new Car(3, "BMW", "Batmobile", 12000, 555, 3);
        Car c4 = new Car(4, "Lada", "Calina", 150, 400, 1);
        Car c5 = new Car(5, "BMW", "Battank", 100, 800, 3);
        Car c6 = new Car(6, "Volvo", "Red Rose", 200, 100, 2);
        Car c7 = new Car(7, "Lada", "Patriot", 320, 110, 4);
        Car c8 = new Car(8, "Volvo", "Blue Fish", 324, 100, 1);
        Car c9 = new Car(9, "Tesla", "Batship", 1000, 2021, 3);
        Car c10 = new Car(10, "Volvo", "Green Hulk", 100, 750, 2);
        Car c11 = new Car(11, "Tesla", "Sugar Speed", 230, 50, 6 );

        Owner o1 = new Owner(1, "Tom", "Cruise", 58);
        Owner o2 = new Owner(2, "Star", "Butterfly", 16);
        Owner o3 = new Owner(3, "Bruce", "Wayne", 45);
        Owner o4 = new Owner(4, "Nikolay", "Romanov", 37);
        Owner o5 = new Owner(5, "SpongeBob", "SquarePants", 21);
        Owner o6 = new Owner(6, "Pinky", "Pie", 23);

        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(c1);
        cars.add(c2);
        cars.add(c3);
        cars.add(c4);
        cars.add(c5);
        cars.add(c6);
        cars.add(c7);
        cars.add(c8);
        cars.add(c9);
        cars.add(c10);
        cars.add(c11);

        ArrayList<Owner> owners = new ArrayList<Owner>();
        owners.add(o1);
        owners.add(o2);
        owners.add(o3);
        owners.add(o4);
        owners.add(o5);
        owners.add(o6);

        MyGarage garage = new MyGarage(cars, owners);


        System.out.println(garage.carsWithPowerMoreThan(500));
















    }
}
