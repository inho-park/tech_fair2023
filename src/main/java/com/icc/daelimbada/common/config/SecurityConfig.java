package com.icc.daelimbada.common.config;

import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .cors().disable()
//                .authorizeRequests(authorize -> authorize
//                        .antMatchers("/css/**","/index", "/images/**", "/js/**").permitAll()
//                        .antMatchers("/user/myPage", "/user/addProduct").hasRole("USER")
//                        .anyRequest().permitAll()
//                )
//                .formLogin()
//                .loginPage("/user/login")
//                .loginProcessingUrl("/article/list");
//    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**");
        web.ignoring().antMatchers("/scripts/**");
        web.ignoring().antMatchers("/images/**");
        web.ignoring().antMatchers("/static/clients/**");
    }
}
