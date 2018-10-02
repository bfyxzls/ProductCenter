package com.lind.microservice.productCenter.aspect;

import com.google.common.collect.Maps;
import java.util.Enumeration;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@Slf4j
@Aspect
@Configuration
public class LoggerAspect {

  private static final Logger LOGGER = LoggerFactory.getLogger(LoggerAspect.class);

  /**
   * 切面点
   */
  private final String POINT_CUT = "execution(* com.lind.microservice.productCenter.repository.*.*(..))";

  @Pointcut(POINT_CUT)
  private void pointcut() {
  }

  /**
   * 前置通知，方法调用前被调用
   * **注意：这里用到了JoinPoint和RequestContextHolder。
   * 1）、通过JoinPoint可以获得通知的签名信息，如目标方法名、目标方法参数信息等。
   * 2）、通过RequestContextHolder来获取请求信息，Session信息。**
   *
   * @param joinPoint
   */
  @Before(value = POINT_CUT)
  public void before(JoinPoint joinPoint) {
    log.info("前置通知");
    //获取目标方法的参数信息
    Object[] obj = joinPoint.getArgs();
    //AOP代理类的信息
    joinPoint.getThis();
    //代理的目标对象
    joinPoint.getTarget();
    //用的最多 通知的签名
    Signature signature = joinPoint.getSignature();
    //代理的是哪一个方法
    log.info("代理的是哪一个方法" + signature.getName());
    //AOP代理类的名字
    log.info("AOP代理类的名字" + signature.getDeclaringTypeName());
    //AOP代理类的类（class）信息
    signature.getDeclaringType();
    //获取RequestAttributes
    RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
    //从获取RequestAttributes中获取HttpServletRequest的信息
    HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
    //如果要获取Session信息的话，可以这样写：
    //HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
    //获取请求参数
    Enumeration<String> enumeration = request.getParameterNames();
    Map<String, String> parameterMap = Maps.newHashMap();
    while (enumeration.hasMoreElements()) {
      String parameter = enumeration.nextElement();
      parameterMap.put(parameter, request.getParameter(parameter));
    }
    String str = parameterMap.toString();
    if (obj.length > 0) {
      log.info("请求的参数信息为：" + str);
    }
  }

  /**
   * 后置返回通知
   * 这里需要注意的是:
   * 如果参数中的第一个参数为JoinPoint，则第二个参数为返回值的信息
   * 如果参数中的第一个参数不为JoinPoint，则第一个参数为returning中对应的参数
   * returning：限定了只有目标方法返回值与通知方法相应参数类型时才能执行后置返回通知，否则不执行，
   * 对于returning对应的通知方法参数为Object类型将匹配任何目标返回值
   *
   * @param joinPoint
   * @param keys
   */
  @AfterReturning(value = POINT_CUT, returning = "keys")
  public void doAfterReturningAdvice1(JoinPoint joinPoint, Object keys) {
    log.info("第一个后置返回通知的返回值：" + keys);
  }

  @AfterReturning(value = POINT_CUT, returning = "keys", argNames = "keys")
  public void doAfterReturningAdvice2(String keys) {
    log.info("第二个后置返回通知的返回值：" + keys);
  }

  /**
   * 后置异常通知
   * 定义一个名字，该名字用于匹配通知实现方法的一个参数名，当目标方法抛出异常返回后，将把目标方法抛出的异常传给通知方法；
   * throwing:限定了只有目标方法抛出的异常与通知方法相应参数异常类型时才能执行后置异常通知，否则不执行，
   * 对于throwing对应的通知方法参数为Throwable类型将匹配任何异常。
   *
   * @param joinPoint
   * @param exception
   */
  @AfterThrowing(value = POINT_CUT, throwing = "exception")
  public void doAfterThrowingAdvice(JoinPoint joinPoint, Throwable exception) {
    //目标方法名：
    log.info(joinPoint.getSignature().getName());
    if (exception instanceof NullPointerException) {
      log.info("发生了空指针异常!!!!!");
    }
  }


  /**
   * 后置最终通知（目标方法只要执行完了就会执行后置通知方法）
   *
   * @param joinPoint
   */
  @After(value = POINT_CUT)
  public void doAfterAdvice(JoinPoint joinPoint) {
    log.info("后置最终通知执行了!!!!");
  }

  /**
   * 环绕通知：
   * 环绕通知非常强大，可以决定目标方法是否执行，什么时候执行，执行时是否需要替换方法参数，执行完毕是否需要替换返回值。
   * 环绕通知第一个参数必须是org.aspectj.lang.ProceedingJoinPoint类型
   */
  @Around(value = POINT_CUT)
  public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
    log.info("环绕通知的目标方法名：" + proceedingJoinPoint.getSignature().getName());
    try {
      Object obj = proceedingJoinPoint.proceed();
      return obj;
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    }
    return null;
  }
}