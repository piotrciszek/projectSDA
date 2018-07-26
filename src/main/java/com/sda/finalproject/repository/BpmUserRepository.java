package com.sda.finalproject.repository;

import com.sda.finalproject.domain.BpmUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BpmUserRepository extends JpaRepository<BpmUser, Long> {
    int countByEmail(String email);

    Optional<BpmUser> findByEmail (String email);
}
