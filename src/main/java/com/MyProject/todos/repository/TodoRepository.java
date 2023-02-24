package com.MyProject.todos.repository;

import com.MyProject.todos.entity.TodoList;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface TodoRepository extends ListCrudRepository<TodoList, Long> {
    public List<TodoList> findByUserid(String userid);
}
