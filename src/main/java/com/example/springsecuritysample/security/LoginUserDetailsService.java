package com.example.springsecuritysample.security;

import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.springsecuritysample.entity.LoginUser;
import com.example.springsecuritysample.repository.LoginUserRepository;

@Service
public class LoginUserDetailsService implements UserDetailsService {
    private final LoginUserRepository loginUserRepository;

    public LoginUserDetailsService(LoginUserRepository loginUserRepository) {
        this.loginUserRepository = loginUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        Optional<LoginUser> optLoginuser = loginUserRepository.findByEmail(email);

        return optLoginuser.map(user -> new LoginUserDetails(user))
                .orElseThrow(() -> new UsernameNotFoundException("not found"));

    }
}