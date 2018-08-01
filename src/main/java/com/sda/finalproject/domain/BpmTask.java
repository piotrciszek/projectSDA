package com.sda.finalproject.domain;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class BpmTask {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;
    private String description;
    private String comment;
    private LocalDateTime addTime;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean done;

    @ManyToOne
    @JoinColumn(name = "user_email")
    private BpmUser bpmUser;

    public BpmUser getBpmUser() {
        return bpmUser;
    }

    public void setBpmUser(BpmUser bpmUser) {
        this.bpmUser = bpmUser;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public BpmTask(String title, String description, LocalDateTime addTime) {
        this.title = title;
        this.description = description;
        this.addTime = addTime;
    }

    public BpmTask() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getAddTime() {
        return addTime;
    }

    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}

