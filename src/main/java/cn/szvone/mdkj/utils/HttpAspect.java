package cn.szvone.mdkj.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {
    private final  static org.slf4j.Logger logger= org.slf4j.LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * cn.szvone.mdkj.controller.HwController.*(..))")
    public void log(){}
    /**
     * @Before 在方法执行之前执行
     * */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        System.out.println("\r\n\r\ndoBefore");
        //记录http请求
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //从request中获取http请求的url/请求的方法类型／响应该http请求的类方法／IP地址／请求中的参数
        //url

        logger.info("url={}",request.getRequestURI());

        //method
        logger.info("method={}",request.getMethod());

        //ip
        logger.info("ip={}",request.getRemoteAddr());

        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+
                "."+joinPoint.getSignature().getName());

        //参数

        for (int i = 0; i < joinPoint.getArgs().length; i++) {
            logger.info("arg={}",joinPoint.getArgs()[i]);
        }
    }
    /**
     * @After在方法执行之后执行
     * */
    @After("log()")
    public void doAfter(){
        System.out.println("doAfter\r\n\r\n");
    }
}