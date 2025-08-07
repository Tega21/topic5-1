package com.gcu.data.repository;

import com.gcu.data.entity.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for Order entities
 * Extends CrudRepository to get automatic CRUD operations
 * Spring Data JDBC will automatically implement this interface
 */
@Repository
public interface OrdersRepository extends MongoRepository<OrderEntity, Long> {

    /**
     * Find an order by its ID
     * @param id the order ID
     * @return Optional containing the order if found
     */
    public Optional<OrderEntity> getOrderById(String id);
}