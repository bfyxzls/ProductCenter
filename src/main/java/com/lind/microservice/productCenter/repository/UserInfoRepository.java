package com.lind.microservice.productCenter.repository;

import com.lind.microservice.productCenter.model.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户个性化接口.
 */
@Repository
public interface UserInfoRepository extends
    CrudRepository<UserInfo, Integer>,
    PagingAndSortingRepository<UserInfo, Integer> {

}