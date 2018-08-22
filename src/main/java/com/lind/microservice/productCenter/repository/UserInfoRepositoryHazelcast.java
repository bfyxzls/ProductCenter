package com.lind.microservice.productCenter.repository;

import com.lind.microservice.productCenter.model.UserInfo;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("hazelcast-cache")
public class UserInfoRepositoryHazelcast implements UserRepository {

  @Override
  @Cacheable(cacheNames = "usercache", key = "#root.methodName")
  public List<UserInfo> fetchAllUsers() {
    List<UserInfo> list = new ArrayList<>();
    list.add(UserInfo.builder().phone("135").userName("zzl1").createAt(LocalDateTime.now()).build());
    list.add(UserInfo.builder().phone("136").userName("zzl2").createAt(LocalDateTime.now()).build());
    return list;
  }

  @Override
  @Cacheable(cacheNames = "usercache", key = "{#name}")
  public List<UserInfo> fetchAllUsers(String name) {
    List<UserInfo> list = new ArrayList<>();
    list.add(UserInfo.builder().phone("135").userName("zzl1").createAt(LocalDateTime.now()).build());
    list.add(UserInfo.builder().phone("136").userName("zzl2").createAt(LocalDateTime.now()).build());
    return list;
  }

  @Override
  public void modifyUserName(int id, String name) {
    UserInfo userInfo = UserInfo.builder().id(id).userName(name).build();
  }
}
