package com.example.learning.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by zhaoqicheng on 2017/11/15.
 * <p>
 * 通过@EnableWebSecurity注解开启Spring Security的功能
 * 继承WebSecurityConfigurerAdapter，并重写它的方法来设置一些web安全的细节
 * configure(HttpSecurity http)方法
 * 通过authorizeRequests()定义哪些URL需要被保护、哪些不需要被保护。例如以上代码指定了/和/home不需要任何认证就可以访问，其他的路径都必须通过身份验证。
 * 通过formLogin()定义当需要用户登录时候，转到的登录页面。
 * configureGlobal(AuthenticationManagerBuilder auth)方法，在内存中创建了一个用户，该用户的名称为user，密码为password，用户角色为USER。
 * <p>
 * <p>
 * <p>
 * 可以看到，实现了一个简单的通过用户名和密码提交到/login的登录方式。
 * <p>
 * 根据配置，Spring Security提供了一个过滤器来拦截请求并验证用户身份。
 * 如果用户身份认证失败，页面就重定向到/login?error，并且页面中会展现相应的错误信息。
 * 若用户想要注销登录，可以通过访问/login?logout请求，在完成注销之后，页面展现相应的成功消息。
 * <p>
 * 到这里，我们启用应用，并访问http://localhost:8080/，可以正常访问。
 * 但是访问http://localhost:8080/hello的时候被重定向到了http://localhost:8080/login页面，
 * 因为没有登录，用户没有访问权限，通过输入用户名user和密码password进行登录后，跳转到了Hello World页面，
 * 再也通过访问http://localhost:8080/login?logout，就可以完成注销操作
 *
 * http://www.importnew.com/20612.html
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }
}