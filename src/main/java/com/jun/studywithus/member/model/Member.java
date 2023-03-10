package com.jun.studywithus.member.model;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String email;
    private String password;
    private String nickname;
    private String imageUrl;
    private int age;
    private String city;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    private String socialId;

    private String refreshToken;

    public void authorizeMember(){
        this.role = Role.USER;
    }

    public void passwordEncode(PasswordEncoder passwordEncoder){
        this.password = passwordEncoder.encode(this.password);
    }

    public void updateRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

//    @Builder(builderMethodName = "commonSignUp")
//    public Member(String email, String password, String nickname, int age, String city, Role role){
//        this.email = email;
//        this.password = password;
//        this.nickname = nickname;
//        this.age = age;
//        this.city = city;
//        this.role = role;
//    }
//
//    @Builder(builderMethodName = "socialSignUp")
//    public Member(SocialType socialType, String socialId, String email, String nickname, String imageUrl, Role role){
//        this.socialType = socialType;
//        this.socialId = socialId;
//        this.email = email;
//        this.nickname = nickname;
//        this.imageUrl = imageUrl;
//        this.role = role;
//    }



}
