package com.example.learningmanagementsystem.controller;

import com.example.learningmanagementsystem.dto.request.CreateMemberRequest;
import com.example.learningmanagementsystem.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/register")
    public String createForm() {
        return "member/register";
    }

    @PostMapping("/member/register")
    public String create(Model model, CreateMemberRequest createMemberRequest) {
        boolean result = memberService.create(createMemberRequest);
        model.addAttribute("result", result);
        return "member/register_complete";
    }

    @GetMapping("/member/email_auth")
    public String emailAuthForm(Model model, HttpServletRequest request) {
        String uuid = request.getParameter("email");
        boolean result = memberService.emailAuth(uuid);
        model.addAttribute("result", result);
        return "member/email_auth";
    }

}
