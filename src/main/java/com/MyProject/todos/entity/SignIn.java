package com.MyProject.todos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
@Data   // 각 필드들을 getter와 setter를 자동화하겠다
@Entity // 이 클래스를 데이터베이스를 테이블(엔티티)로 만들어줌
@AllArgsConstructor // 모든 필드들을 이용하는 생성자를 만들어준다
@ToString // 클래스를 스트링으로 변환

public class SignIn {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id; // 데이터 베이스의 키 값, 겹치지 않는 유일한 id 값
        @Column(unique = true) // 데이터베이스 항목입니다. unique는 데이터베이스 내에서 겹치는 정보가 없도록 한다
        private String email;
        @Column
        private String nickName;
        @Column
        private String password;

        public SignIn(){
            id = null;
            email = "";
            nickName = "";
            password = "";
        }




}
