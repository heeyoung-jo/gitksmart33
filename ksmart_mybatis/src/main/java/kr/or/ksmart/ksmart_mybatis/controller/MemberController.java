package kr.or.ksmart.ksmart_mybatis.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ksmart.ksmart_mybatis.service.MemberService;
import kr.or.ksmart.ksmart_mybatis.vo.Member;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	//컨테이너 get방식에 주소요청을 정의
	@GetMapping("/memberList")
		//String은 화면의 경로
	public String getMemberList(Model model) {
		model.addAttribute("memberList", memberService.getMemeberList());
		return "/member/memberList";
	}
	
	@GetMapping("/memberInsert")
	public String addMember() {

		return "/member/memberInsert";
	}
	@PostMapping("/memberInsert")
	public String addMember(Member member) {
		
		memberService.addMember(member);
		System.out.println("member=====>"+member.toString());
		
		return "redirect:/memberList"; 
			
	}
	
	//수정화면 (회원정보가져오기)
	@GetMapping("/updateM")
	public String selectByMember(@RequestParam(value="memberId") String memberId, Model model) {
		
		
		System.out.println("memberId->" + memberId);
		model.addAttribute("member", memberService.selectByMember(memberId));
		
		return "/member/updateM";
	}
	
	//수정화면(수정하기)
	@PostMapping("/updateM")
	public String updateM(Member member) {
		
		memberService.updateM(member);
		
		return "redirect:/memberList";
	}
	
	//삭제
	@GetMapping("/deleteM")
	public String deleteM(@RequestParam(value="memberId") String memberId) {
		
		memberService.deleteM(memberId);
		System.out.println("MemberController-->>" + memberId);
		return "redirect:/memberList";
	}
	//로그인화면 이동
	@GetMapping("/login")
	public String loginM() {
		
		return "/member/login";
		
	}
	//로그인
	@PostMapping("/login")
	public String login(Member member, HttpSession session){
	String loginId = member.getMemberId();
	System.out.println(loginId + "<- loginId 확인");
	String loginPw = member.getMemberPw();
	System.out.println(loginPw + "<- loginPw 확인");
	
	Member m = new Member();
	m = memberService.login(member);
	System.out.println(m + "Member m 값 확인");
	if(m != null) {
		if(loginId.equals(m.getMemberId())) {
			System.out.println(m.getMemberId() + "<==== 조건문 m.getMemberId 값확인");
			System.out.println(loginId + "<==== 조건문 loginId 값확인");
			System.out.println("아이디 일치");
			if(loginPw.equals(m.getMemberPw())) {
				System.out.println(m.getMemberPw() + "<====조건문 m.getMemberPw 값확인");
				System.out.println(loginPw + "<====조건문 loginPw 값확인");
				System.out.println("로그인 성공");
				session.setAttribute("SID", m.getMemberId());
				session.setAttribute("SNAME", m.getMemberName());
				session.setAttribute("SLEVEL", m.getMemberLevel());
				
				return "redirect:/";
			}else{
				
				System.out.println("비밀번호 불일치");
				}
			}else{
			
				}
	}else{
		System.out.println("아이디 불일치");
	}

		
		
	
		return "/member/login";
	
	}
	//세션 로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("SID");
		session.removeAttribute("SNAME");
		session.removeAttribute("SLEVEL");
		return "redirect:/";
	}
	//member검색화면
	@GetMapping("/memberSearch")
	public String SearchM() {
		
		return "/member/memberSearch";
	}
	
	@PostMapping("/memberSearch")
	public String memberSearch(@RequestParam(value="sk") String sk, 
			@RequestParam(value="sv") String sv, Model model) {
		System.out.println(sk + "<========sk 값 확인");
		System.out.println(sv + "<========sv 값 확인");
		model.addAttribute("memberList", memberService.memberSearch(sk, sv));
		
		return "/member/memberSearch";
	}
}
