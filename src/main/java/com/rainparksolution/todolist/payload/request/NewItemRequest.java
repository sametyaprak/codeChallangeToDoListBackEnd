package com.rainparksolution.todolist.payload.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewItemRequest {

    String title;
    String description;
    boolean done;
}
