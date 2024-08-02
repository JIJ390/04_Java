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
				case 1 : addMember();    break;
				case 2 : selectAll();    break;
				case 3 : selectName();   break;
				case 4 : updateAmount(); break;
				case 5 : updateMember(); break;
				case 6 : deleteMember(); break;
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
		
		
	}
	
	
// -------------------------------------------------------------------------------
//	[3] 회원 이름으로 조회	
	private void selectName() throws IOException {
		System.out.println("\n----- 회원 이름 조회(동명이인 포함) -----");
		
//		검색할 이름 입력 받기
		System.out.print("검색할 이름 입력 : ");
		String searchName = br.readLine();
		
		System.out.println();
		
//		이름 검색 서비스 호출 후 결과 반환 받기
		List<Member> searchList = service.selectName(searchName);
		
//		검색 결과 없음 / searchList 에 추가된 요소(이름 같음) 없음
		if (searchList.isEmpty()) {
			System.out.println("\n### 일치하는 회원이 존재하지 않습니다 ###\n");
			return;
		}
		
		String[] gradeArr = {"일반", "골드", "다이아"};
		
		System.out.printf("%-7s %-7s %6s %5s \n",
				"[이름]", "[휴대폰 번호]", "[누적금액]", "[등급]");
		
		System.out.println("-------------------------------------------");
		
		for (Member member : searchList) {
			System.out.printf("%-6s| %-12s| %8d | %5s \n", 
					member.getName(), member.getPhone(), member.getAmount(), gradeArr[member.getGrade()]);
		}
		
	}
	
	
// -------------------------------------------------------------------------------
//	[4] 사용 금액 누적하기
	private void updateAmount() throws IOException {
		System.out.println("\n----- 특정 회원 사용 금액 누적하기 -----");
		
		System.out.print("회원 이름 입력 : ");
		String targetName = br.readLine();
		
		System.out.println();
		
		List<Member> searchList = service.selectName(targetName);
		
		if (searchList.isEmpty()) {
			System.out.println("\n### 일치하는 회원이 존재하지 않습니다 ###\n");
			return;
		}
		
//		금액 증가 대상 회원만 참조할 Member 참조 변수 선언
		Member target = null;
		
		
//		1) 동명이인이 있을 경우
//			-> 이름 / 전화번호를 출력해서 한 명만 선택하게 함
		if (searchList.size() > 1) {
			
			System.out.println("\n*** 대상 회원을 선택해 주세요 ***\n");
			System.out.println("-------------------------------------------");
			
//			* index 활용
			for (int i = 0; i < searchList.size(); i++) {
				System.out.printf("%d) %s (%s) \n", 
								i + 1, 
								searchList.get(i).getName(),  
								searchList.get(i).getPhone());
			}
			
			System.out.print("\n선택할 회원의 번호를 입력 : ");
			int input = Integer.parseInt(br.readLine()) - 1;
			
//			입력된 번호가 searchList 의 index 번호를 초과한 경우
			if (input > searchList.size() || input < 0) {
				System.out.println("\n### 없는 회원 번호입니다. 다시 시도해 주세요 ###\n");
				return;
			}
			
//			타겟에 회원 저장
			target = searchList.get(input);
			
		} else {
			// 2) 동명이인이 없을 경우
			target = searchList.get(0);
		}
		
		System.out.print("누적할 금액 입력 : ");
		int acc = Integer.parseInt(br.readLine());
		
//		대상 회원, 누적할 금액을 서비스로 전달
//		- 금액 누족
//		- 등급 조정
//		- 파일에 데이터 저장

//		서비스에서 반환 받은 문자열
//		ex ) 신짱구 회원 님의 누적 금액
//			 2000 -> 10000
//			* 골드 * 등급으로 변경되셨습니다
		
		String result = service.updateAmount(target, acc);
		
		System.out.println(result);
	}
	
// -------------------------------------------------------------------------------
// [5] 회원 정보 수정
	/* 
     * 수정할 회원 이름 입력 : 홍길동
     *
     * 수정할 전화번호 입력 : 01044445555
     * 
     * 홍길동님의 전화번호가 변경 되었습니다
     * 01012341234 -> 01044445555
	 * 
	 * 
	 */
	private void updateMember() throws IOException {
		System.out.println("\n----- 회원 정보 수정 -----");
		
		System.out.print("수정할 회원 이름 입력 : ");
		String targetName = br.readLine();
		
		System.out.println();
		
		List<Member> searchList = service.selectName(targetName);
		
		if (searchList.isEmpty()) {
			System.out.println("\n### 일치하는 회원이 존재하지 않습니다 ###\n");
			return;
		}
		
		Member target = null;
		
		if (searchList.size() > 1) {
			
			System.out.println("\n*** 대상 회원을 선택해 주세요 ***\n");
			System.out.println("-------------------------------------------");
			
			for (int i = 0; i < searchList.size(); i++) {
				System.out.printf("%d) %s (%s) \n", 
								i + 1, 
								searchList.get(i).getName(),  
								searchList.get(i).getPhone());
			}
			
			System.out.print("\n선택할 회원의 번호를 입력 : ");
			int input = Integer.parseInt(br.readLine()) - 1;
			
			if (input > searchList.size() || input < 0) {
				System.out.println("\n### 없는 회원 번호입니다. 다시 시도해 주세요 ###\n");
				return;
			}
			
			target = searchList.get(input);
			
		} else {
			target = searchList.get(0);
		}
		
		String phone = null;
		
		while (true) {
			
			System.out.print("수정할 전화 번호 입력 : ");
			phone = br.readLine();
			
			if (phone.length() == 11) break;
			
			System.out.println("*** 다시 입력해주세요 ***\n");
			
		}
		
		String result = service.updateMember(target, phone);
		
		System.out.println();
		System.out.println(result);
		
	}
	
// -------------------------------------------------------------------------------
// [6] 회원 탈퇴
	
	private void deleteMember() throws IOException {
		System.out.println("\n----- 회원 탈퇴 -----");
		
		System.out.print("회원 이름 입력 : ");
		String targetName = br.readLine();
		
		System.out.println();
		
		List<Member> searchList = service.selectName(targetName);
		
		if (searchList.isEmpty()) {
			System.out.println("\n### 일치하는 회원이 존재하지 않습니다 ###\n");
			return;
		}
		
		Member target = null;
		
		if (searchList.size() > 1) {
			
			System.out.println("\n*** 대상 회원을 선택해 주세요 ***\n");
			System.out.println("-------------------------------------------");
			
			for (int i = 0; i < searchList.size(); i++) {
				System.out.printf("%d) %s (%s) \n", 
								i + 1, 
								searchList.get(i).getName(),  
								searchList.get(i).getPhone());
			}
			
			System.out.print("\n선택할 회원의 번호를 입력 : ");
			int input = Integer.parseInt(br.readLine()) - 1;
			
			if (input > searchList.size() || input < 0) {
				System.out.println("\n### 없는 회원 번호입니다. 다시 시도해 주세요 ###\n");
				return;
			}
			
			target = searchList.get(input);
			
		} else {
			target = searchList.get(0);
		}
		
		char input;
		
		while (true) {
			System.out.print("정말 탈퇴 처리 하시겠습니까? [Y/N] : ");
			input = br.readLine().toUpperCase().charAt(0);
			
			if (input == 'N') {
				System.out.println("### 탈퇴 취소 ###");
				return;
			}
			
			if (input == 'Y') break;
			
			System.out.println("\n(Y/N) 만 입력해 주세요\n");
		}
		
		String result = service.deleteMember(target);	
		
		System.out.println();
		System.out.println(result);

	}
	
}


























