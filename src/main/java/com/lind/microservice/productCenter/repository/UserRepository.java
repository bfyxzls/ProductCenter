package com.lind.microservice.productCenter.repository;

import com.lind.microservice.productCenter.model.UserInfo;
import java.util.List;

public interface UserRepository {

  List<UserInfo> fetchAllUsers();

  List<UserInfo> fetchAllUsers(String name);

  void modifyUserName(int id, String name);
}
