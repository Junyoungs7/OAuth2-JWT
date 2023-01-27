package com.jun.studywithus.member.controller;

import com.jun.studywithus.member.dto.MemberSignUpDto;
import com.jun.studywithus.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@Valid @RequestBody MemberSignUpDto memberSignUpDto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body("잘못된 요청입니다. 다시 시도해주세요.");
        }

        try {
            memberService.signUp(memberSignUpDto);
            return ResponseEntity.ok().body("회원가입 성공");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/jwt-test")
    public String jwtTest(){
        return "jwtTest Request Success";
    }
}
