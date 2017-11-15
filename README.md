2017.11.7  4:00 pm start

spring boot 学习
整合目前各种流行框架以及各种工具类收集。
仅做示例项目，暂不拆分模块。

2017.11.7  7:00 pm end

第一部分：
使用阿里的Druid数据库连接池：

项目启动后访问配置管理页面的地址：
http://localhost:8080/api/druid/index.html

配置过程：
1.添加pom.xml的druid的依赖：
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <!--mysql数据库驱动-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.34</version>
        </dependency>
        <!--druid数据库连接池  优秀的连接池-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.0.18</version>
        </dependency>
        
2.在application-dev.yml添加属性配置：

3.添加配置的java文件和过滤器文件：
    DruidConfig、DruidStatFilter、DruidStatViewServlet
    
4.在启动类的主类上添加：
    @ServletComponentScan(servlet 扫描，注册发现配置的页面的servlet)

参考地址：
另外使用Druid配置多数据源：
https://www.bysocket.com/?p=1712


第二部分：
使用springboot 推荐的发送http请求的RestTemplateConfig。

第三部分：
使用JWT规范，处理用户登录信息，并按照JWT规范给用户颁发证书token（jwt）。
Spring Boot中使用Spring Security进行安全控制

第四部分：
整合redis。
redis 的分片式储存原理，分布式储存原理（未实现）。
知乎之分布式锁：
https://www.zhihu.com/question/21419897

第五部分：
Spring Boot中使用@Async实现异步调用。

第六部分：
使用AOP统一处理Web请求日志

第七部分：
使用Spring Security

第八部分：
实现邮件发送：简单邮件、附件邮件、嵌入资源的邮件、模板邮件（完成）。

第九部分：
Spring Boot中使用Dubbo进行服务治理
Spring Boot与Dubbo中管理服务依赖









