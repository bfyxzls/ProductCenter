package com.lind.microservice.productCenter.repository;

import com.lind.microservice.productCenter.dto.OrderList;
import com.lind.microservice.productCenter.model.OrderInfo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * 订单性化接口.
 */
@Repository
public interface OrderInfoRepository extends
    CrudRepository<OrderInfo, Integer>,
    PagingAndSortingRepository<OrderInfo, Integer> {
  @Query("select new com.lind.microservice.productCenter.dto.OrderList" +
      "( o.id,o.userId,o.userName,oi.productId,oi.productName,oi.count,oi.salePrice) " +
      " from OrderInfo o " +
      " join OrderItem oi on o.id=oi.orderId where o.userId=?1")
  List<OrderList> getOrderInfoByUser(int userId);

  @Query("select new com.lind.microservice.productCenter.dto.OrderList" +
      "( o.id,o.userId,o.userName,oi.productId,oi.productName,oi.count,oi.salePrice) " +
      " from OrderInfo o " +
      " join OrderItem oi on o.id=oi.orderId")
  List<OrderList> getOrderInfos();

}