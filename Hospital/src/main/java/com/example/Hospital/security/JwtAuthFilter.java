package com.example.Hospital.security;

import com.example.Hospital.entity.UserEntity;
import com.example.Hospital.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;
import java.util.Optional;

@Configuration
public class JwtAuthFilter extends OncePerRequestFilter {

    //slf4j for basic logging purpose
    private static final Logger logger = LoggerFactory.getLogger(JwtAuthFilter.class);
    private final UserRepository userRepository;
    private final AuthUtil authUtil;
    private final HandlerExceptionResolver handlerExceptionResolver;
    public JwtAuthFilter(UserRepository userRepository, AuthUtil authUtil, HandlerExceptionResolver handlerExceptionResolver)
    {
        this.userRepository = userRepository;
        this.authUtil = authUtil;
        this.handlerExceptionResolver = handlerExceptionResolver;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try
        {
            logger.info("Incoming request : {}", request.getRequestURI());
            final String requestTokenHeader = request.getHeader("Authorization");
            if(requestTokenHeader == null || !requestTokenHeader.startsWith("Bearer"))
            {
                filterChain.doFilter(request,response);
                return;
            }
            String token = requestTokenHeader.split("Bearer ")[1];
            String username = authUtil.getUsernameFromToken(token);

            if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
                UserEntity user = userRepository.findByUsername(username).orElseThrow();
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        user,null,user.getAuthorities()
                );

                //setting UsernamePasswordAuthenticationToken token to SecurityContextHolder
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
            filterChain.doFilter(request,response); //move forword in filterChain
        }
        catch(Exception ex)
        {
            handlerExceptionResolver.resolveException(request,response,null,ex);  //this will enable the GlobalExceptionHandler for filter as well.
        }

    }
}
