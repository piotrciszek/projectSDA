package com.sda.finalproject.model;

import com.vaadin.server.FileResource;
import com.vaadin.server.Page;
import com.vaadin.server.Sizeable;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Image;
import com.vaadin.ui.MenuBar;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class Menu {

    public MenuBar getMenuBar() {
        MenuBar menuBar = new MenuBar();
        menuBar.setWidth(100.0f, Sizeable.Unit.PERCENTAGE);

        Boolean isAnonymous = SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser");

        MenuBar.Command menuCommand = selectedItem -> Page.getCurrent().setLocation("/");
        MenuBar.Command menuCommand1 = selectedItem -> Page.getCurrent().setLocation("/register");
        MenuBar.Command menuCommand2 = selectedItem -> Page.getCurrent().setLocation("/login");
        MenuBar.Command menuCommand3 = selectedItem -> Page.getCurrent().setLocation("/logout");
        MenuBar.Command menuCommand4 = selectedItem -> Page.getCurrent().setLocation("/add-task");
        MenuBar.Command menuCommand5 = selectedItem -> Page.getCurrent().setLocation("/task-list");
        MenuBar.Command menuCommand6 = selectedItem -> Page.getCurrent().setLocation("/user-list");

        if(isAnonymous){
            menuBar.addItem("Home", menuCommand);
            menuBar.addItem("Registry", menuCommand1);
            menuBar.addItem("Login", menuCommand2);
        }

        if (!isAnonymous) {
            menuBar.addItem("Home", menuCommand);
            menuBar.addItem("User List", menuCommand6);
            menuBar.addItem("Add Task", menuCommand4);
            menuBar.addItem("Tasks List", menuCommand5);
            menuBar.addItem("Logout", menuCommand3);


        }

        return menuBar;
    }
}
