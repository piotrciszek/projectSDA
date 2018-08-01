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

        if(isAnonymous){
            menuBar.addItem("Strona Główna", menuCommand);
            menuBar.addItem("Rejestracja", menuCommand1);
            menuBar.addItem("Logowanie", menuCommand2);
        }

        if (!isAnonymous) {
            menuBar.addItem("Strona Główna", menuCommand);
            menuBar.addItem("Dodaj Zadanie", menuCommand4);
            menuBar.addItem("Lista Zadań", menuCommand5);
            menuBar.addItem("Wyloguj", menuCommand3);


        }

        return menuBar;
    }
}
