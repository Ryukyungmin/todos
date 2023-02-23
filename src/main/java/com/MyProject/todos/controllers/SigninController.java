package com.MyProject.todos.controllers;


import com.MyProject.todos.entity.SignIn;
import com.MyProject.todos.forms.SignInForm;
import com.MyProject.todos.forms.SignUpForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SigninController {

    @PostMapping("/signin")
    public String TrySignIn(@NotNull SignInForm signInForm, @NotNull Model model){

        System.out.println(signInForm);
        SignIn sign = signInForm.toEntity();
        System.out.println(sign.toString());

        model.addAttribute("username", sign.getEmail());

        // 데이터베이스에서 값을 불러와서 signInForm으로부터 넘어온 값과 비교해서
        // 로그인을 수행하던지, 아니면 회원가입으로 유도(SignUp)

        return "hello";
    }

    @PostMapping("/trysignup")
    public String TrySignUp(SignUpForm signUpForm,Model model){
        System.out.println(signUpForm);

        return "";
    }
}
