package com.sda.finalproject.repository;

import com.sda.finalproject.domain.BpmTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BpmTaskRepository extends JpaRepository<BpmTask, Long>{

    Optional<BpmTask> findById(Long id);

}
