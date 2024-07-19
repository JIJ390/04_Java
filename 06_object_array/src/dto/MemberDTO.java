package dto;

// DTO (Data Transfet Object) : 데이터 전달용 객체
// - 전달될 데이터를 묶어서 관리하는 객체

public class MemberDTO {
	
	// 필드
	private String memberId;
	private String memberPw;
	private String memberName;
	private int    memberAge;
	
	// 생성자 
	public MemberDTO() {} // 기본 생성자 (매개변수 없음!)

	// [이클립스의 생성자 자동완성 기능]
	// alt + shift + s -> 컨텍스트 메뉴에서
	// Generate	Constructor Using Fields... 선택 (단축키 o)
	
	public MemberDTO(String memberId, String memberPw, String memberName, int memberAge) {
		
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberAge = memberAge;
	}

	// Generate Getters and Setters... 선택 (단축키 r)
	
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}
	
	
	public void inform() {
		System.out.println("\n--------------------------");
		System.out.println("memberId   : " + memberId);
		System.out.println("memberPw   : " + memberPw);
		System.out.println("memberName : " + memberName);
		System.out.println("memberAge  : " + memberAge);
		System.out.println("--------------------------\n");
	}
	
}












