package com.lind.microservice.productCenter.aspect;

import com.lind.microservice.productCenter.model.UserInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SampleServiceAspect {

  private static final Logger LOGGER = LoggerFactory.getLogger(SampleServiceAspect.class);

  @Before("execution(* com.lind.microservice.productCenter.repository.UserRepository.modifyUserName (java.lang.String)) && args(name)")
  public void beforeSampleCreation(String sampleName) {

    LOGGER.info("A request was issued for a sample name: "+sampleName);
  }

  @Around("execution(* com.lind.microservice.productCenter.repository.UserRepository.modifyUserName (java.lang.String)) && args(name)")
  public Object aroundSampleCreation(ProceedingJoinPoint proceedingJoinPoint,String sampleName) throws Throwable {

    LOGGER.info("A request was issued for a sample name: "+sampleName);

    sampleName = sampleName+"!";

    UserInfo sample = (UserInfo) proceedingJoinPoint.proceed(new Object[] {sampleName});
    sample.setUserName(sample.getUserName().toUpperCase());

    return sample;
  }

}