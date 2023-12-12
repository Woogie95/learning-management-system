package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.components.MailComponents;
import com.example.learningmanagementsystem.dto.request.CreateMemberRequest;
import com.example.learningmanagementsystem.entity.Member;
import com.example.learningmanagementsystem.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MailComponents mailComponents;

    public boolean create(CreateMemberRequest createMemberRequest) {
        String uuid = UUID.randomUUID().toString();
        Member member = createMemberRequest.toEntity();
        member.updateEmailAuthKey(uuid);
        memberRepository.save(member);

        String email = createMemberRequest.getEmail();
        String subject = "학습 관리 사이트 이메일 인증";
        String text = "<p>학습 관리 사이트 회원가입 이메일 인증을 완료해주세요.<p>" +
                "<p>아래 링크를 클릭하셔서 가입을 완료해 주세요.</p>" +
                "<div><a target='_blank' href='http://localhost:8080/member/email_auth?email=" + uuid + "'> 가입 완료 </a></div>";
        mailComponents.sendMail(email, subject, text);

        return true;
    }

    public boolean emailAuth(String uuid) {
        Optional<Member> emailAuthKey = memberRepository.findByEmailAuthKey(uuid);
        if (emailAuthKey.isEmpty()) {
            return false;
        }
        Member member = emailAuthKey.get();
        member.setEmailAuth(true);
        memberRepository.save(member);
        return true;
    }

}
