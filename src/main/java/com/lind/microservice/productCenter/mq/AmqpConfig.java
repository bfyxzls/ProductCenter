package com.lind.microservice.productCenter.mq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * amqp配置.
 */
@Configuration
public class AmqpConfig {

  /**
   * 交换机.
   */
  public final static String EXCHANGE = "crm";
  /**
   * hello队列.
   */
  public final static String HELLO = "crm.hello.init";
  /**
   * 建立订单队列.
   */
  public final static String LIND_GENERATE_ORDER = "crm.order.generate";


  /**
   * 绑定exchange & queue & routekey.
   *
   * @param queueMessage 队列
   * @param exchange     交换机
   * @param routekey     路由
   * @return
   */
  public Binding bindingExchange(Queue queueMessage, TopicExchange exchange, String routekey) {
    return BindingBuilder.bind(queueMessage).to(exchange).with(routekey);
  }

  /**
   * 自动绑定hello规则.
   *
   * @return
   */
  @Bean
  public Binding bindOrder() {
    return bindingExchange(
        orderQueue(),
        crmExchange(),
        "crm.order.*"
    );
  }

  /**
   * 自动绑定order规则.
   *
   * @return
   */
  @Bean
  public Binding bindHello() {
    return bindingExchange(
        helloQueue(),
        crmExchange(),
        "crm.hello.#"
    );
  }

  /**
   * rabbitMq里初始化exchange.
   *
   * @return
   */
  @Bean
  public TopicExchange crmExchange() {
    return new TopicExchange(EXCHANGE);
  }

  /**
   * rabbitMq里初始化队列crm.hello.
   *
   * @return
   */
  @Bean
  public Queue helloQueue() {
    return new Queue(HELLO);
  }

  /**
   * rabbitMq里初始化队列crm.generate.order.
   *
   * @return
   */
  @Bean
  public Queue orderQueue() {
    return new Queue(LIND_GENERATE_ORDER);
  }

}
