package com.company;

//import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.*;

public class Legal_entiyTest {

    @Test
    public void getAllLegal_entity() {

        //создаем тестовые данные
        Legal_entiy expected0 = new Legal_entiy();
        expected0.create("Мирай", "Россия", 2599);
        Legal_entiy expected1 = new Legal_entiy();
        expected1.create("Sam", "USA", 3876);
        Legal_entiy expected2 = new Legal_entiy();
        expected2.create("Atahan", "Ukraina", 88884);

        //создаем контрольные строки
        String actual0 = "Name Мирай \n Country Россия \n INN 2599 \n";
        String actual1 = "Name Sam \n Country USA \n INN 3876 \n";
        String actual2 = "Name Atahan \n Country Ukraina \n INN 88884 \n";

        //запускаем тест
        Assert.assertEquals(expected0.display, actual0);
        Assert.assertEquals(expected1.display, actual1);
        Assert.assertEquals(expected2.display, actual2);

    }



    @After
    public void tearDown() throws Exception {
    }
}