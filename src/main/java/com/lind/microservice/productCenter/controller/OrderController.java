package com.lind.microservice.productCenter.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lind.microservice.productCenter.dto.OrderList;
import com.lind.microservice.productCenter.enums.OrderStatus;
import com.lind.microservice.productCenter.model.OrderInfo;
import com.lind.microservice.productCenter.model.OrderItem;
import com.lind.microservice.productCenter.model.ProductDetail;
import com.lind.microservice.productCenter.model.UserInfo;
import com.lind.microservice.productCenter.repository.OrderInfoRepository;
import com.lind.microservice.productCenter.repository.OrderItemRepository;
import com.lind.microservice.productCenter.repository.ProductDetailRepository;
import com.lind.microservice.productCenter.repository.UserInfoRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

  @Autowired
  ProductDetailRepository productDetailRepository;
  @Autowired
  UserInfoRepository userInfoRepository;
  @Autowired
  OrderInfoRepository orderInfoRepository;
  @Autowired
  OrderItemRepository orderItemRepository;
  @Autowired
  ObjectMapper objectMapper;

  /**
   * 模拟一个用户，下一个订单
   */
  @GetMapping("/init")
  public void init() {
    UserInfo userInfo = UserInfo.builder()
        .email("bfyxzls@sina.com")
        .gander(UserInfo.Gander.male)
        .userName("lind")
        .phone("1352197xxxx")
        .build();
    userInfoRepository.save(userInfo);

    ProductDetail productDetail = ProductDetail.builder()
        .inventory(11)
        .productName("足球")
        .longDescription("体育用品")
        .salePrice(99)
        .discount(100)
        .shortDescription("体育用品")
        .build();
    productDetailRepository.save(productDetail);

    ProductDetail productDetail2 = ProductDetail.builder()
        .inventory(11)
        .productName("篮球")
        .longDescription("体育用品")
        .salePrice(129)
        .discount(100)
        .shortDescription("体育用品")
        .build();
    productDetailRepository.save(productDetail);

    OrderInfo orderInfo = OrderInfo.builder()
        .orderTime(new Date())
        .shippingName("zzl")
        .total(99)
        .userId(userInfo.getId())
        .userName(userInfo.getUserName())
        .orderStatus(OrderStatus.RECEIVED)
        .build();
    orderInfoRepository.save(orderInfo);

    List<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(OrderItem.builder()
        .orderId(orderInfo.getId())
        .count(1)
        .salePrice(productDetail.getSalePrice())
        .productId(productDetail.getId())
        .productName(productDetail.getProductName())
        .build());
    orderItems.add(OrderItem.builder()
        .orderId(orderInfo.getId())
        .count(1)
        .salePrice(productDetail2.getSalePrice())
        .productId(productDetail2.getId())
        .productName(productDetail2.getProductName())
        .build());
    orderItemRepository.saveAll(orderItems);
  }

  @GetMapping("{id}")
  public List<OrderList> getOrderList(@PathVariable int id) {
    return orderInfoRepository.getOrderInfoByUser(id);
  }

  @GetMapping("{id}/items")
  public List<OrderItem> getOrderItem(@PathVariable int id) {
    return orderItemRepository.findByOrderId(id);
  }

  @GetMapping()
  public List<OrderList> getOrderListAll() {
    return orderInfoRepository.getOrderInfos();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity del(int id) {
    orderInfoRepository.delOrder(id);
    orderItemRepository.delOrderItems(id);
    return new ResponseEntity<>(HttpStatus.ACCEPTED);
  }

}
