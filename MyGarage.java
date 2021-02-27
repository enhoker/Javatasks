import java.util.*;

public class MyGarage implements Garage {
    private HashMap<Integer, Car> cars;  //словарь машинок, стоящих в гараже, где ключом является id машинки
    private HashMap<Integer, Owner> owners; //словарь владельцев, где ключом является id владельца
    private ArrayList<Car> sorted_by_maxV_cars; //коллекция машинок, отсортированных по максимальной скорости
    private ArrayList<Car> sorted_by_power_cars; //коллекция машинок, отсортированных по мощности
    private HashMap<String, ArrayList<Car>> sorted_by_brand_cars;  //набор коллекций машинок разных брендов
    private HashMap<Owner, ArrayList<Car>> sorted_by_owner_cars;  //набор коллекций машинок разных владельцев


    // конструктор по умолчанию
    public MyGarage() {
        cars = new HashMap<Integer, Car>();
        owners = new HashMap<Integer, Owner>();
        sorted_by_maxV_cars = new ArrayList<Car>();
        sorted_by_power_cars = new ArrayList<Car>();
        sorted_by_brand_cars = new HashMap<String, ArrayList<Car>>();
        sorted_by_owner_cars = new HashMap<Owner, ArrayList<Car>>();
    }

    // конструктор не по умолчанию
    public MyGarage(Collection<Car> c, Collection<Owner> o) {

        // инициализируем поля класса
        cars = new HashMap<Integer, Car>();
        owners = new HashMap<Integer, Owner>();
        sorted_by_maxV_cars = new ArrayList<Car>();
        sorted_by_power_cars = new ArrayList<Car>();
        sorted_by_brand_cars = new HashMap<String, ArrayList<Car>>();
        sorted_by_owner_cars = new HashMap<Owner, ArrayList<Car>>();

        // добавим по очереди всех владельцев
        for (Owner owner : o) {
            owners.put(owner.getId(), owner);  //ключом назначим id владельца
        }

        // добавим по очереди машинки в гараж
        for (Car car : c) {

            // добавим во все коллекции машинок новую машинку
            cars.put(car.getCarId(), car);  //ключом для машинки назначим id машинки
            sorted_by_maxV_cars.add(car);
            sorted_by_power_cars.add(car);

            // проверим, есть ли уже в гараже машинки того же бренда
            if (sorted_by_brand_cars.containsKey(car.getBrand())) {

                // если есть -- добавим новую машинку в коллекцию машинок того же бренда
                sorted_by_brand_cars.get(car.getBrand()).add(car);
            } else {

                // если нет -- создадим новую коллекцию для машинок нового бренда и добавим в неё новую машинку
                ArrayList<Car> NewBrand = new ArrayList<Car>();
                NewBrand.add(car);
                sorted_by_brand_cars.put(car.getBrand(), NewBrand);
            }

            // проверим, есть ли уже в гараже машинки того же владельца
            if (sorted_by_owner_cars.containsKey(owners.get(car.getOwnerId()))) {

                // если есть -- добавим новую машинку в коллекцию машинок того же владельца
                sorted_by_owner_cars.get(owners.get(car.getOwnerId())).add(car);
            } else {

                // если нет -- создадим новую коллекцию для машинок нового владельца и добавим в неё новую машинку
                ArrayList<Car> NewOwner = new ArrayList<Car>();
                NewOwner.add(car);
                sorted_by_owner_cars.put(owners.get(car.getOwnerId()), NewOwner);
            }
        }

        // добавим по очереди владельцев в коллекцию владельцев
        for (Owner own : o) {
            owners.put(own.getId(), own); //ключом назначим id владельца
        }

        // отсортируем коллекции машинок по максимальной скорости и мощности
        sorted_by_maxV_cars.sort(Car::compareToV);
        sorted_by_power_cars.sort(Car::compareToP);
    }

    // метод возвращает коллекцию владельцев хотя бы одной машины в гараже, владельцы в коллекции не повторяются
    public Collection<Owner> allCarsUniqueOwners() {
        return sorted_by_owner_cars.keySet();
    }

    // метод возвращает коллекцию из топ-3 машин с самыми большими значениями максимальной скорости
    public Collection<Car> topThreeCarsByMaxVelocity() {
        ArrayList<Car> TopCars = new ArrayList<>();

        // добавим в коллекцию TopCars машинки с номерами 0, 1 и 2 из отсортированной по скорости коллекции машин
        TopCars.add(sorted_by_maxV_cars.get(0));
        TopCars.add(sorted_by_maxV_cars.get(1));
        TopCars.add(sorted_by_maxV_cars.get(2));

        return TopCars;
    }

    // метод возвращает коллекцию машинок заданного бренда
    public Collection<Car> allCarsOfBrand(String brand) {
        return sorted_by_brand_cars.get(brand);
    }

    // метод возвращает коллекцию машин с мощностью большей заданного значения
    public Collection<Car> carsWithPowerMoreThan(int power) {
        ArrayList<Car> PowerCars = new ArrayList<Car>();
        int i = 0;
        while (sorted_by_power_cars.get(i).getPower() > power) {
            PowerCars.add(sorted_by_power_cars.get(i));
            i = i + 1;
        }

        return PowerCars;
    }

    // метод возвращает коллекцию машинок, принадлежащих заданному владельцу
    public Collection<Car> allCarsOfOwner(Owner owner) {
        return sorted_by_owner_cars.get(owner);
    }

    // метод возвращает средний возраст всех владельцев машин заданного бренда
    public int meanOwnersAgeOfCarBrand(String brand) {
        int sumAge = 0;  //суммарный возраст всех владельцев отя бы одного автомобиля заданного бренда
        int numberOwners = 0;  //количество владельцев хотя бы одного автомобиля заданного бренда
        for (Owner owner : sorted_by_owner_cars.keySet()) {
            if (!Collections.disjoint(sorted_by_owner_cars.get(owner), sorted_by_brand_cars.get(brand))) {
                sumAge = sumAge + owner.getAge();
                numberOwners = numberOwners + 1;
            }
        }
        return sumAge / numberOwners;
    }

    // метод возвращает среднее число машин у владельцев, владеющих хотя бы одной машинкой заданного бренда
    public int meanCarNumberForEachOwner() {
        int sumNumber = 0;  //общее число машин
        int numberOwners = 0;  //общее число владельцев

        for (Owner owner : sorted_by_owner_cars.keySet()) {
            sumNumber = sumNumber + sorted_by_owner_cars.get(owner).size();
            numberOwners = numberOwners + 1;
        }
        return sumNumber / numberOwners;
    }

    // метод удаляет машинку с заданным id из гаража и возвращает удалённую машинку
    public Car removeCar(int carId) {

        Car car = cars.get(carId); //найдём машинку по её id

        // удалим машинку из всех коллекций машинок
        sorted_by_maxV_cars.remove(car);
        sorted_by_power_cars.remove(car);
        for (String i : sorted_by_brand_cars.keySet()) {
            sorted_by_brand_cars.get(i).remove(car);
        }
        for (Owner i : sorted_by_owner_cars.keySet()) {
            sorted_by_owner_cars.get(i).remove(car);
        }

        cars.remove(carId);

        return car;
    }

    // метод добавляет машинку в гараж
    public void addNewCar(Car car, Owner owner) {

        // проверим, является ли переданный нам owner владельцем car
        if(car.getOwnerId() != owner.getId()) {
            return;
        }

        // если то первая машинка в гараже -- просто добавим её во все коллекции
        if(cars.size() == 0) {

            cars.put(car.getCarId(), car);
            owners.put(owner.getId(), owner);
            sorted_by_maxV_cars.add(car);
            sorted_by_power_cars.add(car);
            ArrayList<Car> templeO = new ArrayList<Car>();
            templeO.add(car);
            ArrayList<Car> templeB = new ArrayList<Car>();
            templeB.add(car);
            sorted_by_owner_cars.put(owner, templeO);
            sorted_by_brand_cars.put(car.getBrand(), templeB);
            return;
        }

        // проверим, есть ли машинка с таким id уже в нашем гараже
        if (cars.containsKey(car.getCarId())) {
            return;
        }

        // добавим машинку в коллекцию cars
        cars.put(car.getCarId(), car);
        if (!(owners.containsValue(owner))) {
            owners.put(owner.getId(), owner);
        }

        // проверим, есть ли уже в гараже машинки того же бренда
        if (sorted_by_brand_cars.containsKey(car.getBrand())) {

            // если есть -- добавим новую машинку в коллекцию машинок того же бренда
            sorted_by_brand_cars.get(car.getBrand()).add(car);

        } else {

            // если нет -- создадим новую коллекцию для машинок нового бренда и добавим в неё новую машинку
            ArrayList<Car> NewBrand = new ArrayList<Car>();
            NewBrand.add(car);
            sorted_by_brand_cars.put(car.getBrand(), NewBrand);
        }

        // проверим, есть ли уже в гараже машинки того же владельца
        if (sorted_by_owner_cars.containsKey(owners.get(car.getOwnerId()))) {

            // если есть -- добавим новую машинку в коллекцию машинок того же владельца
            sorted_by_owner_cars.get(owners.get(car.getOwnerId())).add(car);
        } else {

            // если нет -- создадим новую коллекцию для машинок нового владельца и добавим в неё новую машинку
            ArrayList<Car> NewOwner = new ArrayList<Car>();
            NewOwner.add(car);
            sorted_by_owner_cars.put(owners.get(car.getOwnerId()), NewOwner);
        }

        int i = 0;
        while ((sorted_by_power_cars.get(i).getPower() > car.getPower()) && (i < sorted_by_power_cars.size() - 1)) {
            i = i + 1;
        }
        sorted_by_power_cars.add(i, car);

        i = 0;
        while ((sorted_by_maxV_cars.get(i).getMaxVelocity() > car.getMaxVelocity()) && (i < sorted_by_maxV_cars.size() - 1)) {
            i = i + 1;
        }
        sorted_by_maxV_cars.add(i, car);

    }

    @Override
    public String toString() {
        if (cars.size() == 0) { return "Garage is empty"; }
        return "Garage: " + cars;
    }

    public ArrayList<Car> getSorted_by_maxV_cars() {
        return sorted_by_maxV_cars;
    }

    public ArrayList<Car> getSorted_by_power_cars() {
        return sorted_by_power_cars;
    }

    public HashMap<Integer, Car> getCars() {
        return cars;
    }

    public HashMap<Integer, Owner> getOwners() {
        return owners;
    }

    public HashMap<String , ArrayList<Car>> getSorted_by_brand_cars() {
        return sorted_by_brand_cars;
    }

    public HashMap<Owner, ArrayList<Car>> getSorted_by_owner_cars() {
        return sorted_by_owner_cars;
    }
}