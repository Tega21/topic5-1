package com.gcu.topic42.business;

import com.gcu.data.OrderDataService;
import com.gcu.data.entity.OrderEntity;
import com.gcu.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Business Service updated to use Spring Data JDBC
 * Now uses OrderDataService and converts between Entity and Model objects
 */
public class OrdersBusinessService implements OrdersBusinessServiceInterface{

    @Autowired
    private OrderDataService service;

    @Override
    public void test(){
        System.out.println("Hello from the OrdersBusinessService");
    }

    /**
     * Get orders from database and convert to domain models
     * This demonstrates proper separation of concerns:
     * - OrderEntity: Database/persistence layer
     * - OrderModel: Business/presentation layer
     */
    public List<OrderModel> getOrders() {
        // Get entities from data service
        List<OrderEntity> ordersEntity = service.findAll();

        // Create list for domain models
        List<OrderModel> ordersDomain = new ArrayList<>();

        // Convert OrderEntity objects to OrderModel objects
        // This prevents persistence technology dependencies from reaching the presentation layer
        for (OrderEntity entity : ordersEntity) {
            OrderModel model = new OrderModel(
                    entity.getId(),
                    entity.getOrderNo(),
                    entity.getProductName(),
                    entity.getPrice(),
                    entity.getQuantity()
            );
            ordersDomain.add(model);
        }

        return ordersDomain;
    }

    @Override
    public void init() {
        System.out.println("OrdersBusinessService: init() called");
    }

    @Override
    public void destroy() {
        System.out.println("OrdersBusinessService: destroy() called");
    }
}