package com.MyProject.todos.forms;

import com.MyProject.todos.entity.SignIn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
public class SignInForm {
    private String email;

    private String nickname;
    private String password;



    public SignIn toEntity(){
        return new SignIn(null, email, nickname, password);
    }
}
