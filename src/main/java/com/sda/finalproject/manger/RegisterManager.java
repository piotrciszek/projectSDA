package com.sda.finalproject.manger;

import com.sda.finalproject.domain.BpmUser;
import com.sda.finalproject.repository.BpmUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RegisterManager {

    @Autowired
    private BpmUserRepository bpmUserRepository;


    public Long registerPerson(String email, String password, String password_confirm) {
        if (!email.isEmpty() && !password.isEmpty() && !password_confirm.isEmpty()) {
            if (password.equals(password_confirm)) {
                Optional<BpmUser> userByEmail = bpmUserRepository.findByEmail(email);
                if (!userByEmail.isPresent()) {
                    BpmUser bpmUser = new BpmUser();
                    bpmUser.setEmail(email);
                    bpmUser.setPassword(password);
                    BpmUser savePerson = bpmUserRepository.save(bpmUser);
                    return savePerson.getId();
                }

            }
        }
        return -1L;
    }


    public BpmUser getPersonById(Long id) {
//        return bpmUserRepository.getOne(id);
        return bpmUserRepository.findById(id).get();
    }

//    public Optional<BpmUser> unregisterUser(BpmUser bpmUser) {
//        bpmUser.setEmail(bpmUser.getEmail().toLowerCase());
//
//        if (!bpmUser.getEmail().isEmpty()) {
//
//            Optional<BpmUser> searchedUser = bpmUserRepository.findByEmail(bpmUser.getEmail());
//            if (searchedUser.isPresent()) {
//                BpmUser deleteUser = searchedUser.get();
//
//                if (deleteUser.getEmail().equals(bpmUser.getEmail())
//                        && deleteUser.getPassword().equals(bpmUser.getPassword())
//                        && deleteUser.getPassword_confirm().equals(bpmUser.getPassword_confirm())) {
//
//                    bpmUserRepository.delete(deleteUser);
//
//                    return Optional.of(deleteUser);
//                }
//            }
//        }
//        return Optional.empty();
//    }

    public List<BpmUser> getBpmUserList() {
        return bpmUserRepository.findAll();

    }

}
