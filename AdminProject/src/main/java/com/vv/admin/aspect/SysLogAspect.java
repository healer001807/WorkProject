package com.vv.admin.aspect;

import com.vv.admin.listener.EventPubListener;
import com.vv.admin.log.Log;
import com.vv.admin.pojo.dto.SysLogDTO;
import com.vv.admin.utils.IpUtils;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDateTime;
import java.util.logging.Logger;

/**
 * @author kw
 * @program WorkProject
 * @description 日志切面
 * @create 2023 - 06 - 27 22:47
 **/
@Aspect
@Component
public class SysLogAspect {

    @Resource
    private EventPubListener eventPubListener;

    @Pointcut("@annotation(com.vv.admin.log.Log)")
    public void sysLog() {
    }

    @After("sysLog()")
    public void doAfter(JoinPoint joinPoint) {
        Log log = ((MethodSignature) joinPoint.getSignature()).getMethod().getAnnotation(Log.class);
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        System.out.println(request.toString());
        SysLogDTO sysLogDTO = new SysLogDTO();
        sysLogDTO.setBusinessType(log.businessType().getCode());
        sysLogDTO.setTitle(log.title());
        sysLogDTO.setRequestMethod(request.getMethod());
        sysLogDTO.setOperatorIp(IpUtils.getIpAddr(request));
        sysLogDTO.setOperatorUrl(request.getRequestURI());
        sysLogDTO.setOperatorName("从token中获取");
        sysLogDTO.setOperatorTime(LocalDateTime.now());

        eventPubListener.pushListener(sysLogDTO);


    }
}
