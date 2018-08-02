package com.lind.microservice.productCenter.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.lind.microservice.productCenter.model.ProductDetail;
import com.lind.microservice.productCenter.repository.ProductDetailRepository;
import java.io.IOException;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity Init() throws IOException {
    String requestData = "[\n" +
        "    {\n" +
        "        \"productId\": 0,\n" +
        "        \"productName\": \"毛衣机\",\n" +
        "        \"shortDescription\": \"毛衣机\",\n" +
        "        \"longDescription\": \"测试产品\",\n" +
        "        \"inventory\": 10,\n" +
        "    },\n" +
        "    {\n" +
        "        \"productId\": 0,\n" +
        "        \"productName\": \"电视\",\n" +
        "        \"shortDescription\": \"电视\",\n" +
        "        \"longDescription\": \"测试产品\",\n" +
        "        \"inventory\": 10,\n" +
        "    },\n" +
        "    {\n" +
        "        \"productId\": 0,\n" +
        "        \"productName\": \"电话\",\n" +
        "        \"shortDescription\": \"电话\",\n" +
        "        \"longDescription\": \"测试产品\",\n" +
        "        \"inventory\": 10,\n" +
        "    },\n" +
        "    {\n" +
        "        \"productId\": 0,\n" +
        "        \"productName\": \"test\",\n" +
        "        \"shortDescription\": \"测试产品\",\n" +
        "        \"longDescription\": \"测试产品\",\n" +
        "        \"inventory\": 10,\n" +
        "    },\n" +
        "    {\n" +
        "        \"productId\": 0,\n" +
        "        \"productName\": \"修改了123456\",\n" +
        "        \"shortDescription\": \"修改了测试产品123456\",\n" +
        "        \"longDescription\": \"修改了测试产品\",\n" +
        "        \"inventory\": 10,\n" +
        "    }\n" +
        "]";
    List<ProductDetail> list = objectMapper.readValue(requestData,
        new TypeReference<List<ProductDetail>>() {
        });
    repository.saveAll(list);
    for (ProductDetail productDetail : repository.findAll()) {
      System.out.println(productDetail.getProductId());
    }
    return new ResponseEntity<>(HttpStatus.ACCEPTED);

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
  public ProductDetail find(@PathVariable int id) {
    ProductDetail detail = repository.findById(id).get();
    if (detail == null) {
      throw new IllegalArgumentException();
    } else {
      return detail;
    }
  }

  @RequestMapping(method = RequestMethod.POST)
  public ProductDetail create(@RequestBody @Valid ProductDetail detail) {
    return repository.save(detail);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public HttpEntity update(@PathVariable int id, @RequestBody @Valid ProductDetail productDetail)
      throws IOException {
    ProductDetail existing = repository.findById(id).get();
    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);
    String outJson = objectMapper.writeValueAsString(productDetail);
    ObjectReader objectReader = objectMapper.readerForUpdating(existing);
    objectReader.readValue(outJson);
    repository.save(existing);
    return new ResponseEntity<>(existing, HttpStatus.ACCEPTED);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public HttpEntity delete(@PathVariable int id) {
    ProductDetail detail = find(id);
    repository.delete(detail);
    return new ResponseEntity<>(HttpStatus.ACCEPTED);
  }

}
