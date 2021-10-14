package com.rainparksolution.todolist.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ToDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer toDoListId;
    private String title;
    private String description;
    private boolean terms;

    public ToDoList(String title, String description, boolean terms) {
        this.title = title;
        this.description = description;
        this.terms = terms;
    }
}
