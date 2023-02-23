package com.MyProject.todos.forms;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class SignUpForm {
    private String email;
    private String nickname;
    private String password;
    private String confPassword;
}
