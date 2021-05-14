package com.company;

public class Main {

    public static void main(String[] args) {
        TaxiAggregator citymobil = new TaxiAggregator();
        citymobil.createTaxis(1000);
        citymobil.getDispatcher().setAggregator(citymobil);
        citymobil.getDispatcher().start();
        for (Taxi taxi:citymobil.getAvailableTaxis()) {
            taxi.setAggregator(citymobil);
            taxi.start();
        }
    }
}
