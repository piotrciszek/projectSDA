package com.sda.finalproject.model;


import com.sda.finalproject.manger.RegisterManager;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI(path = "/register")
public class RegisterGui extends UI {

    @Autowired
    private RegisterManager registerManager;


    @Override
    protected void init(VaadinRequest vaadinRequest) {



        VerticalLayout registerLayout = new VerticalLayout();

        registerLayout.setSpacing(false);
        registerLayout.setMargin(false);
        registerLayout.setCaption("Registration Form");

        TextField emailField = new TextField("E-mail");
        PasswordField passwordField = new PasswordField("Password");
        PasswordField confirmPasswordField = new PasswordField("Confirm Password");

        Button registerButton = new Button("Register User");

        registerButton.addClickListener(event ->
                {
                    Long userId = registerManager.registerPerson(emailField.getValue(),
                            passwordField.getValue(),
                            confirmPasswordField.getValue());
                    if (userId > 0) {
                        Page.getCurrent().open("/login", null);
                        Notification.show(
                                "User added",
                                Notification.Type.TRAY_NOTIFICATION);
                    } else {
                        Notification.show(
                                "Problem",
                                Notification.Type.ERROR_MESSAGE);
                    }
                }
        );

        registerLayout.addComponent(emailField);
        registerLayout.setComponentAlignment(emailField, Alignment.MIDDLE_CENTER);
        registerLayout.addComponent(passwordField);
        registerLayout.setComponentAlignment(passwordField, Alignment.MIDDLE_CENTER);
        registerLayout.addComponent(confirmPasswordField);
        registerLayout.setComponentAlignment(confirmPasswordField, Alignment.MIDDLE_CENTER);
        registerLayout.addComponent(registerButton);
        registerLayout.setComponentAlignment(registerButton, Alignment.MIDDLE_CENTER);



        setContent(registerLayout);
    }


}