package com.company;

public class Taxi extends Thread implements Runnable {
    private static int numbersTaxis = 0;
    private int taxiId;
    private StatusOrder status;
    private TaxiAggregator aggregator;

    public void setAggregator(TaxiAggregator taxiAggregator) {
        aggregator = taxiAggregator;
    }

    TaxiAggregator getAggregator() {
        return aggregator;
    }

    int getTaxiId() {
        return taxiId;
    }

    Taxi() {
        status = StatusOrder.Available;
        taxiId = numbersTaxis;
        numbersTaxis++;
    }

    public void makeBusy() {
        status = StatusOrder.Busy;
    }

    private void completeOrder() {
        long WorkTime = (long) (Math.random()*2 + 2);
        try {
            sleep(WorkTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (status == StatusOrder.Busy) {
                    completeOrder();
                    status = StatusOrder.Available;
                    synchronized (aggregator.getAvailableTaxis()) {
                        aggregator.getAvailableTaxis().add(this);
                        System.out.printf("Taxi # %d finished\n", taxiId);
                    }
                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    void placeOrder(Order order) {
    }
}
