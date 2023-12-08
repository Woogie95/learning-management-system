package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.dto.request.CreateMemberRequest;
import com.example.learningmanagementsystem.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void create(CreateMemberRequest createMemberRequest) {
        memberRepository.save(createMemberRequest.toEntity());
    }

}
