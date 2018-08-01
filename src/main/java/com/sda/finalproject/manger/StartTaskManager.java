package com.sda.finalproject.manger;

import com.sda.finalproject.domain.BpmTask;
import com.sda.finalproject.repository.BpmTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StartTaskManager {

    @Autowired
    private BpmTaskRepository bpmTaskRepository;

    public Optional<BpmTask> getTaskById(Long id) {
        return bpmTaskRepository.findById(id);
    }

}
