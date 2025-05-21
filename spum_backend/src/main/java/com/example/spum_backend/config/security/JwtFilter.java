package com.example.spum_backend.config.security;


import com.example.spum_backend.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class JwtFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserDetailServiceApp userDetailsService;

    public JwtFilter(JwtService jwtService, UserDetailServiceApp userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if(request.getServletPath().contains("/auth")){
            filterChain.doFilter(request, response);
            return;
        }

        final String header = request.getHeader("Authorization");
        final String token;
        final String email;

        if(header==null || !header.contains("Bearer ")){
            filterChain.doFilter(request, response);
            return;
        }

        token = header.substring(7);
        email = jwtService.getUsernameFromToken(token);

        if(email!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails user = this.userDetailsService.loadUserByUsername(email);
            if(jwtService.isTokenValid(token, user)){
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        user,
                        null,
                        user.getAuthorities()
                );

                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);

            }
        }
        filterChain.doFilter(request,response);
    }
}
