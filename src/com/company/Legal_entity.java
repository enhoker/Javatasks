package com.company;

public class Legal_entity extends Client{
    String name;
    int inn;
    String country;

    void Legal_entity() {
        name = "noName";
        inn = 0;
        country = "NoCountry";
    }

    void create(String n, String c, int i) {
        name = n;
        inn = i;
        country = c;
    }

    void display() {
        System.out.printf("Name %s \n Country %s \n INN %d \n", name, country, inn);
    }
}

