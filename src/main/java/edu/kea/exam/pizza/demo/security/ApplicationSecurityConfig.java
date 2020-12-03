package edu.kea.exam.pizza.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsServiceImpl userDetailsService;



    public ApplicationSecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public AuthenticationProvider authProvider() {
        /* Allows a Data Access Object-approach to authentication (very compatible with JPA)*/
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        /* The customized user details service is injected here.*/
        provider.setUserDetailsService(userDetailsService);
        /* password encoder allows BCrypt encrypted; persisted passwords are expected to be encrypted with BCrypt  */
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        /* a DAO Authentication provider, injected with customized service for user details is returned. */
        return provider;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.antMatcher("/**").authorizeRequests().
                antMatchers("/css/**", "/js/**", "/images/**").permitAll().
                antMatchers("/", "/card","/sign-up","/sign-up-now").permitAll(). // permits these controller calls for all
                anyRequest().authenticated(). // any other request needs authentication
                and().formLogin().
                loginPage("/login").permitAll(); // and will load the login-form
    }

}

/*
 * The why of @EnableWebSecurity:
 * https://stackoverflow.com/questions/44671457/what-is-the-use-of-enablewebsecurity-in-spring#44671785
 * */
