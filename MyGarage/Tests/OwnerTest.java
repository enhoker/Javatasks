package MyGarage.Tests;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class OwnerTest {

    @Test
    public void Test() {
        Owner o1 = new Owner(1, "Tom", "Cruise", 58);
        Owner o2 = new Owner(2, "Star", "Butterfly", 16);
        String exp1 = "Tom Cruise";
        String act1 = o1.toString();
        String exp2 = "Star Butterfly";
        String act2 = o2.toString();
        Assert.assertEquals(exp1, act1);
        Assert.assertEquals(exp2, act2);
    }
}
