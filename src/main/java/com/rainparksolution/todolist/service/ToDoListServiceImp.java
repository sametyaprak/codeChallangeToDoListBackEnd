package com.rainparksolution.todolist.service;

import com.rainparksolution.todolist.dao.ToDoListDao;
import com.rainparksolution.todolist.entity.ToDoList;
import com.rainparksolution.todolist.payload.request.NewItemRequest;
import com.rainparksolution.todolist.payload.response.GetAllLIstResponse;
import com.rainparksolution.todolist.repository.ToDoListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToDoListServiceImp implements ToDoListService {

    @Autowired
    ToDoListRepo toDoListRepo;

    public List<ToDoListDao> getAllToDoList() {
        return toDoListRepo.findAll().stream().map(this::convertToDaoToDoList).collect(Collectors.toList());

    }

    @Override
    public ToDoListDao changeToDoneAToDo(Integer id) {

        if (toDoListRepo.findById(id).isPresent()) {
            ToDoList toDoList = toDoListRepo.findById(id).get();
            if (toDoList.isTerms()) {
                toDoListRepo.findById(id).get().setTerms(false);
            } else {
                toDoListRepo.findById(id).get().setTerms(true);
            }
            toDoListRepo.save(toDoList);

        }
        return convertToDaoToDoList(toDoListRepo.findById(id).get());
    }


    @Override
    public List<ToDoListDao> deleteAToDo(Integer id) {
        toDoListRepo.deleteByToDoListId(id);
        return toDoListRepo.findAll().stream().map(this::convertToDaoToDoList).collect(Collectors.toList());
    }

    @Override
    public List<ToDoListDao> addAToDo(NewItemRequest newItemRequest) {
        ToDoList toDoList = new ToDoList();
        toDoList.setDescription(newItemRequest.getDescription());
        toDoList.setTitle(newItemRequest.getTitle());
        toDoList.setTerms(newItemRequest.isDone());
        toDoListRepo.save(toDoList);
        return toDoListRepo.findAll().stream().map(this::convertToDaoToDoList).collect(Collectors.toList());
    }


    ToDoListDao convertToDaoToDoList(ToDoList toDoList) {
        ToDoListDao toDoListDao = new ToDoListDao();
        toDoListDao.setDescription(toDoList.getDescription());
        toDoListDao.setTerms(toDoList.isTerms());
        toDoListDao.setTitle(toDoList.getTitle());
        toDoListDao.setToDoListId(toDoList.getToDoListId());
        return toDoListDao;
    }
}
