package com.jun.studywithus.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
public class MemberSignUpDto {

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String nickname;

    @NotBlank
    private int age;

    @NotBlank
    private String city;
}
