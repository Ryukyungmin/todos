package com.MyProject.todos.repository;

import com.MyProject.todos.entity.SignIn;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

// 데이터 베이스의 가장 기본적인 작업들
//CRUD, Create(데이터 입력), Read(읽기), Update(수정), Delete(삭제)
// 데이처베이스에 CRUD작업 ===> JPA (Database 접근)
public interface SignInRepository extends ListCrudRepository<SignIn, Long> {
    public List<SignIn> findByEmail(String email);
    // public List<SignIn> findByNickname(String nickname);
}
