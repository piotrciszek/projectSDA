package com.sda.finalproject.model;

import com.sda.finalproject.domain.BpmUser;
import com.sda.finalproject.manger.RegisterManager;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;


@SpringUI(path = "/user-data")
public class UserDataGUI extends UI {


    @Autowired
    private RegisterManager registerManager;


    @Override
    protected void init(VaadinRequest vaadinRequest) {


        ListDataProvider<BpmUser> dataProvider = new ListDataProvider(registerManager.getBpmUserList());
        Grid<BpmUser> grid = new Grid<>();
        grid.setDataProvider(dataProvider);

        grid.addColumn(BpmUser::getName).setId("Name").setCaption("Name");
        grid.addColumn(BpmUser::getEmail).setId("Email").setCaption("Email");

        setContent(grid);
    }

}