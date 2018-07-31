package com.sda.finalproject.manger;

import com.sda.finalproject.domain.BpmTask;
import com.sda.finalproject.repository.BpmTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AddTaskManager {

    @Autowired
    private BpmTaskRepository bpmTaskRepository;

    public BpmTask addTask(String title, String description, LocalDateTime createTime) {
        BpmTask task = new BpmTask(title, description, createTime);
        bpmTaskRepository.save(task);
        return task;
    }

    public List<BpmTask> getTaskList() {
        return bpmTaskRepository.findAll();
    }

}
