package kr.or.ksmart.ksmart_mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.ksmart_mybatis.vo.Member;



@Mapper
public interface MemberMapper {
	
	// 전체 회원 리스트 조회
	List<Member> getMemberList();
	
	//회원등록 (select 외 모든건 int로 받는다)
	int addMember(Member member);
	
	Member selectByMember(String memberId);
	
	int updateM(Member member);
	
	int deleteM(String memberId);
	
	Member login(Member member);
	
	List<Member> memberSearch(String sk, String sv);
}
