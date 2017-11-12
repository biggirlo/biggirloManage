package com.biggirlo.base.aop;


import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 日志配置aop
 *
 * @author wangyanxin
 * @create 2017/10/18 11:46
 */
@Aspect//描述一个切面类，定义切面类的时候需要打上这个注解
@Component
public class ControllerAop {
    Logger logg= Logger.getLogger(ControllerAop.class);
    @Pointcut("execution(* com.biggirlo.system.controller.*.*(..))")
    public void qieru(){
    }
   @Around("qieru()")
    public Object aroundInit(ProceedingJoinPoint poin) throws Throwable {
       Object args = poin.getArgs();
       Signature signature = poin.getSignature();
       //打印请求url
       HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
       logg.info(signature.getDeclaringType() + "." +signature.getName() + ":" +request.getRequestURL().toString());
       //获取返回参数
        Object vrt = poin.proceed();
        return vrt;
    }

    /*@Before("qieru()")
    public void qianzhi(){
        logg.info("前置通知");
    }*/
    /*@After("qieru()")
    public void houzhi(){
        System.out.println("后置通知");
    }

    @AfterReturning(returning="rvt",pointcut ="qieru()")
    public void qianzhifanhui( Object rvt){
        System.out.println("后置返回 :" + rvt);
    }*/

    /*@AfterThrowing("qieru()")
    public void qianzhiYichang(){
        System.out.println("后置异常");
    }*/

}
