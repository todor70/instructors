package com.zeljko.instructors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class InstructorsSecurityConfig extends WebSecurityConfigurerAdapter {

    // add a reference to our security data source

    @Qualifier("dataSource")
    @Autowired
    private DataSource securityDataSource;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // use jdbc authentication

        auth.jdbcAuthentication().dataSource(securityDataSource);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("USER", "ADMIN")
                .antMatchers("/course/addCourse/").hasRole("ADMIN")
                .antMatchers("/course/saveCourse").hasRole("ADMIN")
                .antMatchers("/course/updateCourse").hasRole("ADMIN")
                .antMatchers("/course/deleteCourse/{id}").hasRole("ADMIN")
                .antMatchers("/course/editCourse/{id}").hasRole("ADMIN")
                .antMatchers("/course/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/instructor/addInstructor/").hasRole("ADMIN")
                .antMatchers("/instructor/saveInstructor").hasRole("ADMIN")
                .antMatchers("/instructor/updateInstructor/{id}").hasRole("ADMIN")
                .antMatchers("/instructor/deleteInstructor/{id}").hasRole("ADMIN")
                .antMatchers("/instructor/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/register/showRegistrationForm").hasRole("ADMIN")
                .antMatchers("/register/showDeleteForm").hasRole("ADMIN")
                .antMatchers("/register/processRegistrationForm").hasRole("ADMIN")
                .antMatchers("/register/processDeleteForm").hasRole("ADMIN")
                .antMatchers("/resources/**").permitAll()
                .and()
                .formLogin()
                .loginPage("/showMyLoginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access_denied");

    }

    @Bean
    public UserDetailsManager userDetailsManager() {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();

        jdbcUserDetailsManager.setDataSource(securityDataSource);

        return jdbcUserDetailsManager;
    }
}






