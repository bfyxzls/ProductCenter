package com.lind.microservice.productCenter.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.lind.microservice.productCenter.model.UserInfo;
import com.lind.microservice.productCenter.repository.UserInfoRepository;
import com.lind.microservice.productCenter.repository.UserRepository;
import java.io.IOException;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  UserInfoRepository userInfoRepository;
  @Autowired
  ObjectMapper objectMapper;

  @Autowired
  private UserRepository userRepository;

  @RequestMapping(path = "all/{username}", method = RequestMethod.GET)
  public List<UserInfo> fetchUsers(@PathVariable String username) {
    List<UserInfo> userInfos = userRepository.fetchAllUsers(username);
    return userInfos;
  }

  @GetMapping()
  public String users() {
    throw new IllegalArgumentException();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public UserInfo find(@PathVariable int id) {
    UserInfo detail = userInfoRepository.findById(id).get();
    if (detail == null) {
      throw new IllegalArgumentException();
    } else {
      return detail;
    }
  }

  @RequestMapping(method = RequestMethod.POST)
  public UserInfo create(@RequestBody @Valid UserInfo detail) {
    return userInfoRepository.save(detail);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public HttpEntity update(@PathVariable int id, @RequestBody @Valid UserInfo productDetail)
      throws IOException {
    UserInfo existing = userInfoRepository.findById(id).get();
    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);
    String outJson = objectMapper.writeValueAsString(productDetail);
    ObjectReader objectReader = objectMapper.readerForUpdating(existing);
    objectReader.readValue(outJson);
    userInfoRepository.save(existing);
    return new ResponseEntity<>(existing, HttpStatus.ACCEPTED);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public HttpEntity delete(@PathVariable int id) {
    UserInfo userInfo = userInfoRepository.findById(id).get();
    userInfoRepository.delete(userInfo);
    return new ResponseEntity<>(HttpStatus.ACCEPTED);
  }
}
