package com.gcu.topic42;

import com.gcu.topic42.business.OrdersBusinessService;
import com.gcu.topic42.business.OrdersBusinessServiceInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean(name="ordersBusinessService", initMethod = "init", destroyMethod = "destroy")
    public OrdersBusinessServiceInterface getOrdersBusiness(){
        return new OrdersBusinessService();
    }

}
