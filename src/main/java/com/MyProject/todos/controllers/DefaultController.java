package com.MyProject.todos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // DefaultController 클래스를 Controller로 쓰겠다
public class DefaultController {
    @GetMapping("/hi")
    public String SayHello(Model model){
        model.addAttribute("username", "류경민");
        return "hello";
    }

    @GetMapping("/signup")
    public String SignUp(Model model) {return "/signup";}

}
