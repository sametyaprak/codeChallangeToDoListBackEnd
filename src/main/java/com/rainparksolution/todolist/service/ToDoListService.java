package com.rainparksolution.todolist.service;

import com.rainparksolution.todolist.dao.ToDoListDao;
import com.rainparksolution.todolist.payload.request.NewItemRequest;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public interface ToDoListService {


    ToDoListDao changeToDoneAToDo(Integer id);
    List<ToDoListDao>deleteAToDo(Integer id);
    List<ToDoListDao>addAToDo(NewItemRequest newItemRequest);

}
