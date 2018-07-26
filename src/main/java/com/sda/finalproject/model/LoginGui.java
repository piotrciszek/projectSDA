package com.sda.finalproject.model;

import com.sda.finalproject.domain.BpmUser;
import com.sda.finalproject.manger.LoginManager;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@SpringUI(path = "/login")
public class LoginGui extends UI {

    @Autowired
    private LoginManager loginManager;

    @Override
    protected void init(VaadinRequest vaadinRequest) {


        VerticalLayout registerLayout = new VerticalLayout();

        registerLayout.setSpacing(false);
        registerLayout.setMargin(false);
        registerLayout.setCaption("Login");

        TextField emailField = new TextField("E-mail");
        PasswordField passwordField = new PasswordField("Password");

        Button loginButton = new Button("Login");

        loginButton.addClickListener(event ->
        {

            if (!emailField.getValue().isEmpty() && !passwordField.getValue().isEmpty()) {

                Optional<BpmUser> userByEmail = loginManager.getPersonByEmail(emailField.getValue());
                if (userByEmail.isPresent()) {
                    if (userByEmail.get().getPassword().equals(passwordField.getValue())) {

                        Notification.show("Hello " + userByEmail.get().getName(), Notification.Type.TRAY_NOTIFICATION);
                        Page.getCurrent().open("/user-data?userId=" + userByEmail.get().getId(), null);

                    } else {
                        Notification.show("Incorrect password!", Notification.Type.ERROR_MESSAGE);
                    }


                } else {
                    Notification.show("Cannot find the user", Notification.Type.ERROR_MESSAGE);
                    Page.getCurrent().open("/register", null);
                }


            }


        });

        registerLayout.addComponent(emailField);
        registerLayout.setComponentAlignment(emailField, Alignment.MIDDLE_CENTER);
        registerLayout.addComponent(passwordField);
        registerLayout.setComponentAlignment(passwordField, Alignment.MIDDLE_CENTER);
        registerLayout.addComponent(loginButton);
        registerLayout.setComponentAlignment(loginButton, Alignment.MIDDLE_CENTER);

        setContent(registerLayout);




    }


}
