package com.lind.microservice.productCenter.controller;

import com.lind.microservice.productCenter.result.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
@RequestMapping("/")
public class HomeController {

  public static final String LOGIN_USER_INFO = "loginUserInfo";

  @RequestMapping(value = "index", method = RequestMethod.GET)
  public Response index(Model model) throws IOException {
    Map<String, String> loginUserInfo = new HashMap<>();
    loginUserInfo.put("userName", "test");
    loginUserInfo.put("age", "35");
    model.addAttribute(LOGIN_USER_INFO, loginUserInfo);
    List<Map<String, String>> peoples = new ArrayList<>();
    peoples.add(loginUserInfo);
    peoples.add(loginUserInfo);
    model.addAttribute("peoples", peoples);
    return new Response();
  }

  @GetMapping("product/create")
  public Response create() {
    return new Response();
  }

  @GetMapping("product/upload")
  public Response upload() {
    return new Response();
  }
}

