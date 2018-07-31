package com.sda.finalproject.model;

import com.sda.finalproject.domain.BpmTask;
import com.sda.finalproject.manger.AddTaskManager;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI(path = "task-list")
public class TaskListGui extends UI{

    @Autowired
    private AddTaskManager addTaskManager;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        VerticalLayout verticalLayout = new VerticalLayout();

        ListDataProvider<BpmTask> dataProvider = new ListDataProvider(addTaskManager.getTaskList());
        Grid<BpmTask> grid = new Grid<>();
        grid.setDataProvider(dataProvider);

        grid.addColumn(BpmTask::getId).setId("Id").setCaption("Id").setExpandRatio(1);
        grid.addColumn(BpmTask::getTitle).setId("Title").setCaption("Title").setExpandRatio(2);
        grid.addColumn(BpmTask::getDescription).setId("Description").setCaption("Description").setExpandRatio(3);
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

//        TextField taskId = new TextField();
//        taskId.setValue("Enter task Id");
//        Button editTaskButton = new Button("Zacznij zadanie");
//
//        addTaskButton.addClickListener(event ->
//                {
//                    Optional<BpmTask> taskbyId =
//                }
//        )

        setContent(verticalLayout);



    }
}


