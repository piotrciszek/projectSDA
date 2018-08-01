package com.sda.finalproject.model;

import com.sda.finalproject.domain.BpmTask;
import com.sda.finalproject.manger.StartTaskManager;
import com.sda.finalproject.repository.BpmTaskRepository;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI(path = "/task-page")
public class TaskPageGui extends UI{

    @Autowired
    private BpmTaskRepository bpmTaskRepository;

    @Autowired
    private StartTaskManager startTaskManager;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        String taskId = vaadinRequest.getParameter("taskId");
        BpmTask taskById = startTaskManager.getTaskById(Long.parseLong(taskId));


        VerticalLayout verticalLayout = new VerticalLayout();

        Label title = new Label();
//        title.setValue(bpmTaskRepository.findById(taskById));
        title.setContentMode(com.vaadin.shared.ui.ContentMode.HTML);
        setContent(title);


    }
}
