package com.sda.finalproject.model;


import com.sda.finalproject.manger.BpmRegisterManager;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;


@SpringUI
public class RegisterGui extends UI {

    @Autowired
    private BpmRegisterManager bpmRegisterManager;


    @Override
    protected void init(VaadinRequest vaadinRequest) {



        VerticalLayout registerLayout = new VerticalLayout();

        Label helloText = new Label(
                "STRONA REJESTRACJI");
        helloText.addStyleName(ValoTheme.LABEL_H1);

        registerLayout.setSpacing(false);
        registerLayout.setMargin(false);
        registerLayout.setCaption("Registration Form");

        TextField emailField = new TextField("E-mail");
        PasswordField passwordField = new PasswordField("Password");
        PasswordField confirmPasswordField = new PasswordField("Confirm Password");

        Button registerButton = new Button("Register User");

        registerButton.addClickListener(event ->
                {
                    Long userId = bpmRegisterManager.registerPerson(emailField.getValue(),
                            passwordField.getValue(),
                            confirmPasswordField.getValue());
                    if (userId > 0) {
                        Page.getCurrent().open("/user-data?userId=" + userId, null);
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

        registerLayout.addComponent(helloText);
        registerLayout.setComponentAlignment(helloText, Alignment.MIDDLE_CENTER);
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