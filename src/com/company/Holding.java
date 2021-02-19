package com.company;

public class Holding extends Client{
    String name;
    int inn;
    int price;

    void Holding() {
        name = "NoName";
        inn = 0;
        price = -1;
    }

    void create(String n, int i, int p) {
        name = n;
        inn = i;
        price = p;
    }

    void display() {
        System.out.printf("Name %s \n INN %d \n Price %d \n", name, inn, price);
    }
}
