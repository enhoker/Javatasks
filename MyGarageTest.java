import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

public class MyGarageTest {

    @Test
    public void Test() {
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

        // проверим функцию allCarsUniqueOwners
        {
            MyGarage garage = new MyGarage(cars, owners);
            Collection<Owner> exp = new ArrayList<Owner>(owners);
            exp.remove(o5);
            Collection<Owner> act = garage.allCarsUniqueOwners();

            boolean test = act.containsAll(exp) && exp.containsAll(act);
            Assert.assertTrue(test);
        }

        // проверим функцию topThreeCarsByMaxVelocity
        {
            MyGarage garage = new MyGarage(cars, owners);
            Collection<Car> exp = new ArrayList<Car>();
            exp.add(c3);
            exp.add(c9);
            exp.add(c2);
            Collection<Car> act = garage.topThreeCarsByMaxVelocity();

            boolean test = act.containsAll(exp) && exp.containsAll(act);
            Assert.assertTrue(test);
        }

        // проверим функцию allCarsOfBrand
        {
            MyGarage garage = new MyGarage(cars, owners);
            Collection<Car> expVolvo = new ArrayList<Car>();
            expVolvo.add(c1);
            expVolvo.add(c2);
            expVolvo.add(c6);
            expVolvo.add(c8);
            expVolvo.add(c10);
            Collection<Car> actVolvo = garage.allCarsOfBrand("Volvo");

            boolean testVolvo = actVolvo.containsAll(expVolvo) && expVolvo.containsAll(actVolvo);
            Assert.assertTrue(testVolvo);

            Collection<Car> expTesla = new ArrayList<>();
            expTesla.add(c9);
            expTesla.add(c11);
            Collection<Car> actTesla = garage.allCarsOfBrand("Tesla");

            boolean testTesla = actTesla.containsAll(expTesla) && expTesla.containsAll(actTesla);
            Assert.assertTrue(testTesla);
        }

        // проверим функцию carsWithPowerMoreThan
        {
            MyGarage garage = new MyGarage(cars, owners);
            Collection<Car> exp500 = new ArrayList<Car>();
            exp500.add(c3);
            exp500.add(c5);
            exp500.add(c9);
            exp500.add(c10);
            Collection<Car> act500 = garage.carsWithPowerMoreThan(500);
            boolean test500 = act500.containsAll(exp500) && exp500.containsAll(act500);
            Assert.assertTrue(test500);
        }

        // проверим функцию allCarsOfOwner
        {
            MyGarage garage = new MyGarage(cars, owners);
            Collection<Car> expTom= new ArrayList<Car>();
            expTom.add(c1);
            expTom.add(c4);
            expTom.add(c8);
            Collection<Car> actTom = garage.allCarsOfOwner(o1);
            boolean testTom = actTom.containsAll(expTom) && expTom.containsAll(actTom);
            Assert.assertTrue(testTom);
        }

        // проверим функцию meanOwnersAgeOfCarBrand
        {
            MyGarage garage = new MyGarage(cars, owners);
            int expVolvo = 37;
            int actVolvo = garage.meanOwnersAgeOfCarBrand("Volvo");
            Assert.assertEquals(expVolvo, actVolvo);
        }

        // проверим функцию meanCarNumberForEachOwner
        {
            MyGarage garage = new MyGarage(cars, owners);
            int exp = 2;
            int act = garage.meanCarNumberForEachOwner();
            Assert.assertEquals(exp, act);
        }

        //removeCarTest
        {
            ArrayList<Car> expcars = new ArrayList<Car>();
            expcars.add(c1);
            expcars.add(c2);
            expcars.add(c3);
            expcars.add(c4);
            expcars.add(c5);
            MyGarage actgarage = new MyGarage(cars, owners);
            MyGarage expgarage = new MyGarage(expcars, owners);
            actgarage.removeCar(6);
            actgarage.removeCar(7);
            actgarage.removeCar(8);
            actgarage.removeCar(9);
            actgarage.removeCar(10);
            actgarage.removeCar(11);

            boolean testV = actgarage.getSorted_by_maxV_cars().containsAll(expgarage.getSorted_by_maxV_cars());
            boolean testP = actgarage.getSorted_by_power_cars().containsAll(expgarage.getSorted_by_power_cars());
            boolean testC = actgarage.getCars().values().containsAll(expgarage.getCars().values());
            boolean testB = actgarage.getSorted_by_brand_cars().values().containsAll(expgarage.getSorted_by_brand_cars().values());
            boolean testO = actgarage.getSorted_by_owner_cars().values().containsAll(expgarage.getSorted_by_owner_cars().values());

            Assert.assertTrue(testV);
            Assert.assertTrue(testP);
            Assert.assertTrue(testC);
            Assert.assertTrue(testB);
            Assert.assertTrue(testO);
        }

        //addNewCarTest
        {
            ArrayList<Car> expcars = new ArrayList<Car>();
            expcars.add(c1);
            expcars.add(c2);
            expcars.add(c3);
            expcars.add(c7);
            expcars.add(c5);
            MyGarage actgarage = new MyGarage();
            MyGarage expgarage = new MyGarage(expcars, owners);
            actgarage.addNewCar(c1, o1);
            actgarage.addNewCar(c2, o2);
            actgarage.addNewCar(c3, o3);
            actgarage.addNewCar(c7, o4);
            actgarage.addNewCar(c5, o3);

            boolean testV = actgarage.getSorted_by_maxV_cars().containsAll(expgarage.getSorted_by_maxV_cars());
            boolean testP = actgarage.getSorted_by_power_cars().containsAll(expgarage.getSorted_by_power_cars());
            boolean testC = actgarage.getCars().values().containsAll(expgarage.getCars().values());
            boolean testB = actgarage.getSorted_by_brand_cars().values().containsAll(expgarage.getSorted_by_brand_cars().values());
            boolean testO = actgarage.getSorted_by_owner_cars().values().containsAll(expgarage.getSorted_by_owner_cars().values());

            Assert.assertTrue(testV);
            Assert.assertTrue(testP);
            Assert.assertTrue(testC);
            Assert.assertTrue(testB);
            Assert.assertTrue(testO);
        }

    }



}