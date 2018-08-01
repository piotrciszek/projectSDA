package com.sda.finalproject.model;

import com.vaadin.server.Page;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.MenuBar;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class Menu {

    public MenuBar getMenuBar() {
        MenuBar menuBar = new MenuBar();
        menuBar.setWidth(100.0f, Sizeable.Unit.PERCENTAGE);



        MenuBar.Command menuCommand1 = selectedItem -> Page.getCurrent().setLocation("/register");
        MenuBar.Command menuCommand2 = selectedItem -> Page.getCurrent().setLocation("/login");
        MenuBar.Command menuCommand3 = selectedItem -> Page.getCurrent().setLocation("/logout");


            menuBar.addItem("Rejestracja", menuCommand1);
            menuBar.addItem("Logowanie",menuCommand2);
            menuBar.addItem("Wyloguj",menuCommand3);



        return menuBar;
    }
}
