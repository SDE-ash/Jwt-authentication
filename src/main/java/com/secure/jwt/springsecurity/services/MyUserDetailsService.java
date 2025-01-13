package com.secure.jwt.springsecurity.services;

import com.secure.jwt.springsecurity.entity.User;
import com.secure.jwt.springsecurity.entity.UserPrincipal;
import com.secure.jwt.springsecurity.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userOpt = userRepo.findByUsername(username);

        if(!userOpt.isPresent()){
            throw  new UsernameNotFoundException("not found");
        }
        User user = userOpt.get();
        return new UserPrincipal(user);
    }
}
