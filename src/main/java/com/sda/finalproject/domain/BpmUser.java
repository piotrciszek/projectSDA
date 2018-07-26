package com.sda.finalproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class BpmUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String email;
    private String password;
    private String name;
    private String surname;
    private BpmUserRole bpmUserRole;
    private BpmUserSubjectExpert bpmUserSubjectExpert;

//    public BpmUser(String email, String password, String password_confirm) {
//        this.email = email;
//        this.password = password;
//        this.password_confirm = password_confirm;
//    }
//
//    public BpmUser(String email, String name, String surname, BpmUserSubjectExpert bpmUserSubjectExpert) {
//        this.email = email;
//        this.name = name;
//        this.surname = surname;
//        this.bpmUserSubjectExpert = bpmUserSubjectExpert;
//    }

//    public static BpmUser createList(BpmUser user) {
//            return new BpmUser(
//                    user.getEmail(),
//                    user.getName(),
//                    user.getSurname(),
//                    user.getBpmUserSubjectExpert());
//        }



    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public BpmUserRole getBpmUserRole() {
        return bpmUserRole;
    }

    public void setBpmUserRole(BpmUserRole bpmUserRole) {
        this.bpmUserRole = bpmUserRole;
    }

    public BpmUserSubjectExpert getBpmUserSubjectExpert() {
        return bpmUserSubjectExpert;
    }

    public void setBpmUserSubjectExpert(BpmUserSubjectExpert bpmUserSubjectExpert) {
        this.bpmUserSubjectExpert = bpmUserSubjectExpert;
    }

    public BpmUser() {
    }

    public BpmUser(String email, String name, String surname, BpmUserSubjectExpert bpmUserSubjectExpert) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.bpmUserSubjectExpert = bpmUserSubjectExpert;
    }

    public static BpmUser createList(BpmUser bpmUser) {
        return new BpmUser(bpmUser.getEmail(), bpmUser.getName(), bpmUser.getSurname(), bpmUser.getBpmUserSubjectExpert());
    }


}
