package com.gcu.data;

import com.gcu.data.entity.OrderEntity;
import com.gcu.data.repository.OrdersRepository;
import com.gcu.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDataService implements DataAccessInterface<OrderModel> {

    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public List<OrderModel> findAll() {
        List<OrderEntity> ordersEntity = ordersRepository.findAll();
        List<OrderModel> ordersDomain = new ArrayList<>();

        // Convert OrderEntity to OrderModel
        for (OrderEntity entity : ordersEntity) {
            ordersDomain.add(new OrderModel(
                    entity.getId(),
                    entity.getOrderNo(),
                    entity.getProductName(),
                    entity.getPrice(),
                    entity.getQuantity()
            ));
        }

        return ordersDomain;
    }

    @Override
    public OrderModel findById(String id) {
        // For now, return null as specified in assignment
        return null;
    }

    @Override
    public boolean create(OrderModel order) {
        try {
            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setOrderNo(order.getOrderNo());
            orderEntity.setProductName(order.getProductName());
            orderEntity.setPrice(order.getPrice());
            orderEntity.setQuantity(order.getQuantity());

            ordersRepository.save(orderEntity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(OrderModel order) {
        // For now, return true as specified in assignment
        return true;
    }

    @Override
    public boolean delete(OrderModel order) {
        // For now, return true as specified in assignment
        return true;
    }
}