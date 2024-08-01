package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import dto.Member;
import service.MemberService;
import service.MemberServiceImpl;

// View : 사용자에게 보여지는 역할을 하는 클래스/ 객체
// - 보여줄 화면을 출력 / 필요한 데이터를 입력
public class MemberView {
	
	private MemberService  service = null;
	private BufferedReader br      = null;
	
	
//	기본 생성자
	public MemberView() {
		
		try {
//			객체 생성 중 발생한 예외를 View 에 모아서 처리
			service = new MemberServiceImpl();
			
//			키보드를 입력 받기 위한 스트림 생성
			br = new BufferedReader(new InputStreamReader(System.in));
			
		} catch (Exception e) {
			System.out.println("*** 프로그램 실행 중 오류 발생 ***");
			e.printStackTrace();
			
			System.exit(0);		// 프로그램 종료
			
		} 
	}
	
	
//	====================================================================================
//	[메인 메뉴]
	public void mainMenu() {
		
		int input = 0;
		
		do {
			try {
//				메뉴 출력 후 입력된 번호 input 에 반환
				input = selectMenu();
				
//				선택된 메뉴 번호에 따라 case 선택
				
				switch (input) {
				case 1 : addMember(); break;
				case 2 : selectAll(); break;
				case 3 : break;
				case 4 : break;
				case 5 : break;
				case 6 : break;
				case 0 : System.out.println("*** 프로그램 종료 ***"); break;
				default : System.out.println("### 메뉴에 작성된 번호만 입력 해주세요 ###");
				}
				
				System.out.println("============================================");
				
			} catch (NumberFormatException e) {
				
				System.out.println("\n### 숫자만 입력해주세요 ###\n");
				input = -1;	// 첫 반복에서 예외상황 발생시 종료되지 않도록
				
			} catch (IOException e) {
				
				System.out.println("### 입출력 관련 예외 발생 ###");
				e.printStackTrace();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		} while (input != 0);
	}
	
//	====================================================================================
//	[메인 출력/선택하는 메서드]
	private int selectMenu() throws NumberFormatException, IOException {
		
		System.out.println("\n============ 회원 관리 프로그램 ============\n");
		
		System.out.println("1. 회원 가입(추가)");
		System.out.println("2. 회원 전체 조회");
		System.out.println("3. 이름 검색(동명이인 있으면 모두 조회)");
		System.out.println("4. 특정 회원 사용 금액 누적하기");
		System.out.println("5. 회원 정보 수정");
		System.out.println("6. 회원 탈퇴");
		System.out.println("0. 종료");
		System.out.println("\n--------------------------------------------");
		

		System.out.print("메뉴 선택 >>> ");
		
//		readLine 은 문자열을 반환함 parseInt 사용
		int input = Integer.parseInt(br.readLine());
		System.out.println(); // 줄바꿈
		
		return input;
	}
	
// -------------------------------------------------------------------------------
//	[1] 회원 전체 조회
	private void addMember() throws IOException {
		System.out.println("\n----- 회원 가입 (추가) -----\n");
		
		System.out.print("이름                  : ");
		String name = br.readLine();
		
//		정상 입력(11 글자) 될때 까지 다시 입력 받기
		String phone = null;
		
		while (true) {
			System.out.print("휴대폰 번호('-' 제외) : ");
			phone = br.readLine();
			
			if (phone.length() != 11) {
				System.out.println("*** 다시 입력해주세요 ***\n");
				continue;
			}
			
			break;
		}
		
//		회원 추가 서비스 호출 후 결과 반환 받기
		
		boolean result = service.addMember(name, phone);
		
		if (result) {
			System.out.println("\n*** 회원이 추가되었습니다 ***\n");
		} else {
			System.out.println("\n### 중복되는 휴대폰 번호가 존재합니다 ###");
		}
		
	}
	
// -------------------------------------------------------------------------------
//	[2] 회원 전체 조회
	private void selectAll() {
		System.out.println("\n----- 회원 전체 조회 -----");
		
//		회원 목록을 조회해 반환하는 서비스 호출
		List<Member> memberList = service.getMemberList();
		
//		조회된 회원 목록이 없을 경우
//		MemberDaoImpl 생성자 코드에 의해 memberList는 null 이 될 수 없음
//		비어 있는지를 확인 하는 .isEmpty() 메서드 사용!!!!
		if (memberList.isEmpty()) {
			System.out.println("\n### 회원이 존재하지 않습니다 ###\n");
			return;
		}
		
		String[] gradeArr = {"일반", "골드", "다이아"};
		
		System.out.printf("%-7s %-7s %6s %5s \n",
				"[이름]", "[휴대폰 번호]", "[누적금액]", "[등급]");
		
		System.out.println("-------------------------------------------");
		
		for (Member member : memberList) {
			System.out.printf("%-6s| %-12s| %8d | %5s \n", 
					member.getName(), member.getPhone(), member.getAmount(), gradeArr[member.getGrade()]);
		}
		
		System.out.println(memberList);
		
	}
	
}


























