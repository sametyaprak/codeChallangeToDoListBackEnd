package com.rainparksolution.todolist.repository;

import com.rainparksolution.todolist.entity.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoListRepo extends JpaRepository<ToDoList,Integer> {

    void deleteByTitle(String description);
    void deleteByToDoListId(Integer id);
}
