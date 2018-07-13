## spring boot 框架学习、整合各种常用工具包、了解配置、使用方法、工具类收集等：

#### 使用阿里的Druid数据库连接池

------------

##### 1.项目启动后访问配置管理页面的地址   
`http://localhost:8080/api/druid/index.html`

##### 2.配置过程
__`线程安全`__：`当多个线程访问同一个类时，无论出于何种环境，采用何种调度方式，或者多个线程将如何的调度执行，而代码中不需要额外的同步或者协同方式，这个类都可以表现出正常的行为得到预期相同的结果，那么就称这个类是线程安全的。`

__`线程安全主要变现在以下几个方面：`__
- __`a.添加pom.xml的druid的依赖`__：`提供了互斥访问，同一时刻只允许一个线程来对它进行操作`
- __`b.在application-dev.yml添加属性配置`__
- __`c.添加配置的java文件和过滤器文件`__：`DruidConfig、DruidStatFilter、DruidStatViewServlet`
- __`d.在启动类的主类上添加`__：`@ServletComponentScan(servlet 扫描，注册发现配置的页面的servlet)`
- __`e.另外使用Druid配置多数据源`__：`参考：https://www.bysocket.com/?p=1712`

#### 使用阿里的Druid数据库连接池

------------

__`使用springboot 推荐的发送http请求的RestTemplateConfig。：`__

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
我们在编写Web应用时，经常需要对页面做一些安全控制，比如：对于没有访问权限的用户需要转到登录表单页面。
要实现访问控制的方法多种多样，可以通过Aop、拦截器实现，也可以通过框架实现（如：Apache Shiro、Spring Security）。
https://docs.spring.io/spring-security/site/docs/4.1.0.RELEASE/reference/htmlsingle/

个人看法：
    本人没有使用Spring Security的经验，权限一般都采用自定义的filter完成，但是对于现在互联网架构前后端分离来看，
后端对安全控制，更多不在于页面资源，或者页面资源只是其中的一部分，更重要的是对接口资源安全控制，针对这一块，采用filter和JWT规范感觉是目前比较好的解决方式。

第八部分：
实现邮件发送：简单邮件、附件邮件、嵌入资源的邮件、模板邮件（完成）。

第九部分：
分布在其他项目中：
https://github.com/zhaoqicheng/springboot-dubbo-learning
Spring Boot中使用Dubbo进行服务治理
Spring Boot与Dubbo中管理服务依赖

第十部分：
分布在其他项目中：分布在其他项目中：
https://github.com/zhaoqicheng/springboot-dubbo-learning
Spring Boot中使用RabbitMQ

系列博文参考地址：
http://www.spring4all.com/

其他：
本项目解决跨域使用springboot的注解方式，以下有更多更有选择性的方式实现跨域：
http://www.spring4all.com/article/177
这篇文章对跨域的产生和原理详细解释：
http://www.ruanyifeng.com/blog/2016/04/cors.html
nginx实现跨域：
https://www.cnblogs.com/gabrielchen/p/5066120.html















