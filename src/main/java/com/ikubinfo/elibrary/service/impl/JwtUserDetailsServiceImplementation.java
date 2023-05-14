package com.ikubinfo.elibrary.service.impl;

import com.ikubinfo.elibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@Primary
public class JwtUserDetailsServiceImplementation implements UserDetailsService {

	private final UserRepository userRepository;

	@Autowired
	public JwtUserDetailsServiceImplementation(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository
				.findByEmail(username)
				.orElseThrow(
						() -> new UsernameNotFoundException(
								format("User with username - %s, not found", username)));

	}
}
