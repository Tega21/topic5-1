package com.gcu.topic51.business;

import java.util.List;

import com.gcu.model.OrderList;
import com.gcu.model.OrderModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class OrdersRestService {

    @Autowired
    private OrdersBusinessServiceInterface service;

    @GetMapping(path = "/getjson", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderModel> getOrdersAsJson() {
        return service.getOrders();
    }

    @GetMapping(path = "/getxml", produces = MediaType.APPLICATION_XML_VALUE)
    public OrderList getOrdersAsXml() {
        return new OrderList(service.getOrders());
    }
}

