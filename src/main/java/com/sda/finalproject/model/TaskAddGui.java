package com.sda.finalproject.model;


import com.sda.finalproject.manger.AddTaskManager;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@SpringUI(path = "/add-task")
public class TaskAddGui extends UI{

    @Autowired
    private AddTaskManager addTaskManager;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        HorizontalLayout addTaskLayout = new HorizontalLayout();

        addTaskLayout.addStyleName("outlined");
        addTaskLayout.setSpacing(true);
        addTaskLayout.setMargin(false);

        TextField taskTitle = new TextField();
        taskTitle.setPlaceholder("Enter task title");
        taskTitle.setMaxLength(50);

        TextArea taskDescription = new TextArea();
        taskDescription.setPlaceholder("Enter task description");
        taskDescription.setRows(10);

        Button addTaskButton = new Button("Add Task!");
        addTaskButton.addClickListener(event ->
        {
            addTaskManager.addTask(taskTitle.getValue(),
                    taskDescription.getValue(),
                    LocalDateTime.now());

            Page.getCurrent().open("/task-list", null);
            Notification.show("TaskAdded", Notification.Type.TRAY_NOTIFICATION);

        });

        addTaskLayout.addComponent(taskTitle);
        addTaskLayout.addComponent(taskDescription);
        addTaskLayout.addComponent(addTaskButton);

        setContent(addTaskLayout);

    }
}
