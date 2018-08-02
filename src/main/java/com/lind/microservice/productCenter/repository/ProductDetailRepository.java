package com.lind.microservice.productCenter.repository;

import com.lind.microservice.productCenter.model.ProductDetail;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * 产品个性化接口.
 */
@Repository
public interface ProductDetailRepository extends
    CrudRepository<ProductDetail, Integer>,
    PagingAndSortingRepository<ProductDetail, Integer> {
  @Query("select p from ProductDetail p where UPPER(p.productName) like UPPER(?1)")
  List search(String term);

  @Transactional
  @Modifying
  @Query("UPDATE ProductDetail p SET p.shortDescription = ?2 WHERE p.id = ?1")
  void updateDescrption(int id, String description);

}