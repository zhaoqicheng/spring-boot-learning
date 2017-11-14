package com.example.learning.common.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by zhaoqicheng on 2017/4/24.
 *
 * 拦截器
 * 拦截方法防止用户未登录访问不可访问方法
 *
 * 实现AOP的切面主要有以下几个要素：

     使用@Aspect注解将一个java类定义为切面类
     使用@Pointcut定义一个切入点，可以是一个规则表达式，比如下例中某个package下的所有函数，也可以是一个注解等。
     根据需要在切入点不同位置的切入内容
     使用@Before在切入点开始处切入内容
     使用@After在切入点结尾处切入内容
     使用@AfterReturning在切入点return内容之后切入内容（可以用来对处理返回值做一些加工处理）
     使用@Around在切入点前后切入内容，并自己控制何时执行切入点自身的内容
     使用@AfterThrowing用来处理当切入内容部分抛出异常之后的处理逻辑
 */
@Aspect
@Component
public class HttpAspect {

//    @Autowired
//    private Audience audience;
//
//    @Autowired
//    private AccountService accountService;

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpAspect.class);

    // && !execution(public * cn.niuluotech.controller.UserController.doLogin(..))
//    @Pointcut("execution(public * cn.niuluotech.controller..*.*(..))&& !execution(public * cn.niuluotech.controller.UserController.doLogin(..))")
//    public void log(){
//    }
//
//    @Before("log()")
//    public void logBefore(JoinPoint joinPoint){
//
//        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = requestAttributes.getRequest();
//
//        /**
//         * 拦截器拦截非法token
//         */
//        String jwt_token = request.getHeader("jwt_token");
//        if(StringUtils.isBlank(jwt_token)){
//            throw new DentalClinicException(ResultEnum.ERROR_TOKEN);
//        }
//
//        /**
//         * 验证token是否合法，以及是否过期
//         */
//        //{id=2, userid=2E85C1202, unique_name=xrq, exp=1493179082, nbf=1493176490}
//        Claims claims = JwtHelperUtil.parseJWT(jwt_token, audience.getBase64Secret());
//        if(claims == null){
//            //token解析出错
//            throw new DentalClinicException(ResultEnum.ERROR_TOKEN);
//        }
//
//        //解析出token中的电话号码和登录角色以及过期时间
//        String phoneNumber = claims.get("phoneNumber").toString();
//        String accountType = claims.get("accountType").toString();
//
//        long exp = Long.valueOf(claims.get("exp").toString());
//        long now = new Date().getTime();
//        if( exp < now/1000 ){
//            throw new DentalClinicException(ResultEnum.ERROR_TOKEN_EXPIRE);
//        }
//        //逻辑判断登录用户合法
//        if(StringUtils.isNotBlank(accountType) && accountType.equals(AccountTypeEnum.TenantAccount.getAccountType())){
//            Tenant tenant = this.accountService.findTenantByMobile(phoneNumber);
//            if(tenant != null){
//                throw new DentalClinicException(ResultEnum.ERROR_DELECTTENANT);
//            }
//            LOGGER.info("合法的医院用户");
//        }else if(StringUtils.isNotBlank(accountType) && accountType.equals(AccountTypeEnum.UserAccount.getAccountType())){
//            User user = this.accountService.findUserByMobile(phoneNumber);
//            if(user == null){
//                throw new DentalClinicException(ResultEnum.ERROR_DELECTUSER);
//            }
//            LOGGER.info("合法的普通用户");
//        }else {
//            throw new DentalClinicException(ResultEnum.ERROR_TOKEN);
//        }
//        LOGGER.info("请求参数列表:"+joinPoint.getArgs());
//        LOGGER.info("远程主机地址:"+request.getRemoteHost());
//        LOGGER.info("远程请求方法:"+request.getMethod());
//        LOGGER.info("远程请求URL:"+request.getRequestURI());
//    }
}
