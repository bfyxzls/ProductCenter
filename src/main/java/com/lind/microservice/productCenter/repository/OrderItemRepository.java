package com.lind.microservice.productCenter.repository;

import com.lind.microservice.productCenter.model.OrderItem;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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
  List<OrderItem> findByOrderId(int orderId);

  @Transactional
  @Modifying
  @Query("delete from OrderItem where orderId = ?1")
  void delOrderItems(int orderId);
}