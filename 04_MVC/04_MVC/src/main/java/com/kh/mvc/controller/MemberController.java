package com.kh.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.mvc.model.dao.MemberDAO;
import com.kh.mvc.model.service.MemberService;
import com.kh.mvc.model.vo.Member;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;

	@RequestMapping("search")
	public String search() {
		return "search";
	}

	@RequestMapping("find")
	public String find(String keyword, Model model) {
		List<Member> list = service.findMember(keyword);
		if (list.size() > 0) {
			model.addAttribute("list", list);
			return "find_ok";
		} else {
			return "find_fail";// "find_fail"
		}
		// 서비스 - 비즈니스 로직 처리!
		// -> list 값! 데이터 바인딩 -> Model
	}
	@RequestMapping("register")
	public String register() {
		return "register";
	}

	@RequestMapping("signUp")
	public String signUp(Member vo) {
		service.signUpMember(vo);
		return "redirect:/";
	}

	// login
	@RequestMapping("login")
	public String login() {
		return "login";
	}

	@RequestMapping("signIn")
	public String signIn(Member vo, HttpSession session) {		
		Member member = service.login(vo);
//		HttpSession session = request.getSession();
		if(member!=null) {
			session.setAttribute("vo", member);
		}
		return "login_result";
	}

	@RequestMapping("showAll")
	public String showAll(String keyword, Model model) {
		List<Member> list = service.showAllMember(keyword);
		model.addAttribute("list", list);
		return "showAll";
	}

	
	// signIn - 비즈니스 로직 포함 : 파라미터 값 - > HttpServletRequest request

	// allMember - 비즈니스 로직 포함, 데이터바인딩 - Model
	// -> return "find_ok";

	// logout - 로그아웃 기능!

	// update - 페이지 이동

	// updateMember - 비즈니스 로직 포함 -> 파라미터 request 필요

}
