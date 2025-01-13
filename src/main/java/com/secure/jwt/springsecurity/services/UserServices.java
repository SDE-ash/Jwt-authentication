package com.secure.jwt.springsecurity.services;

import com.secure.jwt.springsecurity.entity.User;
import com.secure.jwt.springsecurity.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<?> saveUser(User user){
        try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepo.save(user);
            return  new ResponseEntity<User>(user,HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println("Not save: "+e);
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    public String verify(User user){
        Authentication authentication =
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if(authentication.isAuthenticated()){
            return jwtService.generateToken(user);
        }


        return  "failure";
    }
}
