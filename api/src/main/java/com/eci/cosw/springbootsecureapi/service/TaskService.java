package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Task;

import java.util.List;

public interface TaskService {

    List<Task> getAll();

    Task getById(String id) throws Exception;

    Task create(Task task);

    void remove(String id) throws Exception;

}
