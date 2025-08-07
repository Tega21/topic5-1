package com.gcu.topic51;

import com.gcu.topic51.business.OrdersBusinessService;
import com.gcu.topic51.business.OrdersBusinessServiceInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean(name="ordersBusinessService", initMethod = "init", destroyMethod = "destroy")
    public OrdersBusinessServiceInterface getOrdersBusiness(){
        return new OrdersBusinessService();
    }

}
