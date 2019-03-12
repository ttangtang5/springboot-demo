package com.tang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Description spring security的配置
 * 1、设置Spring security对/和/"login"路径不拦截
 * 2、设置spring security的登录页面的访问的路径为/login
 * 3、登录成功后转向/chat路劲
 * 4、在内存中分别配置两个用户tang和zf, 密码和用户名一致，角色是USER
 * 5、/resources/static/目录下的静态资源，spring security不拦截
 * @Author RLY
 * @Date 2018/12/21 16:18
 * @Version 1.0
 **/
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/chat")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //可以设置内存指定的登录的账号密码,指定角色
        //不加.passwordEncoder(new MyPasswordEncoder())
        //就不是以明文的方式进行匹配，会报错
        //.passwordEncoder(new MyPasswordEncoder())。
        //这样，页面提交时候，密码以明文的方式进行匹配。
        auth
                .inMemoryAuthentication()
                .passwordEncoder(new MyPasswordEncoder())
                .withUser("tang").password("tang").roles("USER")
                .and()
                .passwordEncoder(new MyPasswordEncoder())
                .withUser("zf").password("zf").roles("USER");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/static/**");
    }
}
