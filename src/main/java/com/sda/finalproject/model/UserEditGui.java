package com.sda.finalproject.model;

import com.sda.finalproject.domain.BpmUser;
import com.sda.finalproject.manger.LoginManager;
import com.sda.finalproject.repository.BpmUserRepository;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.security.Principal;


@SpringUI(path = "/user-edit")
public class UserEditGui extends UI {

    @Autowired
    private Menu menu;

    @Autowired
    private BpmUserRepository bpmUserRepository;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        BpmUser principal = (BpmUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        VerticalLayout verticalLayout = new VerticalLayout();

        TextField textName = new TextField("Name");
        textName.setPlaceholder(principal.getName());


        TextField textSurname = new TextField("Surname");
        textSurname.setPlaceholder(principal.getSurname());


        TextField textEmail = new TextField("E-mail");
        textEmail.setPlaceholder(principal.getEmail());

        Button updateButton = new Button("Update");

        Button deleteButton = new Button("Delete Account");

        updateButton.addClickListener(event ->
                {
                    if (!textEmail.getValue().isEmpty()) {
                        principal.setEmail(textEmail.getValue());
                    }
                    if (!textName.getValue().isEmpty()) {
                        principal.setName(textName.getValue());
                    }
                    if (!textSurname.getValue().isEmpty()) {
                        principal.setSurname(textSurname.getValue());
                    }
                    bpmUserRepository.save(principal);
                    Notification.show("Update complete", Notification.Type.TRAY_NOTIFICATION);
                    Page.getCurrent().open("/user-list", null);


                }
        );

        deleteButton.addClickListener(event ->
        {
            bpmUserRepository.delete(principal);
            Notification.show("Delete complete", Notification.Type.TRAY_NOTIFICATION);
            Page.getCurrent().open("/register", null);

        });

        verticalLayout.addComponent(menu.getMenuBar());
        verticalLayout.addComponent(textName);
        verticalLayout.addComponent(textSurname);
        verticalLayout.addComponent(textEmail);
        verticalLayout.addComponent(updateButton);
        verticalLayout.addComponent(deleteButton);
        setContent(verticalLayout);

    }


}
