package com.sda.finalproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.Collections;
import java.util.List;


@Entity
public class BpmUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String password;
    private String name;
    private String surname;


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



    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority =
                new SimpleGrantedAuthority("ROLE_USER");
        return Collections.singleton(simpleGrantedAuthority);
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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



    public BpmUser() {
    }

    public BpmUser(String email, String name, String surname) {
        this.email = email;
        this.name = name;
        this.surname = surname;

    }

    public static BpmUser createList(BpmUser bpmUser) {
        return new BpmUser(bpmUser.getEmail(), bpmUser.getName(), bpmUser.getSurname());
    }


}
