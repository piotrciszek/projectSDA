package com.sda.finalproject.model;

import com.sda.finalproject.domain.BpmTask;
import com.sda.finalproject.domain.BpmUser;
import com.sda.finalproject.manger.AddTaskManager;
import com.sda.finalproject.manger.StartTaskManager;
import com.sda.finalproject.repository.BpmTaskRepository;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringUI(path = "task-list")
public class TaskListGui extends UI{

    @Autowired
    private AddTaskManager addTaskManager;

    @Autowired
    private Menu menu;


    @Autowired
    private BpmTaskRepository bpmTaskRepository;

    @Autowired
    private StartTaskManager startTaskManager;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        BpmUser bpmUser = (BpmUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        VerticalLayout verticalLayout = new VerticalLayout();



        verticalLayout.addComponent(menu.getMenuBar());

        Label label = new Label("Task to do");
        label.addStyleName(ValoTheme.LABEL_H1);

        verticalLayout.addComponent(label);


        ListDataProvider<BpmTask> dataProvider = new ListDataProvider(addTaskManager.getTaskList().stream().filter(element -> !element.isDone()).collect(Collectors.toList()));
        Grid<BpmTask> grid = new Grid<>();
        grid.setDataProvider(dataProvider);
        grid.setSizeFull();
        grid.addColumn(BpmTask::getId).setId("Id").setCaption("Id").setExpandRatio(1);
        grid.addColumn(BpmTask::getTitle).setId("Title").setCaption("Title").setExpandRatio(2);
        grid.addColumn(BpmTask::getDescription).setId("Description").setCaption("Description").setExpandRatio(3);
        grid.addColumn(BpmTask::getStartTime).setId("Start Time").setCaption("Start Time").setExpandRatio(3);
        grid.addColumn(BpmTask::getBpmUser).setId("Kto wykonuje zadanie").setCaption("User").setExpandRatio(2);
        grid.addColumn(BpmTask::isDone).setId("Is done?").setCaption("Is done?").setExpandRatio(2);


        verticalLayout.addComponent(grid);

        HorizontalLayout horizontalLayout = new HorizontalLayout();

        VerticalLayout verticalLayout2 = new VerticalLayout();

        TextField taskId2 = new TextField();
        taskId2.setPlaceholder("Enter task Id");

        Button editTaskButton = new Button("Edit task");
        editTaskButton.addClickListener(event ->
                {
                    Page.getCurrent().open("/edit-task?taskId=" + taskId2.getValue(), null);
                    Notification.show("Edit task", Notification.Type.TRAY_NOTIFICATION);
                }
        );
        verticalLayout2.addComponent(taskId2);
        verticalLayout2.addComponent(editTaskButton);

        horizontalLayout.addComponent(verticalLayout2);

        VerticalLayout verticalLayout3 = new VerticalLayout();
        TextField taskId = new TextField();
        taskId.setPlaceholder("Enter task Id");
        Button startTaskButton = new Button("Start task");

        startTaskButton.addClickListener(event ->
                {
                    BpmTask taskToDo = startTaskManager.getTaskById(Long.valueOf(taskId.getValue()));
                    taskToDo.setBpmUser(bpmUser);
                    taskToDo.setStartTime(LocalDateTime.now());
                    bpmTaskRepository.save(taskToDo);
                    Page.getCurrent().open("/task-page?taskId=" + taskId.getValue(), null);

                }
        );
        verticalLayout3.addComponent(taskId);
        verticalLayout3.addComponent(startTaskButton);

        horizontalLayout.addComponent(verticalLayout3);

        verticalLayout.addComponent(horizontalLayout);

        Button addTaskButton = new Button("Add task");

        addTaskButton.addClickListener(event ->
                {
                    Page.getCurrent().open("/add-task", null);
                    Notification.show("Add task", Notification.Type.TRAY_NOTIFICATION);
                }
        );

        verticalLayout.addComponent(addTaskButton);


        Label label2 = new Label("Task done");
        label2.addStyleName(ValoTheme.LABEL_H1);

        verticalLayout.addComponent(label2);

        ListDataProvider<BpmTask> dataProvider2 = new ListDataProvider(addTaskManager.getTaskList().stream().filter(element -> element.isDone()).collect(Collectors.toList()));
        Grid<BpmTask> grid2 = new Grid<>();
        grid2.setDataProvider(dataProvider2);
        grid2.setSizeFull();
        grid2.addColumn(BpmTask::getId).setId("Id").setCaption("Id").setExpandRatio(1);
        grid2.addColumn(BpmTask::getTitle).setId("Title").setCaption("Title").setExpandRatio(2);
        grid2.addColumn(BpmTask::getDescription).setId("Description").setCaption("Description").setExpandRatio(3);
//        grid2.addColumn(BpmTask::getStartTime).setId("Time").setCaption("Start Time").setExpandRatio(3);
        grid2.addColumn(BpmTask::getBpmUser).setId("User").setCaption("User").setExpandRatio(2);
        grid2.addColumn(BpmTask::isDone).setId("Is done?").setCaption("Is done?").setExpandRatio(2);

        verticalLayout.addComponent(grid2);

        setContent(verticalLayout);



    }


}


