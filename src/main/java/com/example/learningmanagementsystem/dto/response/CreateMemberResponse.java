package com.example.learningmanagementsystem.dto.response;

import com.example.learningmanagementsystem.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class CreateMemberResponse {

    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private LocalDateTime registered;

    public static CreateMemberResponse from(Member member) {
        return CreateMemberResponse.builder()
                .username(member.getUsername())
                .email(member.getEmail())
                .password(member.getPassword())
                .phoneNumber(member.getPhoneNumber())
                .registered(member.getRegistered())
                .build();
    }

}
