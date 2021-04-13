package MyGarage;

import java.util.Collection;
public interface Garage {
    Collection<Owner> allCarsUniqueOwners();

    /**
     * Complexity should be less than O(n)
     */
    Collection<Car> topThreeCarsByMaxVelocity();

    /**
     * Complexity should be O(1)
     */
    Collection<Car> allCarsOfBrand(String brand);

    /**
     * Complexity should be less than O(n)
     */
    Collection<Car> carsWithPowerMoreThan(int power);

    /**
     * Complexity should be O(1)
     */
    Collection<Car> allCarsOfOwner(Owner owner);

    /**
     * @return mean value of owner age that has cars with given brand
     */
    int meanOwnersAgeOfCarBrand(String brand);

    /**
     * @return mean value of cars for all owners
     */
    int meanCarNumberForEachOwner();

    /**
     * Complexity should be less than O(n)
     * @return removed car
     */
    Car removeCar(int carId);

    /**
     * Complexity should be less than O(n)
     */
    void addNewCar(Car car, Owner owner);
}
