package com.sda.finalproject.manger;

import com.sda.finalproject.domain.BpmUser;
import com.sda.finalproject.repository.BpmUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BpmLoginManager {


    private BpmUserRepository bpmUserRepository;

    public Long loginUser(String email, String password) {
        if (!email.isEmpty() && !password.isEmpty()) {

                Optional<BpmUser> userByEmail = bpmUserRepository.findByEmail(email);
                if (userByEmail.isPresent()) {
                    BpmUser bpmUser = new BpmUser();
                    bpmUser.setEmail(email);
                    bpmUser.setPassword(password);
                    BpmUser savePerson = bpmUserRepository.save(bpmUser);
                    return savePerson.getId();
                }

        }
        return -1L;
    }

}
