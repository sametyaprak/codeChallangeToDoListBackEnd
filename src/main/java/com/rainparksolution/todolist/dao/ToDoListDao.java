package com.rainparksolution.todolist.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ToDoListDao {
    private Integer ToDoListId;
    private String title;
    private String description;
    private boolean terms;
}
