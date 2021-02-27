import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {

    @Test
    public void Test() {

        // создадим тестовые машинки
        Car c1 = new Car(1, "Volvo", "White Dash", 1, 1, 1);
        Car c2 = new Car(2, "Volvo", "Black Night", 2, 2, 2);

        // проверим обе функции сравнения
        int acv11 = c1.compareToV(c1);
        int exv11 = 0;
        int acp22 = c2.compareToP(c2);
        int exp22 = 0;
        int acp12 = c1.compareToP(c2);
        int exp12 = 1;
        int acv21 = c2.compareToV(c1);
        int exv21 = -1;

        Assert.assertEquals(exv11, acv11);
        Assert.assertEquals(exp22, acp22);
        Assert.assertEquals(exp12, acp12);
        Assert.assertEquals(exv21, acv21);

        // проверим приведение к строке
        String exp1 = "Volvo White Dash";
        String act1 = c1.toString();
        String exp2 = "Volvo Black Night";
        String act2 = c2.toString();

        Assert.assertEquals(exp1, act1);
        Assert.assertEquals(exp2, act2);
    }
}