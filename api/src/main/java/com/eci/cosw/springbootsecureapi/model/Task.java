package com.eci.cosw.springbootsecureapi.model;

public class Task {

    String id;
    String text;
    String status;
    String responsible;

    public Task(String id, String text, String status, String responsible) {
        this.id = id;
        this.text = text;
        this.status = status;
        this.responsible = responsible;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }
}
