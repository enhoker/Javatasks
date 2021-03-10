package com.company;

public class Individual implements Client{
    String name;
    int age;
    String surname;

    void create(String n, String s, int a) {
        age = a;
        name = n;
        surname = s;
    }

    void INDIVIDUAL() {
        age = 0;
        name = "NoName";
        surname = "NoName";
    }



    void display() {
        System.out.printf("Name %s \n Surname %s \n Age %d \n", name, surname, age);
    }
}