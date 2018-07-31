package com.sda.finalproject.manger;

import com.sda.finalproject.domain.BpmTask;
import com.sda.finalproject.repository.BpmTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EditTaskManager {

    @Autowired
    private BpmTaskRepository bpmTaskRepository;

    public Long editTask(Long id, String title, String description ) {
        Optional<BpmTask> searchedTask = bpmTaskRepository.findById(id);

        if (searchedTask.isPresent()) {
            BpmTask task = searchedTask.get();
            task.setTitle(title);
            task.setDescription(description);
            BpmTask saveTask = bpmTaskRepository.save(task);
            return saveTask.getId();
        }
        return -1L;
    }


}
