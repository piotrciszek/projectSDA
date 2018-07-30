package com.sda.finalproject.configuration;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package com.wordpress.kuylim.springbootvaadin.configuration;

import com.sda.finalproject.services.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

/**
 *
 * @author KUYLIM
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(customUserDetailService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/THEME", "/VAADIN/**", "/PUSH/**", "/UIDL/**", "/login", "/error/**", "/accessDenied/**", "/vaadinServlet/**").permitAll()
                .antMatchers("/user-data").hasRole("USER")
                .antMatchers("/register").permitAll();

        http.logout().logoutUrl("/logout");
        http.csrf().disable();
        http.exceptionHandling().accessDeniedPage("/access-denied");
        http.authorizeRequests().anyRequest().permitAll();
    }


}
