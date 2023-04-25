package com.ikubinfo.elibrary.configuration;

import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class CustomEventPublisher implements AuthenticationEventPublisher {
    @Override
    public void publishAuthenticationSuccess(Authentication authentication) {

        System.out.println("Authentication success" + authentication.getPrincipal());
    }

    @Override
    public void publishAuthenticationFailure(AuthenticationException exception, Authentication authentication) {

        System.out.println("Authentication failed" + authentication.getPrincipal());
    }
}
