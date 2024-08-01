package service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import dao.MemberDao;
import dao.MemberDaoImpl;
import dto.Member;

/* 왜 Service, Dao 인터페이스를 만들어서 구현했을까?
 * - 인터페이스를 상속 받아 구현하면 모든 자식 클래스가
 * 	 똑같은 기능을 가지게 되어 유사한 모습을 가지게 됨!
 * 
 * 	 -> 언제든지 서로 다른 자식 클래스로 대체 가능!!
 * 	    ==> 유지 보수성 증가
 * 
 */

//MemberService 인터페이스를 상속받아 구현
public class MemberServiceImpl implements MemberService {
	
//	dao 객체 부모 참조 변수 선언
	private MemberDao dao = null;
	
	
//	기본 생성자
//	- MemberServiceImpl 객체 생성 시 
//	  MemberDaoImpl     객체도 생성
	public MemberServiceImpl() throws FileNotFoundException, 
		                              ClassNotFoundException, 
		                              IOException {
		dao = new MemberDaoImpl();
//		throws 로 받아와서 예외 처리 필요
//		또 던짐
	}
	
	

//	회원 추가
	@Override
	public boolean addMember(String name, String phone) throws IOException {
//		1) 회원 목록을 얻어와 휴대폰 번호 중복 검사
		
		List<Member> memberList = dao.getMemberList();
		
//		중복 검사
		for (Member member : memberList) {
			if (member.getPhone().equals(phone)) {
				return false;
			}
		}
		
		Member member = new Member(name, phone, 0, Member.COMMON);
		
//		boolean result = dao.addMember(member);
		
		return dao.addMember(member);
		
	}
	
	
//	dao 에서 조회한 memberList를 그대로 반환
//	(해당 서비스 메서드는 따로 처리한 조건 / 기능이 없어서 
//	중간에서 전달만 해주는 역할
//	* view 에서 dao를 선언하지 않음
	@Override
	public List<Member> getMemberList() {
		return dao.getMemberList();
	}	
}





















