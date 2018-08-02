package com.lind.microservice.productCenter.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lind.microservice.productCenter.dto.OrderList;
import com.lind.microservice.productCenter.model.OrderInfo;
import com.lind.microservice.productCenter.model.OrderItem;
import com.lind.microservice.productCenter.model.ProductDetail;
import com.lind.microservice.productCenter.model.UserInfo;
import com.lind.microservice.productCenter.repository.OrderInfoRepository;
import com.lind.microservice.productCenter.repository.OrderItemRepository;
import com.lind.microservice.productCenter.repository.ProductDetailRepository;
import com.lind.microservice.productCenter.repository.UserInfoRepository;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

    OrderInfo orderInfo = OrderInfo.builder()
        .orderTime(new Date())
        .shippingName("zzl")
        .total(99)
        .userId(userInfo.getId())
        .userName(userInfo.getUserName())
        .build();
    orderInfoRepository.save(orderInfo);

    OrderItem orderItem = OrderItem.builder()
        .orderId(orderInfo.getId())
        .count(1)
        .salePrice(99)
        .productId(productDetail.getId())
        .productName(productDetail.getProductName())
        .build();
    orderItemRepository.save(orderItem);
  }

  @GetMapping("{id}")
  public List<OrderList> getOrderList(@PathVariable int id) {
    return orderInfoRepository.getOrderInfoByUser(id);
  }

  @GetMapping()
  public List<OrderList> getOrderListAll() {
    return orderInfoRepository.getOrderInfos();
  }
}
