package com.eci.cosw.springbootsecureapi.controller;

import com.eci.cosw.springbootsecureapi.model.Task;
import com.eci.cosw.springbootsecureapi.service.TaskService;
import com.eci.cosw.springbootsecureapi.service.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class TaskConotroller {

    @Autowired
    TaskServiceImpl taskServiceImpl;

    @GetMapping
    public ResponseEntity<?> findAllTask(){
        try{
            List<Task> taskList= taskServiceImpl.getAll();
            return new ResponseEntity<>(taskList, HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.ACCEPTED);
        }
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findTaskById(@PathVariable String id){
        try{
            Task task= taskServiceImpl.getById(id);
            return new ResponseEntity<>(task, HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.ACCEPTED);
        }
    }

    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody Task task){
        try{
            taskServiceImpl.create(task);
            return new ResponseEntity<>(task, HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.ACCEPTED);
        }
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> removeTaskById(@PathVariable String id){
        try{
            taskServiceImpl.remove(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.ACCEPTED);
        }
    }


}
