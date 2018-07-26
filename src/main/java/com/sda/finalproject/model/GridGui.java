package com.sda.finalproject.model;

import com.sda.finalproject.manger.Person;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;

import java.util.List;
@SpringUI(path = "/test")
public class GridGui extends UI{


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Grid<Person> grid = new Grid<>();


        grid.addColumn(Person::getName).setCaption("Name");
        grid.addColumn(Person::getAge).setCaption("Age");
    }
}
