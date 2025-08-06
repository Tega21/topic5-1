package com.gcu.topic42.business;

import com.gcu.model.OrderModel;

import java.util.ArrayList;
import java.util.List;

public class AnotherOrdersBusinessService implements OrdersBusinessServiceInterface {

    @Override
    public void test(){
        System.out.println("Hello from AnotherOrdersBusinessService");
    }

    public List<OrderModel> getOrders() {
        List<OrderModel> orders = new ArrayList<>();

        orders.add(new OrderModel(1L, "001", "Eggs 60ct", 19.99f, 1));
        orders.add(new OrderModel(2L, "002", "Toilet Paper", 21.99f, 2));
        orders.add(new OrderModel(3L, "003", "Hot Sauce", 4.99f, 3));
        orders.add(new OrderModel(4L, "004", "Tortilla 7cy", 9.99f, 4));
        orders.add(new OrderModel(5L, "005", "Dog Food", 30.99f, 5));

        return orders;
    }

    @Override
    public void init() {
        System.out.println("AnotherOrdersBusinessService: init() called");
    }

    @Override
    public void destroy() {
        System.out.println("AnotherOrdersBusinessService: destroy() called");

    }

}
