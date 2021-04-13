package MyGarage;
import java.util.*;

public class MyGarage implements Garage {
    private HashMap<Integer, Car> cars;  
    private HashMap<Integer, Owner> owners; 
    private ArrayList<Car> sortedByMaxVelocityCars;
    private ArrayList<Car> sortedByPowerCars; 
    private HashMap<String, ArrayList<Car>> sortedByBrandCars;
    private HashMap<Owner, ArrayList<Car>> sortedByOwnerCars;

    public MyGarage() {
        cars = new HashMap<Integer, Car>();
        owners = new HashMap<Integer, Owner>();
        sorted_by_maxV_cars = new ArrayList<Car>();
        sorted_by_power_cars = new ArrayList<Car>();
        sorted_by_brand_cars = new HashMap<String, ArrayList<Car>>();
        sorted_by_owner_cars = new HashMap<Owner, ArrayList<Car>>();
    }
    
    private void addOwners(Collection<Owner> owners) {
        for (Owner owner : owners) {
            this.owners.put(owner.getId(), owner);
        }
    }
    
    private void addCars(Collection<Car> cars) {
        for (Car car : cars) {
            this.cars.put(car.getCarId(), car); 
            sortedByMaxVelocityCars.add(car);
            sortedByPowerCars.add(car);
            
            if (sortedByBrandCars.containsKey(car.getBrand())) {
                sortedByBrandCars.get(car.getBrand()).add(car);
            } else {
                ArrayList<Car> NewBrand = new ArrayList<Car>();
                NewBrand.add(car);
                sortedByBrandCars.put(car.getBrand(), NewBrand);
            }

            if (sortedByOwnerCars.containsKey(owners.get(car.getOwnerId()))) {
                sortedByOwnerCars.get(owners.get(car.getOwnerId())).add(car);
            } else {
                ArrayList<Car> NewOwner = new ArrayList<Car>();
                NewOwner.add(car);
                sortedByOwnerCars.put(owners.get(car.getOwnerId()), NewOwner);
            }
        }
    }

    public MyGarage(Collection<Car> c, Collection<Owner> o) {
        cars = new HashMap<Integer, Car>();
        owners = new HashMap<Integer, Owner>();
        sorted_by_maxV_cars = new ArrayList<Car>();
        sorted_by_power_cars = new ArrayList<Car>();
        sorted_by_brand_cars = new HashMap<String, ArrayList<Car>>();
        sorted_by_owner_cars = new HashMap<Owner, ArrayList<Car>>();
        
        this.addOwners(o);
        this.addCars(c);
        sortedByMaxVelocityCars.sort(Car::compareToVelocity);
        sortedByPowerCars.sort(Car::compareToPower);
    }

    public Collection<Owner> allCarsUniqueOwners() {
        return sortedByOwnerCars.keySet();
    }

    public Collection<Car> topThreeCarsByMaxVelocity() {
        ArrayList<Car> TopThreeCars = new ArrayList<>();
        TopThreeCars.add(sortedByMaxVelocityCars.get(0));
        TopThreeCars.add(sortedByMaxVelocityCars.get(1));
        TopThreeCars.add(sortedByMaxVelocityCars.get(2));
        return TopThreeCars;
    }

    public Collection<Car> allCarsOfBrand(String brand) {
        return sortedByBrandCars.get(brand);
    }

    public Collection<Car> carsWithPowerMoreThan(int power) {
        ArrayList<Car> PowerCars = new ArrayList<Car>();
        int i = 0;
        while (sortedByPowerCars.get(i).getPower() > power) {
            PowerCars.add(sortedByPowerCars.get(i));
            i = i + 1;
        }
        return PowerCars;
    }

    public Collection<Car> allCarsOfOwner(Owner owner) {
        return sortedByOwnerCars.get(owner);
    }

    public int meanOwnersAgeOfCarBrand(String brand) {
        int sumAge = 0; 
        int numberOwners = 0; 
        for (Owner owner : sortedByOwnerCars.keySet()) {
            if (!Collections.disjoint(sortedByOwnerCars.get(owner), sortedByBrandCars.get(brand))) {
                sumAge = sumAge + owner.getAge();
                numberOwners = numberOwners + 1;
            }
        }
        return sumAge / numberOwners;
    }

    public int meanCarNumberForEachOwner() {
        int sumNumber = 0; 
        int numberOwners = 0; 
        for (Owner owner : sortedByOwnerCars.keySet()) {
            sumNumber = sumNumber + sortedByOwnerCars.get(owner).size();
            numberOwners = numberOwners + 1;
        }
        return sumNumber / numberOwners;
    }

    public Car removeCar(int carId) {
        Car car = cars.get(carId);
        sortedByMaxVelocityCars.remove(car);
        sortedByPowerCars.remove(car);
        for (String i : sortedByBrandCars.keySet()) {
            sortedByBrandCars.get(i).remove(car);
        }
        for (Owner i : sortedByOwnerCars.keySet()) {
            sortedByOwnerCars.get(i).remove(car);
        }
        cars.remove(carId);
        return car;
    }

    public void addNewCar(Car car, Owner owner) {
        if(car.getOwnerId() != owner.getId()) {
            return;
        }

        if(cars.size() == 0) {
            cars.put(car.getCarId(), car);
            owners.put(owner.getId(), owner);
            sortedByMaxVelocityCars.add(car);
            sortedByPowerCars.add(car);
            ArrayList<Car> templeO = new ArrayList<Car>();
            templeO.add(car);
            ArrayList<Car> templeB = new ArrayList<Car>();
            templeB.add(car);
            sortedByOwnerCars.put(owner, templeO);
            sortedByBrandCars.put(car.getBrand(), templeB);
            return;
        }

        if (cars.containsKey(car.getCarId())) {
            return;
        }
      
        cars.put(car.getCarId(), car);
        if (!(owners.containsValue(owner))) {
            owners.put(owner.getId(), owner);
        }

        if (sortedByBrandCars.containsKey(car.getBrand())) {
            sortedByBrandCars.get(car.getBrand()).add(car);
        } else {
            ArrayList<Car> NewBrand = new ArrayList<Car>();
            NewBrand.add(car);
            sortedByBrandCars.put(car.getBrand(), NewBrand);
        }

        if (sortedByOwnerCars.containsKey(owners.get(car.getOwnerId()))) {
            sortedByOwnerCars.get(owners.get(car.getOwnerId())).add(car);
        } else {
            ArrayList<Car> NewOwner = new ArrayList<Car>();
            NewOwner.add(car);
            sortedByOwnerCars.put(owners.get(car.getOwnerId()), NewOwner);
        }

        int i = 0;
        while ((sortedByPowerCars.get(i).getPower() > car.getPower()) && (i < sortedByPowerCars.size() - 1)) {
            i = i + 1;
        }
        sortedByPowerCars.add(i, car);

        i = 0;
        while ((sortedByMaxVelocityCars.get(i).getMaxVelocity() > car.getMaxVelocity()) && (i < sortedByMaxVelocityCars.size() - 1)) {
            i = i + 1;
        }
        sortedByMaxVelocityCars.add(i, car);
    }

    @Override
    public String toString() {
        if (cars.size() == 0) { return "Garage is empty"; }
        return "Garage: " + cars;
    }

    public ArrayList<Car> getSortedByMaxVelocityCars() {
        return sortedByMaxVelocityCars;
    }

    public ArrayList<Car> getSortedByPowerCars() {
        return sortedByPowerCars;
    }

    public HashMap<Integer, Car> getCars() {
        return cars;
    }

    public HashMap<Integer, Owner> getOwners() {
        return owners;
    }

    public HashMap<String , ArrayList<Car>> getSortedByBrandCars() {
        return sortedByBrandCars;
    }

    public HashMap<Owner, ArrayList<Car>> getSortedByOwnerCars() {
        return sortedByOwnerCars;
    }
}
