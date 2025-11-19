package com.example.Hospital.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity

public class WebSecurityConfig {

    private final PasswordEncoder passwordEncoder;
    public WebSecurityConfig(PasswordEncoder passwordEncoder)
    {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration)throws Exception{
        return configuration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity.csrf(csrfConfig->csrfConfig.disable()) // disable csrf
                .sessionManagement(sessionConfig->sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) //disable session management
                        .authorizeHttpRequests(auth->auth
                        .requestMatchers("/hopital/**","/auth/**").permitAll()
                        .requestMatchers("/doctor/**").hasRole("USER")
                        .requestMatchers("/patient/**").hasAnyRole("ADMIN","USER"));
        //.formLogin(Customizer.withDefaults()); disable form
        return httpSecurity.build();
    }

    //for role based authorization we will use in memory user detail manager
    //@Bean  commenting this bean because we will use entity to retrive user details
    UserDetailsService userDetailsService()
    {
        UserDetails user1 = User.withUsername("rajeshwar")
                .password(passwordEncoder.encode("raZZ"))
                .roles("ADMIN")
                .build();

        UserDetails user2 = User.withUsername("dummy")
                .password(passwordEncoder.encode("pass"))
                .roles("USER")
                .build();

        UserDetails user3 = User.withUsername("dummy1")
                .password(passwordEncoder.encode("pass"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user1,user2,user3);
    }

}
