package com.company;

public class Order {
    private static int numbersOrders = 0;
    private int orderId;
    Order() {
        numbersOrders = numbersOrders + 1;
        orderId = numbersOrders;
    }
    public int getOrderId() {
        return orderId;
    }
}
