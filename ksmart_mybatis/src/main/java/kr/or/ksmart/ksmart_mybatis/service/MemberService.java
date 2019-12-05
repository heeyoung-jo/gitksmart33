package kr.or.ksmart.ksmart_mybatis.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.ksmart_mybatis.mapper.MemberMapper;
import kr.or.ksmart.ksmart_mybatis.vo.Member;

@Service
public class MemberService {

	@Autowired
	private MemberMapper membermapper;
	
	public List<Member> getMemeberList(){
		return membermapper.getMemberList();
	}
	public int addMember(Member member) {
		
		return membermapper.addMember(member);
		//맵퍼 클래스 객체 참조 변수.addMember();
	}
	public Member selectByMember(String memberId) {
		
		return membermapper.selectByMember(memberId);
	}
	public int updateM(Member member) {
		
		System.out.println("MemberService-->" + member);
		
		return membermapper.updateM(member);
	}
	public int deleteM(String memberId) {
		System.out.println("MemberService-->>" + memberId);
		return membermapper.deleteM(memberId);
	}
	public Member login(Member member) {
		
		return membermapper.login(member);
	}
	public List<Member> memberSearch(String sk, String sv) {
		
		return membermapper.memberSearch(sk, sv);
	}
}
