package com.biggirlo.base.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 *
 */
@Aspect//描述一个切面类，定义切面类的时候需要打上这个注解
@Component
public class AuthRoleAop {
    Logger logg= Logger.getLogger(AuthRoleAop.class);
    @Pointcut("execution(* com.biggirlo.system.controller.*.*(..))")
    public void qieru(){
    }

    @Before("qieru()")
    public void qianzhi(){
        logg.info("前置通知");
    }
}
