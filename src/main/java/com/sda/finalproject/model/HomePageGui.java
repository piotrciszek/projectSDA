package com.sda.finalproject.model;

import com.vaadin.server.*;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI(path = "/")
public class HomePageGui extends UI {

    @Autowired
    private Menu menu;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        VerticalLayout verticalLayout = new VerticalLayout();
        VerticalLayout verticalLayout2 = new VerticalLayout();
        verticalLayout2.setMargin(true);
        verticalLayout2.setSpacing(true);



        verticalLayout.setSpacing(false);
        verticalLayout.setMargin(false);
        verticalLayout.addComponent(menu.getMenuBar());


        Label label1 = new Label("This is our final project for SDA Java course. " +
                "We would like to present the skills that we gained during the course");
        Label label2 = new Label("This site was created for tasks management. " +
                "You can easily create a new task, add it to task-list. " +
                "You can choose which task you are going to do and after that change its status to 'done'");

        Label label3 = new Label(" ");
        Label label4 = new Label("Authors: Piotr Ciszek, Maciej Wolny");

        verticalLayout2.addComponent(label1);
        verticalLayout2.addComponent(label2);
        verticalLayout2.addComponent(label3);
        verticalLayout2.addComponent(label3);
        verticalLayout2.addComponent(label3);
        verticalLayout2.addComponent(label4);





        Image image = new Image();
        image.setSource(new ExternalResource("https://media.giphy.com/media/Ov7lAOUsu4Yo0/giphy.gif"));

        verticalLayout2.addComponent(image);
        verticalLayout.addComponent(verticalLayout2);
        setContent(verticalLayout);
    }

}
