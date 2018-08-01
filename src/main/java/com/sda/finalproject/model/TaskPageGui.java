package com.sda.finalproject.model;

import com.sda.finalproject.domain.BpmTask;
import com.sda.finalproject.manger.StartTaskManager;
import com.sda.finalproject.repository.BpmTaskRepository;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@SpringUI(path = "/task-page")
public class TaskPageGui extends UI{

    @Autowired
    private BpmTaskRepository bpmTaskRepository;

    @Autowired
    private StartTaskManager startTaskManager;

    @Autowired
    private Menu menu;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        String taskId = vaadinRequest.getParameter("taskId");
        BpmTask taskById = startTaskManager.getTaskById(Long.parseLong(taskId));

        VerticalLayout verticalLayout = new VerticalLayout();

        verticalLayout.addComponent(menu.getMenuBar());

        HorizontalLayout horizontalLayout = new HorizontalLayout();


        TextField titleField = new TextField();
        titleField.setCaption("Title");
        titleField.setValue(taskById.getTitle());
        titleField.setReadOnly(true);

        TextArea descriptionField = new TextArea();
        descriptionField.setValue(taskById.getDescription());
        descriptionField.setCaption("Description");
        descriptionField.setRows(10);
        descriptionField.setReadOnly(true);

        TextField commentField = new TextField();
        commentField.setPlaceholder("Add Comment");

        Button doneButton = new Button("Finish task");

        doneButton.addClickListener(event ->
                {
                    taskById.setEndTime(LocalDateTime.now());
                    taskById.setDone(true);
                    bpmTaskRepository.save(taskById);
                    Page.getCurrent().open("/task-list", null);
                }
        );

        horizontalLayout.addComponent(titleField);
        horizontalLayout.addComponent(descriptionField);
        horizontalLayout.addComponent(commentField);

        verticalLayout.addComponent(horizontalLayout);
        verticalLayout.addComponent(doneButton);
        setContent(verticalLayout);

    }
}
