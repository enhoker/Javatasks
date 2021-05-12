package com.company;

//import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.*;

public class IndividualTest {

    @Test
    public void getAllIndividual() {

        //создаем тестовые данные
        Individual expected0 = new Individual();
        expected0.create("Евгений", "Колесников", 25);
        Individual expected1 = new Individual();
        expected1.create("Ann", "Dorn", 38);
        Individual expected2 = new Individual();
        expected2.create("Atahan", "Alchimbaev", 84);

        //создаем контрольные строки
        String actual0 = "Name Евгений \n Surname Колесников \n Age 25 \n";
        String actual1 = "Name Ann \n Surname Dorn \n Age 38 \n";
        String actual2 = "Name Atahan \n Surname Alchimbaev \n Age 84 \n";

        //запускаем тест
        Assert.assertEquals(expected0.display, actual0);
        Assert.assertEquals(expected1.display, actual1);
        Assert.assertEquals(expected2.display, actual2);

    }



    @After
    public void tearDown() throws Exception {
    }
}