package com.lind.microservice.productCenter.repository;

import com.lind.microservice.productCenter.model.OrderItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * 订单项个性化接口.
 */
@Repository
public interface OrderItemRepository extends
    CrudRepository<OrderItem, Integer>,
    PagingAndSortingRepository<OrderItem, Integer> {

}