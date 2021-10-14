package com.rainparksolution.todolist.payload.response;

import com.rainparksolution.todolist.dao.ToDoListDao;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
public class GetAllLIstResponse {

    List<ToDoListDao> allItems;
}
