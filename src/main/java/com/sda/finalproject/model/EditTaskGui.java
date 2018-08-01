package com.sda.finalproject.model;

import com.sda.finalproject.domain.BpmTask;
import com.sda.finalproject.domain.BpmUser;
import com.sda.finalproject.manger.EditTaskManager;
import com.sda.finalproject.manger.StartTaskManager;
import com.sda.finalproject.repository.BpmTaskRepository;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI(path = "/edit-task")
public class EditTaskGui extends UI{

    @Autowired
    private Menu menu;

    @Autowired
    private StartTaskManager startTaskManager;

    @Autowired
    private EditTaskManager editTaskManager;

    @Autowired
    private BpmTaskRepository bpmTaskRepository;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        String taskId = vaadinRequest.getParameter("taskId");
        BpmTask bpmTaskId = startTaskManager.getTaskById(Long.parseLong(taskId));

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addComponent(menu.getMenuBar());

        TextField titleField = new TextField();
        titleField.setValue(bpmTaskId.getTitle());
        titleField.setMaxLength(50);

        TextArea taskDescription = new TextArea();
        taskDescription.setValue(bpmTaskId.getDescription());
        taskDescription.setRows(10);

        Button confirmButton = new Button("Confirm changes");
        confirmButton.addClickListener(event->
                {
                    editTaskManager.editTask(Long.parseLong(taskId), titleField.getValue(), taskDescription.getValue());

                    Page.getCurrent().open("/task-list", null);
                    Notification.show("Task changed", Notification.Type.TRAY_NOTIFICATION);
                }
        );

        verticalLayout.addComponent(titleField);
        verticalLayout.addComponent(taskDescription);
        verticalLayout.addComponent(confirmButton);
        setContent(verticalLayout);


    }
}
