package com.MyProject.todos.controllers;

import com.MyProject.todos.entity.SignIn;
import com.MyProject.todos.entity.TodoList;
import com.MyProject.todos.forms.TodoForm;
import com.MyProject.todos.repository.SignInRepository;
import com.MyProject.todos.repository.TodoRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class TodoController  {

    @Autowired
    private TodoRepository todoRepos;

    @Autowired
    private SignInRepository signInRepository;


    @PostMapping("/addtodo")
    public String AddTodo(@NotNull TodoForm todoForm, @NotNull Model model) {
        TodoList todo = todoForm.toEntity();
        TodoList savedTodo = todoRepos.save(todo);
        // log.info(savedTodo.toString());

        System.out.println(savedTodo.toString());

        return ToHello(savedTodo.getUserid(), model);

    }

    public String ToHello(Long userid, Model model) {

        Optional<SignIn> siList = signInRepository.findById(userid);
        if ( !siList.isPresent()){
            throw (new IllegalArgumentException()); //인위적으로 에러를 발생시킴
        }

        SignIn si = siList.get(); // 하나의 유일한 레코드를 가져옴
        model.addAttribute("username", si.getNickName());
        model.addAttribute("userid", si.getId());

        List<TodoList> todos = todoRepos.findByUserid(String.format("%d", si.getId()));
        if (todos.isEmpty()){
            System.out.println("todo is empty");
        }
        else {
            ArrayList<TodoList> arrTodos = new ArrayList<>();
            for (TodoList myTodo : todos) {
                arrTodos.add(myTodo);
            }

            model.addAttribute("todos", arrTodos);

        }



        return "/hello";
    }

    @RequestMapping(value = "/todos")
    public String ReadTodos(@RequestParam Long userid, @NotNull Model model) {
        return ToHello(userid, model);
    }

    @PostMapping("/todolist")
    public String TodoList(@RequestParam Long userid, @NotNull Model model ) {
        return ToHello(userid, model);
    }
}
