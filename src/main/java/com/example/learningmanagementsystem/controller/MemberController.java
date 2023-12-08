package com.example.learningmanagementsystem.controller;

import com.example.learningmanagementsystem.dto.request.CreateMemberRequest;
import com.example.learningmanagementsystem.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/register")
    public String create() {
        return "member/register";
    }

    @PostMapping("/member/register")
    public String create(CreateMemberRequest createMemberRequest) {
        memberService.create(createMemberRequest);
        return "index";
    }

}
