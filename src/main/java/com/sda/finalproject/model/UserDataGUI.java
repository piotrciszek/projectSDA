package com.sda.finalproject.model;


import com.sda.finalproject.manger.BpmRegisterManager;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;


@SpringUI(path = "/user-data")
public class UserDataGUI extends UI {


    private BpmRegisterManager bpmRegisterManager;

    @Autowired
    public UserDataGUI(BpmRegisterManager bpmRegisterManager) {
        this.bpmRegisterManager = bpmRegisterManager;
    }

    private final MenuBar.Command menuCommand = selectedItem -> Notification.show("Action " + selectedItem.getText(), Notification.Type.TRAY_NOTIFICATION);

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        MenuBar menuBar = new MenuBar();
        menuBar.setWidth(100.0f, Unit.PERCENTAGE);


//        Long userId = Long.parseLong(vaadinRequest.getParameter("userId"));
//        BpmUser personById = bpmUserManager.getPersonById(userId);
//
//        VerticalLayout verticalLayout = new VerticalLayout();
//
//
//        Grid<BpmUser> grid = new Grid<>();
//
//
//        grid.addColumn(BpmUser::getName).setCaption("Name");
//        grid.addColumn(BpmUser::getEmail).setCaption("Email");
    }

}