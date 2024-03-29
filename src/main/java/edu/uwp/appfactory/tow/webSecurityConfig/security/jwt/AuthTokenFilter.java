package edu.uwp.appfactory.tow.webSecurityConfig.security.jwt;

import edu.uwp.appfactory.tow.webSecurityConfig.security.services.UserDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * class that filters an auth token
 */
@Component
public class AuthTokenFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    /**
     * applies a filter to a request
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            String jwt = parseJwt(request);
            if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
                String userId = jwtUtils.getUUIDFromJwtToken(jwt);

                UserDetails userDetails = userDetailsService.loadUserByUUID(UUID.fromString(userId));
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            logger.error("Cannot set user authentication: {}", e);
        }
        filterChain.doFilter(request, response);
    }

    /**
     * method that parses a JWT token from a user
     */
    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");
        //todo: fix JWT to be sent in bearer
        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7);
        } else if (StringUtils.hasText(headerAuth)) {
            return headerAuth;
        }
        return null;
    }
}
