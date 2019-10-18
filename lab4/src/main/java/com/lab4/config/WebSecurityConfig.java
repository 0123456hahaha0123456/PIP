package com.lab4.config;

import com.lab4.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
          auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username, password,enabled  from user_entity where username=?")
                .authoritiesByUsernameQuery("select username,role from user_entity where username=?");
    }

    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/","/username","/login","/test_register","/register","/auth/**","/point","/point/**","/js/**","/css/**").permitAll()
                    //.antMatchers("/username").hasRole("USER")
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .loginProcessingUrl("/doLogin")
                    .defaultSuccessUrl("/main")
                    .failureUrl("/login?error")
                    .and()
                .logout()
                    .logoutSuccessUrl("/login")
                    .and()
                .exceptionHandling()
                    .accessDeniedPage("/403");
    }
}
