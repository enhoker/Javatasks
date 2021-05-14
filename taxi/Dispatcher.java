package com.company;
import java.sql.Array;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class  Dispatcher extends Thread implements Runnable{
    private TaxiAggregator aggregator;

    public void setAggregator(TaxiAggregator taxiAggregator) {
        aggregator = taxiAggregator;
    }

    TaxiAggregator getAggregator() {
        return aggregator;
    }

    void placeOrder(Taxi taxi){ //отправить заказ первому свободному такси
            taxi.makeBusy();
            taxi.notify();
    }

    @Override
    public void run(){
        while (true) {
            Order order = aggregator.getOrder();
            Taxi executorTaxi = null;

                try {
                    executorTaxi = aggregator.getAvailableTaxis().take();
                } catch (InterruptedException ignore) {
                    ignore.printStackTrace();
                }

         synchronized (executorTaxi) {
             placeOrder(executorTaxi);
         }
            System.out.printf("Order # %d sent, free taxis %d\n",order.getOrderId(), aggregator.getAvailableTaxis().size());
        }
    }
}
