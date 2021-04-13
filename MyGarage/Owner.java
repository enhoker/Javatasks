package MyGarage;
import java.util.Collection;

public class Owner {
    private final int id;
    private final String name;
    private final String lastName;
    private final int age;

    public Owner() {
        id = 0;
        name = null;
        lastName = null;
        age = 0;
    }

    public Owner(int i, String n, String ln, int a) {
        id = i;
        name = n;
        lastName = ln;
        age = a;
    }

    @Override
    public String toString() {
        return name + ' ' + lastName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}
