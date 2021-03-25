package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Task;
import com.eci.cosw.springbootsecureapi.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task getById(String id) throws Exception {
        return taskRepository.findById(id);
    }

    @Override
    public Task create(Task task) {
        return taskRepository.create(task);
    }

    @Override
    public void remove(String id) throws Exception {
        taskRepository.remove(id);
    }
}
