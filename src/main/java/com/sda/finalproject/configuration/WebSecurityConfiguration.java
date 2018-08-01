package com.sda.finalproject.configuration;

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
                .antMatchers("/THEME", "/VAADIN/**", "/PUSH/**", "/UIDL/**", "/add-task", "/task-list", "/login", "/register", "/error/**", "/accessDenied/**", "/vaadinServlet/**").permitAll()
                .antMatchers("/user-list", "/user-data").hasRole("USER");


        http.logout().logoutUrl("/logout");
        http.csrf().disable();
        http.exceptionHandling().accessDeniedPage("/access-denied");
        http.authorizeRequests().anyRequest().permitAll();
        http.headers().frameOptions().disable();
    }


}
