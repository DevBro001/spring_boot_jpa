package uz.pdp.SpringDataJpaTest.config;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import uz.pdp.SpringDataJpaTest.service.CustomUserDetailsService;
import uz.pdp.SpringDataJpaTest.utils.JwtUtil;

import java.io.IOException;


@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final CustomUserDetailsService customUserDetailsService;

    public JwtRequestFilter(JwtUtil jwtUtil, CustomUserDetailsService customUserDetailsService) {
        this.jwtUtil = jwtUtil;
        this.customUserDetailsService = customUserDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authorization = request.getHeader("Authorization");// tokenWithPrefix Bearer vbqleurfbya;rifbliqwuyrf

        if (authorization!=null&&authorization.startsWith("Bearer ")){
            String token = authorization.substring(7);
            try {
                String subject = jwtUtil.getSubject(token);
                UserDetails userDetails = customUserDetailsService.loadUserByUsername(subject);

                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails.getUsername(),null,userDetails.getAuthorities());
                WebAuthenticationDetails webAuthenticationDetails = new WebAuthenticationDetails(request);
                authenticationToken.setDetails(webAuthenticationDetails);
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }catch (ExpiredJwtException e){
                response.sendError(404,"expired");
                return;
            }catch (Exception e){
                response.sendError(404,"salom");
                return;
            }
        }


        filterChain.doFilter(request,response);
    }
}
