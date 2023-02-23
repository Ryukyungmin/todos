package com.MyProject.todos.controllers;


import com.MyProject.todos.entity.SignIn;
import com.MyProject.todos.forms.SignInForm;
import com.MyProject.todos.forms.SignUpForm;
import com.MyProject.todos.repository.SignInRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SigninController {
    @Autowired
    SignInRepository signInRepository;

    @PostMapping("/signin")
    public String TrySignIn(@NotNull SignInForm signInForm, @NotNull Model model){


        // 입력창으로부터 넘겨받은 데이터 확인
        System.out.println(signInForm);





        // SIGN_IN Datebase로부터 모든 레코드들을 전부 가져온다
        //List<SignIn> signIns = signInRepository.findAll();
        List<SignIn> signIns = signInRepository.findByEmail(signInForm.getEmail());
        if (signIns.isEmpty()) // signIns 리스트가 비었으면, 데이터베이스에 저장된 내용이 없음
        {
            // 사인업 해주는 page로 이동
            return "/signup";
        }

        for (SignIn sign : signIns) // signIns 리스트 객체의 처음부터 끝까지 돌면서
        {
            if (sign.getEmail().equals(signInForm.getEmail()))
            {
                //로그인 처리
                if (sign.getPassword().equals(signInForm.getPassword())){
                    model.addAttribute("username",sign.getNickName() ) ;
                    return "/hello";
                }

            }
        }

        // 그 중에서 첫번째 가져온다
        //SignIn si = signIns.get(0);


        //SignIn sign = signInForm.toEntity();
        //System.out.println(sign.toString());

        //model.addAttribute("username", sign.getEmail());

        // 데이터베이스에서 값을 불러와서 signInForm으로부터 넘어온 값과 비교해서
        // 로그인을 수행하던지, 아니면 회원가입으로 유도(SignUp)


        return "/signup";
    }





    @PostMapping("/trysignup")
    public String TrySignUp(SignUpForm signUpForm,Model model){
        //System.out.println(signUpForm);

        // 데이터 베이스에 입력을 한다
        // 데이터베이스에 입력할 데이터를 만드는 과정인데, 넘겨받은 폼데이터를 SignIn객체로 생성한다
        SignIn signIn = signUpForm.toEntity();

        //System.out.println(signIn);

        // 지금 생성한 signIn 객체를 데이터베이스에 저장한다
        // 저장이 성공적으로 수행되면 저장된 SignIn 객체로 반환받는다
        SignIn savedsignin;
        try {
            savedsignin = signInRepository.save(signIn);


        }catch (Exception e){ // 이메일이 이미 존재하는 경우
            String strMsg = String.format("저장을 할 수 없습니다", e.getMessage());
            // 에러 내용을 사용자한테 보여준다
            model.addAttribute("error-msg", strMsg);
            return "/error_msg";
        }

        System.out.println(savedsignin);
        model.addAttribute("username",savedsignin.getNickName() ) ;

        // 저장된 데이터의 닉네임을 가져온다


        return "/hello";
    }
}
