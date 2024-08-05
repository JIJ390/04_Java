package run;

import view.MemberView;

// run : 실행용 클래스
public class MemberRun {
	public static void main(String[] args) {
		MemberView view = new MemberView();
		
		view.mainMenu();
		
		
/* 프로그램 실행할 때 저장된 멤버리스트를 불러옴
 * 
 * 회원을 추가하면 멤버리스트에 멤버가 늘어나고 그걸 다시 dat 에 저장
 * 
 * 프로그램 종료하면 늘어난 멤버리스트가 dat에 남아있음
 * 
 * 다시 프로그램을 실행하면 회원이 추가된 멤버리스트를 불러옴
 * 
 */
	}
}

/*
*** 회원 관리 프로그램 ***

- 회원을 가입 시키고 관리하는 프로그램
- 사용한 금액에 따라 등급 조정
	일반   : ~ 100,000
	골드   : ~ 1,000,000
	다이아 : 초과

- 저장할 회원 정보
이름, 전화번호, 누적 금액, 등급

- 필요한 기능
1. 회원 가입(추가)
2. 회원 전체 조회
3. 이름 검색(동명이인 있으면 모두 조회)
4. 특정 회원 사용 금액 누적하기
	-> 이름으로 검색
	-> 동명이인 중 한 명만 선택
	-> 누적 금액 입력 받아 수정
	-> 누적된 금액에 따라서 자동으로 등급 조정

5. 회원 정보 수정
	-> 이름으로 검색
	-> 동명이인 중 한 명만 선택
	-> 정보(전화번호)를 입력 받아 수정

6. 회원 탈퇴
	-> 이름, 전화번호 입력 받기
	-> 일치하는 회원이 있으면
	   정말 탈퇴할 것인지 한번 더 확인

7. 종료
	- 변화된 데이터는 항상 파일로 저장
	- 프로그램 실행 시 저장된 회원 목록 읽어오기(입력)

*/



