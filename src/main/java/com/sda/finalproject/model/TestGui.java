package com.sda.finalproject.model;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI(path = "/test2222")
public class TestGui extends UI{
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout verticalLayout = new VerticalLayout();
    }
}
