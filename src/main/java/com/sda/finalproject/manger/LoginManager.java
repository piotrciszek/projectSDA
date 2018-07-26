package com.sda.finalproject.manger;

import com.sda.finalproject.domain.BpmUser;
import com.sda.finalproject.repository.BpmUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginManager {

    @Autowired
    private BpmUserRepository bpmUserRepository;

    public Optional<BpmUser> getPersonByEmail(String email){
        return bpmUserRepository.findByEmail(email);
    }




}
