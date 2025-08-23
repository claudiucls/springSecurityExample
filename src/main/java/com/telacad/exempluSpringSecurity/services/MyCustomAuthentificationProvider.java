package com.telacad.exempluSpringSecurity.services;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyCustomAuthentificationProvider implements AuthenticationProvider {

    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;


    public MyCustomAuthentificationProvider(PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        final String username = authentication.getName();
        final String password = authentication.getCredentials().toString();

        // verify if username is in DB
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        // if username exists then verify if password is correct
        if(passwordEncoder.matches(password, userDetails.getPassword())){
            // Best practice: return the full UserDetails object as the principal
            // and clear the credentials after successful authentication.
            return new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities()
            );
        }

        throw new BadCredentialsException("Invalid credentials for this user");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }
}
