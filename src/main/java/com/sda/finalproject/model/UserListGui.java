package com.sda.finalproject.model;

import com.sda.finalproject.domain.BpmUser;
import com.sda.finalproject.manger.RegisterManager;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;


@SpringUI(path = "/user-list")
public class UserListGui extends UI {


    @Autowired
    private RegisterManager registerManager;

    @Autowired
    private Menu menu;


    @Override
    protected void init(VaadinRequest vaadinRequest) {


        ListDataProvider<BpmUser> dataProvider = new ListDataProvider(registerManager.getBpmUserList());
        Grid<BpmUser> grid = new Grid<>();
        grid.setDataProvider(dataProvider);

        grid.addColumn(BpmUser::getName).setId("Name").setCaption("Name");
        grid.addColumn(BpmUser::getSurname).setId("Surname").setCaption("Surname");
        grid.addColumn(BpmUser::getEmail).setId("Email").setCaption("Email");



        VerticalLayout verticalLayout = new VerticalLayout();
        Button editButton = new Button("Edit your data");

        editButton.addClickListener(event ->
        {
            Page.getCurrent().open("/user-edit", null);


        });
        verticalLayout.addComponent(menu.getMenuBar());
        verticalLayout.addComponent(grid);
        verticalLayout.addComponent(editButton);
        setContent(verticalLayout);

    }

}