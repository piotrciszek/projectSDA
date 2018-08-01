package com.sda.finalproject.model;

import com.sda.finalproject.domain.BpmTask;
import com.sda.finalproject.manger.AddTaskManager;
import com.sda.finalproject.manger.StartTaskManager;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.renderers.ButtonRenderer;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringUI(path = "task-list")
public class TaskListGui extends UI{

    @Autowired
    private Menu menu;

    @Autowired
    private AddTaskManager addTaskManager;

    @Autowired
    private StartTaskManager startTaskManager;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addComponent(menu.getMenuBar());

        ListDataProvider<BpmTask> dataProvider = new ListDataProvider(addTaskManager.getTaskList());
        Grid<BpmTask> grid = new Grid<>();
        grid.setDataProvider(dataProvider);

        grid.addColumn(BpmTask::getId).setId("Id").setCaption("Id").setExpandRatio(1);
        grid.addColumn(BpmTask::getTitle).setId("Title").setCaption("Title").setExpandRatio(2);
        grid.addColumn(BpmTask::getDescription).setId("Description").setCaption("Description").setExpandRatio(3);
        grid.addColumn(BpmTask::getStartTime).setId("Start Time").setCaption("Start Time").setExpandRatio(3);
        grid.addColumn(BpmTask::isDone).setId("Is done?").setCaption("Is done?").setExpandRatio(2);


        //        grid.addColumn(BpmTask::getEmail).setId("Email").setCaption("Email");
//        grid.getEditor().isEnabled();

//        grid.getEditor().setBuffered(true);

        verticalLayout.addComponent(grid);

        Button addTaskButton = new Button("Dodaj zadanie");

        addTaskButton.addClickListener(event ->
                {
                    Page.getCurrent().open("add-task", null);
                    Notification.show("Dodaj zadanie", Notification.Type.TRAY_NOTIFICATION);
                }
        );

        verticalLayout.addComponent(addTaskButton);

        TextField taskId = new TextField();
        taskId.setValue("Enter task Id");
        Button editTaskButton = new Button("Zacznij zadanie");

        editTaskButton.addClickListener(event ->
                {
                    Optional<BpmTask> taskToDo = startTaskManager.getTaskById(Long.valueOf(taskId.getValue()));
                    taskToDo.get().setStartTime(LocalDateTime.now());
                    Page.getCurrent().open("/task-list", null);

                }
        );

        setContent(verticalLayout);



    }
}


