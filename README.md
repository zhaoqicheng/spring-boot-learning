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

------------

#### 使用springboot 推荐的发送http请求的RestTemplateConfig。

------------

__`使用JWT规范，处理用户登录信息，并按照JWT规范给用户颁发证书token（jwt）。Spring Boot中使用Spring Security进行安全控制`__

------------

#### redis 的分片式储存原理，分布式储存原理（未实现）。
__`知乎之分布式锁：https://www.zhihu.com/question/21419897`__

------------

#### Spring Boot中使用@Async实现异步调用。

------------

#### 使用AOP统一处理Web请求日志

------------

#### 实现邮件发送：简单邮件、附件邮件、嵌入资源的邮件、模板邮件（完成）。

__`系列博文参考地址：http://www.spring4all.com/`__

------------

#### 其他：
__`本项目解决跨域使用springboot的注解方式，以下有更多更有选择性的方式实现跨域：   
http://www.spring4all.com/article/177    
这篇文章对跨域的产生和原理详细解释：   
http://www.ruanyifeng.com/blog/2016/04/cors.html   
nginx实现跨域：    
https://www.cnblogs.com/gabrielchen/p/5066120.html`__
















