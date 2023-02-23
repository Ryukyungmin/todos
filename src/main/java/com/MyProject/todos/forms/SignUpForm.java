package com.MyProject.todos.forms;

import com.MyProject.todos.entity.SignIn;
import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class SignUpForm {
    private String email;
    private String nickname;
    private String password;
    private String confPassword;

    public SignIn toEntity() {
        return (new SignIn(null, email, nickname, password));
    }
}
