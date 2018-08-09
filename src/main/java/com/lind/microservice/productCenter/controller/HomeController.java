package com.lind.microservice.productCenter.controller;

import com.lind.microservice.productCenter.result.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {

  @RequestMapping(value = "index", method = RequestMethod.GET)
  public Response index(Model model) {
    Map<String, String> loginUserInfo = new HashMap<>();
    loginUserInfo.put("userName", "test");
    loginUserInfo.put("age", "35");
    model.addAttribute("loginUserInfo", loginUserInfo);
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
}

