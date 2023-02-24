package com.MyProject.todos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Entity // database entity class
@Data // data object getter, setter등을 자동화 해주겠다
@AllArgsConstructor // 모든 필드들을 갖는 생성자를 만들어주겠다
@ToString
public class TodoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long userid;

    private String todo;

    private boolean done;

    public TodoList(){
        id = null;
        userid = null;
        todo= "";
        done = false;
    }
}
