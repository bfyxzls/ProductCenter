package com.lind.microservice.productCenter.repository;

import com.lind.microservice.productCenter.model.ProductDetail;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailRepository extends
    CrudRepository<ProductDetail, String>,
    PagingAndSortingRepository<ProductDetail, String> {
  @Query("select p from ProductDetail p where UPPER(p.productName) like UPPER(?1) or " +
      "UPPER(p.longDescription) like UPPER(?1)")
  List search(String term);
}