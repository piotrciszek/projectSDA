package com.sda.finalproject.services;

import com.sda.finalproject.domain.BpmUser;
import com.sda.finalproject.manger.LoginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("CustomUserDetailService")
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private LoginManager loginManager;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return loginManager.getPersonByEmail(username).get();
    }
}
