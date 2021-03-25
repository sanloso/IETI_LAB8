package com.eci.cosw.springbootsecureapi.repository;

import com.eci.cosw.springbootsecureapi.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {
    List<Task> bdTask = new ArrayList();

    public List<Task> findAll(){
        return bdTask;
    }

    public Task findById(String id) throws Exception {
        for (int i = 0; i < bdTask.size(); i++){
            if(bdTask.get(i).getId().equals(id)){
                return bdTask.get(i);
            }
        }
        throw new Exception("No existe esta tarea");
    }

    public Task create (Task task){
        bdTask.add(task);
        return task;
    }

    public void remove (String id) throws Exception {
        for (int i = 0; i < bdTask.size(); i++){
            if(bdTask.get(i).getId().equals(id)){
                bdTask.remove(i);
            }
        }
    }

}
