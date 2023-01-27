package com.jun.studywithus.member.repository;

import com.jun.studywithus.member.model.Member;
import com.jun.studywithus.member.model.SocialType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);
    Optional<Member> findByNickname(String nickname);
    Optional<Member> findByRefreshToken(String refreshToken);
    Optional<Member> findBySocialTypeAndSocialId(SocialType socialType, String socialId);
}
