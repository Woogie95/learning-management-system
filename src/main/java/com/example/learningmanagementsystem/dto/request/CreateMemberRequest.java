package com.example.learningmanagementsystem.dto.request;

import com.example.learningmanagementsystem.entity.Member;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class CreateMemberRequest {

    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private LocalDateTime registered;

    public Member toEntity() {
        return Member.builder()
                .username(this.username)
                .email(this.email)
                .password(this.password)
                .phoneNumber(this.phoneNumber)
                .registered(this.registered)
                .isEmailAuth(false)
                .emailAuthKey("")
                .build();
    }

}
