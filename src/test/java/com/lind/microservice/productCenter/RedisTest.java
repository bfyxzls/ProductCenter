package com.lind.microservice.productCenter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lind.microservice.productCenter.model.UserInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
  @Autowired
  ObjectMapper objectMapper;
  @Autowired
  private StringRedisTemplate stringRedisTemplate;
  @Autowired
  private RedisTemplate redisTemplate;
  private ValueOperations<String, String> stringStringValueOperations;

  @Test
  public void stringSetGet() {
    stringStringValueOperations.set("lind", "repositoryUncle");
    String redisValue = stringRedisTemplate.opsForValue().get("lind");
    Assert.assertEquals("repositoryUncle", redisValue);
  }

  @Test
  public void hashSet() throws Exception {
    redisTemplate.opsForHash().put("entity1", "userinfo",
        objectMapper.writeValueAsString(UserInfo.builder()
            .userName("zzl")
            .phone("13521972991")
            .build()));
  }
}
