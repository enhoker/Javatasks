import java.util.Collection;

public class Car {
    private final int carId;
    private final String brand;
    private final String modelName;
    private final int maxVelocity;
    private final int power;
    private final int ownerId;

    public Car() {
        carId = 0;
        brand = null;
        modelName = null;
        maxVelocity = 0;
        power = 0;
        ownerId = 0;
    }

    public Car(int id, String brand, String modelName, int maxVelocity,int power, int ownerId) {
        this.carId = id;
        this.brand = brand;
        this.modelName = modelName;
        this.maxVelocity = maxVelocity;
        this.power = power;
        this.ownerId = ownerId;
    }

    public int compareToVelocity(Car o) {
        if (o.maxVelocity > maxVelocity) {
            return 1;
        }
        if (o.maxVelocity < maxVelocity) {
            return -1;
        }
        return 0;
    }

    public int compareToPower(Car o) {
        if (o.power > power) {
            return 1;
        }
        if (o.power < power) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return brand + ' ' + modelName;
    }

    public int getCarId() {
        return carId;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return modelName;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public int getMaxVelocity() {
        return maxVelocity;
    }

    public int getPower() {
        return power;
    }
}
