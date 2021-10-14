package com.rainparksolution.todolist.controller;

import com.rainparksolution.todolist.dao.ToDoListDao;
import com.rainparksolution.todolist.service.ToDoListServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ToDoListController {
    
    @Autowired
    ToDoListServiceImp toDoListServiceImp;

    @GetMapping("/getAll")
    public List<ToDoListDao> getAllList() {
        return toDoListServiceImp.getAllToDoList();
    }



}
