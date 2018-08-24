package com.hotelgo.config;

import com.hotelgo.extend.security.RestAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Configuration
    @Order(1)
    public static class RestWebSecurityConfigureAdapter extends WebSecurityConfigurerAdapter {
        @Autowired
        private UserDetailsService userDetailsService;

        @Autowired
        private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            PasswordEncoder encoder = new BCryptPasswordEncoder();
            auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
        }

//            @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth)
//            throws Exception {
//        auth.inMemoryAuthentication().withUser("user1")
//                .password("{noop}password").roles("REGISTERED_USER");
//    }
//
//
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin();
//    }
//       @Autowired
//       public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//              auth.inMemoryAuthentication().withUser("user")
//               .password("{noop}password").roles("USER");
//       }


        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable().authorizeRequests().antMatchers("/api/users/login", "/api/user/login", "/api/users/signup", "/login").permitAll()
                    .and()
                    .authorizeRequests().antMatchers("/api/**").authenticated()
//                    .hasAnyRole("REGISTERED_USER", "ADMIN")
                    .and()
                    .exceptionHandling()
                       .authenticationEntryPoint(restAuthenticationEntryPoint)
//                    .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                    .and().formLogin();
        }

    }
//
//    @Configuration
//    public static class ResourcesWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
//        @Override
//        public void configure(WebSecurity web) throws Exception {
//            web.ignoring()
//                    .antMatchers("/resources/**","/swagger-ui.html","/webjars/**");
//             }
//    }

}
