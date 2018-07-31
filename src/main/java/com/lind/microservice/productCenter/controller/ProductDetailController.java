package com.lind.microservice.productCenter.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lind.microservice.productCenter.model.ProductDetail;
import com.lind.microservice.productCenter.repository.ProductDetailRepository;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductDetailController {
  private final ProductDetailRepository repository;
  private final ObjectMapper objectMapper;

  @Autowired
  public ProductDetailController(ProductDetailRepository repository, ObjectMapper objectMapper) {
    this.repository = repository;
    this.objectMapper = objectMapper;
  }

  @GetMapping("init")
  public void Init() {
    ProductDetail detail = new ProductDetail();
    detail.setProductName("Dan's Book of Writing");
    detail.setShortDescription("A book about writing books.");
    detail.setLongDescription("In this book about writing books, Dan will show you how to write a book.");
    detail.setInventoryId("009178461");
    repository.save(detail);
    for (ProductDetail productDetail : repository.findAll()) {
      System.out.println(productDetail.getProductId());
    }
  }

  @RequestMapping(method = RequestMethod.POST)
  public ProductDetail create(@RequestBody ProductDetail detail) {
    return repository.save(detail);
  }

  @RequestMapping(method = RequestMethod.GET)
  public Iterable findAll(@RequestParam(value = "page", defaultValue = "0", required = false) int page,
                          @RequestParam(value = "count", defaultValue = "10", required = false) int count,
                          @RequestParam(value = "order", defaultValue = "ASC", required = false) Sort.Direction direction,
                          @RequestParam(value = "sort", defaultValue = "productName", required = false) String sortProperty) {
    Page result = repository.findAll(new PageRequest(page, count, new Sort(direction, sortProperty)));
    return result.getContent();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ProductDetail find(@PathVariable String id) {
    ProductDetail detail = repository.findById(id).get();
    if (detail == null) {
      throw new IllegalArgumentException();
    } else {
      return detail;
    }
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public HttpEntity update(@PathVariable String id, HttpServletRequest request) throws IOException {
    ProductDetail existing = find(id);
    ProductDetail updated = objectMapper.readerForUpdating(existing).readValue(request.getReader());
    MutablePropertyValues propertyValues = new MutablePropertyValues();
    propertyValues.add("productId", updated.getProductId());
    propertyValues.add("productName", updated.getProductName());
    propertyValues.add("shortDescription", updated.getShortDescription());
    propertyValues.add("longDescription", updated.getLongDescription());
    propertyValues.add("inventoryId", updated.getInventoryId());
    DataBinder binder = new DataBinder(updated);

    if (binder.getBindingResult().hasErrors()) {
      return new ResponseEntity<>(binder.getBindingResult().getAllErrors(), HttpStatus.BAD_REQUEST);
    } else {
      return new ResponseEntity<>(updated, HttpStatus.ACCEPTED);
    }
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public HttpEntity delete(@PathVariable String id) {
    ProductDetail detail = find(id);
    repository.delete(detail);
    return new ResponseEntity<>(HttpStatus.ACCEPTED);
  }

}
