package com.lind.microservice.productCenter.controller;

import com.lind.microservice.productCenter.repository.ProductDetailRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class ProductDetailSearchController {
  private final ProductDetailRepository repository;

  @Autowired
  public ProductDetailSearchController(ProductDetailRepository repository) {
    this.repository = repository;
  }

  @RequestMapping(method = RequestMethod.GET)
  public List search(@RequestParam("q") String queryTerm) {
    List productDetails = repository.search("%" + queryTerm + "%");
    return productDetails == null ? new ArrayList<>() : productDetails;
  }

  @PutMapping("{id}")
  public HttpEntity search(@PathVariable int id, @RequestParam("q") String des) {
    repository.updateDescrption(id, des);
    return new ResponseEntity<>(HttpStatus.ACCEPTED);

  }
}