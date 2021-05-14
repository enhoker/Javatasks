package com.company;

import java.util.concurrent.LinkedBlockingDeque;

public class TaxiAggregator{
    private LinkedBlockingDeque<Taxi> availableTaxis = new LinkedBlockingDeque<>(1000);
    private   Dispatcher dispatcher = new  Dispatcher();

    public Dispatcher getDispatcher() {
        return dispatcher;
    }

    public LinkedBlockingDeque<Taxi> getAvailableTaxis() {
        return availableTaxis;
    }

    public void createTaxis(int n) {
        int taxiNumber = 0;
        if(n >= 1000) {
            System.out.println("Not enough cars /n");
            return;
        }
            for ( taxiNumber= 0; taxiNumber < n; taxiNumber++) {
                Taxi taxi = new Taxi();
                availableTaxis.add(taxi);
            }
        }

    public Order getOrder() {
        Order order = new Order();
        return order;
    }
}
