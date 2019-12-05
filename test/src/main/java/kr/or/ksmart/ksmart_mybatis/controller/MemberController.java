package kr.or.ksmart.ksmart_mybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

	@GetMapping("/memberList")
	public String getMemberList(Model model) {
		
		
		
		return "/member/memberList";
	}
}
