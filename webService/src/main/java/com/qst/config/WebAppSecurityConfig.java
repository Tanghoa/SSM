package com.qst.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebAppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Bean
    public BCryptPasswordEncoder getbCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity security) throws Exception {

        JdbcTokenRepositoryImpl repository = new JdbcTokenRepositoryImpl();

        repository.setDataSource(dataSource);

        security
                .authorizeRequests()
                .antMatchers("/views/**", "/index.jsp")

                .permitAll()
                .antMatchers("/eee","/ds")
                .permitAll()

                .anyRequest()
                .authenticated()
                .and()
                .formLogin() //设置未授权请求跳转到登录页面：开启表单登 录功能
                .loginPage("/index.jsp") //指定登录页

                .permitAll() //为登录页设置所有人都可以访问
                .loginProcessingUrl("/do/login") // 指定提交登录表单的地址
                .defaultSuccessUrl("/main.html")
//
                .usernameParameter("loginAcct") // 定制登录账号的请求参数名
                .passwordParameter("userPswd") // 定制登录密码的请求参数名





                //取消csrf的传递验证
                .and()
                .csrf()
                .disable()
        ;





    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService)
                .passwordEncoder(bCryptPasswordEncoder);

    }
}
