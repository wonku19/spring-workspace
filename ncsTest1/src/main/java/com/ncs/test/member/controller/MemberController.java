package com.ncs.test.member.controller;

import com.ncs.test.member.model.service.MemberService;
import com.ncs.test.member.model.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MemberController {
    
    @Autowired
    private MemberService memberService;

    @PostMapping("/login")
    public String memberLogin(HttpServletRequest request, Model model) {
        String memberId = request.getParameter("memberId");
        String memberPwd = request.getParameter("memberPwd");

        Member member = memberService.loginMember(memberId, memberPwd);

        if(member != null) {
            request.getSession().setAttribute("loginMember", member);
            return "redirect:/"; 
        } else {
            model.addAttribute("msg", "로그인 실패");
            return "errorPage"; 
        }
    }
}