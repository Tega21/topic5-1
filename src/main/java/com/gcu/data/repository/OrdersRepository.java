package com.gcu.data.repository;

import com.gcu.data.entity.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Order entities
 * Extends CrudRepository to get automatic CRUD operations
 * Spring Data JDBC will automatically implement this interface
 */
@Repository
public interface OrdersRepository extends MongoRepository<OrderEntity, Long> {}