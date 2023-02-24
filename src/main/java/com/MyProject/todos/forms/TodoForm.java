package com.MyProject.todos.forms;

import com.MyProject.todos.entity.TodoList;
import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class TodoForm {
    private String todo;
    private String userid;


    public TodoList toEntity() {

        return  new TodoList(null, Long.parseLong(userid), todo, false);

    }
}
