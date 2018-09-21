package com.hotelgo.config;

import com.hotelgo.extend.security.JwtAuthenticationFilter;
import com.hotelgo.extend.security.RestAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

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
        private JwtAuthenticationFilter jwtAuthenticationFilter;

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            PasswordEncoder encoder = new BCryptPasswordEncoder();
            auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
        }
        @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
        @Override
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
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

            http.addFilterAt(new AnonymousAuthenticationFilter("HotelGo_key") ,AnonymousAuthenticationFilter.class)
                    .addFilterAt(jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class)
                    .csrf().disable().authorizeRequests().antMatchers("/api/users/login", "/api/user/login", "/api/users/signup", "/login").permitAll()
                    .and()
                    .authorizeRequests().antMatchers("/api/**").authenticated()
//                    .hasAnyRole("REGISTERED_USER", "ADMIN")
                    .and()
                    .exceptionHandling()
                       .authenticationEntryPoint(restAuthenticationEntryPoint)
                    .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//                    .and().formLogin();
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
