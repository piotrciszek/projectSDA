package com.sda.finalproject.model;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.Page;
import com.vaadin.server.Sizeable;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Link;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI(path = "/home")
public class MenuGui extends UI {

    @Autowired
    private Menu menu;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        HorizontalLayout layout = new HorizontalLayout();

        MenuBar menuBar = menu.getMenuBar();

        layout.addComponent(menuBar);
        setContent(layout);
    }


}