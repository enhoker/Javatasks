package com.company;

//import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.*;

public class HoldingTest {

    @Test
    public void getAllHolding() {

        //создаем тестовые данные
        Holding expected0 = new Holding();
        expected0.create("Вкусвилл", 8867, 25000);
        Holding expected1 = new Holding();
        expected1.create("Danon", 7878, 380);
        Holding expected2 = new Holding();
        expected2.create("Google", 90001, 888805);

        //создаем контрольные строки
        String actual0 = "Name Вкусвилл \n INN 8867 \n Price 25000 \n";
        String actual1 = "Name Danon \n INN 7878 \n Price 380 \n";
        String actual2 = "Name Google \n INN 90001 \n Price 888805 \n";

        //запускаем тест
        Assert.assertEquals(expected0.display, actual0);
        Assert.assertEquals(expected1.display, actual1);
        Assert.assertEquals(expected2.display, actual2);

    }



    @After
    public void tearDown() throws Exception {
    }
}