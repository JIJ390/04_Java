package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import dto.Member;
import service.MemberService;
import service.MemberServiceImpl;

public class MemberView {
	private MemberService service = null;
	private BufferedReader     br = null;
	
	public MemberView() {
		try {
			
			service = new MemberServiceImpl();
			br = new BufferedReader(new InputStreamReader(System.in));
			
		} catch (Exception e) {
			System.out.println("*** 프로그램 실행 중 오류 발생 ***");
			e.printStackTrace();
			System.exit(0);
		} 
	}
	
	public void mainMenu() {
		
		int input = 0;
		
		do {
			try {
				input = selectmenu();
				
				switch (input) {
				case 1 : addMember();    break;
				case 2 : selectAll();    break;
				case 3 : selectName();   break;
				case 4 : plusAmount();   break;
				case 5 : reInform();     break;
				case 6 : removeMember(); break;
				case 0 : System.out.println("*** 프로그램 종료 ***"); break;
				default : System.out.println("### 메뉴에 작성된 번호만 입력 해주세요 ###");
				}
				
				System.out.println("============================================");

				
			} catch (NumberFormatException e) {
				System.out.println("\n### 숫자만 입력해 주세요 ###\n");
				input = -1;
			} catch (IOException e) {
				e.printStackTrace();
			} 
			
		} while (input != 0); 
	}
	
	
	private int selectmenu() throws NumberFormatException, IOException {
		
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
	
		return Integer.parseInt(br.readLine());
	}
	
	private void addMember() throws IOException {
		System.out.println("\n----- 회원 가입 (추가) -----\n");
		System.out.print("이름 : ");
		String name = br.readLine();
		String phone = null;
		
		while (true) {
			System.out.print("전화 번호('-' 제외) : ");
			phone = br.readLine();
			
			if (phone.length() == 11) break;
			
			System.out.println("*** 다시 입력해주세요 ***\n");
		}

		boolean result = service.addMember(name, phone);
		
		if (result) {
			System.out.println("\n*** 회원이 추가되었습니다 ***\n");
		} else {
			System.out.println("\n### 중복되는 휴대폰 번호가 존재합니다 ###");
		}
		
	}
	
	private void selectAll() {
		System.out.println("\n----- 회원 전체 조회 -----");
		
		List<Member> memberList = service.getMemberList();
		
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
	
	private void selectName() throws IOException {
		System.out.println("\n----- 회원 이름 조회 -----");
		
		List<Member> memberList = service.getMemberList();
		
		if (memberList.isEmpty()) {
			System.out.println("\n### 회원이 존재하지 않습니다 ###\n");
			return;
		}
		
		System.out.print("조회할 이름 입력 : ");
		String name = br.readLine();
		
		boolean flag = false;
		
		String[] gradeArr = {"일반", "골드", "다이아"};
		
		System.out.printf("%-7s %-7s %6s %5s \n",
				"[이름]", "[휴대폰 번호]", "[누적금액]", "[등급]");
		
		for (Member member : memberList) {
			if (member.getName().equals(name)) {
				System.out.printf("%-6s| %-12s| %8d | %5s \n", 
						member.getName(), member.getPhone(), member.getAmount(), gradeArr[member.getGrade()]);
				flag = true;
			}
		}
		
		if (!flag) System.out.println("### 이름이 일치하는 회원이 존재하지 않습니다 ###");
	}
	
	
	
	private void plusAmount() throws IOException {
		System.out.println("\n----- 사용 금액 누적 -----");
		
		List<Member> memberList = service.getMemberList();
		
		if (memberList.isEmpty()) {
			System.out.println("\n### 회원이 존재하지 않습니다 ###\n");
			return;
		}
		
		System.out.print("회원 이름 입력 : ");
		String name = br.readLine();
		String phone = null;
		
		int checkName = 0;
		
		for (Member member : memberList) if (member.getName().equals(name)) {
			phone = member.getPhone();
			checkName++;
		}
		
		System.out.println();
		
		if (checkName == 0) {
			System.out.println("### 일치하는 회원이 존재하지 않습니다 ###");
			return;
		} else if (checkName == 1) {
			System.out.println("일치하는 회원이 1 명 존재합니다");
		} else {
			
			System.out.printf("일치하는 회원이 %d 명 존재합니다\n", checkName);
			System.out.println("정확한 확인을 위해 전화 번호를 입력해 주세요\n");
			
			while (true) {
				System.out.print("전화 번호 입력 ('-' 제외) : ");
				phone = br.readLine();
				
				if (phone.length() == 11) break;
				
				System.out.println("*** 다시 입력해주세요 ***\n");
			}
			
			System.out.println();
			
			boolean flag = false;
			
			for (Member member : memberList) {
				if (member.getName().equals(name) && member.getPhone().equals(phone)) flag = true;
			}
			
			if (flag) {
				System.out.println("확인되었습니다");
			
			} else {
				System.out.println("### 일치하는 회원이 존재하지 않습니다 ###");
				return;
			}
		}
		
		System.out.println();
		
		System.out.print("사용 금액 입력 : ");
		int price = Integer.parseInt(br.readLine());
				
		boolean result = service.plusAmount(phone, price);
		
		if (result) System.out.println("*** 금액이 누적 되었습니다 ***");
		else	    System.out.println("### 금액 누적 실패 ###");
		

	}
	
	
	private void reInform() throws IOException {
		System.out.println("\n----- 사용 금액 누적 -----");
		
		List<Member> memberList = service.getMemberList();
		
		if (memberList.isEmpty()) {
			System.out.println("\n### 회원이 존재하지 않습니다 ###\n");
			return;
		}
		
		System.out.print("회원 이름 입력 : ");
		String name = br.readLine();
		String phone = null;
		
		int checkName = 0;
		
		for (Member member : memberList) if (member.getName().equals(name)) {
			phone = member.getPhone();
			checkName++;
		}
		
		System.out.println();
		
		if (checkName == 0) {
			System.out.println("### 일치하는 회원이 존재하지 않습니다 ###");
			return;
		} else if (checkName == 1) {
			System.out.println("일치하는 회원이 1 명 존재합니다");
		} else {
			
			System.out.printf("일치하는 회원이 %d 명 존재합니다\n", checkName);
			System.out.println("정확한 확인을 위해 전화 번호를 입력해 주세요\n");
			
			while (true) {
				System.out.print("전화 번호 입력 ('-' 제외) : ");
				phone = br.readLine();
				
				if (phone.length() == 11) break;
				
				System.out.println("*** 다시 입력해주세요 ***\n");
			}
			
			System.out.println();
			
			boolean flag = false;
			
			for (Member member : memberList) {
				if (member.getName().equals(name) && member.getPhone().equals(phone)) flag = true;
			}
			
			if (flag) {
				System.out.println("확인되었습니다");
			
			} else {
				System.out.println("### 일치하는 회원이 존재하지 않습니다 ###");
				return;
			}
		}
		
		System.out.println();
		
		System.out.println("변경하려는 이름과 전화 번호를 입력해 주세요\n");
		System.out.println("이름 입력 : ");
		String reName = br.readLine();
		
		String rePhone = null;
		
		while (true) {
			System.out.print("전화 번호('-' 제외) : ");
			rePhone = br.readLine();
			
			if (rePhone.length() == 11) break;
			
			System.out.println("*** 다시 입력해주세요 ***\n");
		}
		
		boolean result = service.reInform(reName, rePhone, name, phone);
		
		if (result) System.out.println("회원 정보가 수정되었습니다");
		else 	    System.out.println("### 회원 정보 수정 실패 ###");
		
	}
	
	
	private void removeMember() throws IOException {
		System.out.println("\n----- 회원 탈퇴 -----\n");
		
		List<Member> memberList = service.getMemberList();
		
		if (memberList.isEmpty()) {
			System.out.println("\n### 회원이 존재하지 않습니다 ###\n");
			return;
		}
		
		System.out.print("이름 : ");
		String name = br.readLine();
		String phone = null;
		
		while (true) {
			System.out.print("전화 번호('-' 제외) : ");
			phone = br.readLine();
			
			if (phone.length() == 11) break;
			
			System.out.println("*** 다시 입력해주세요 ***\n");
		}
		
		boolean flag = false;
		
		for (Member member : memberList) {
			if (member.getName().equals(name) && member.getPhone().equals(phone)) flag = true;
		}
		
		if (!flag) {
			System.out.println("### 일치하는 회원이 존재하지 않습니다 ###");
			return;
		}
		
		char choice;
		
		while (true) {
			System.out.println("정말 탈퇴하시겠습니까? ");
			System.out.print("[ Y / N ] : ");
			
			choice = br.readLine().charAt(0);
			choice = Character.toUpperCase(choice);
			
			if (choice == 'N') {
				System.out.println("*** 취소되었습니다 ***");
				return;
			}
			
			if (choice == 'Y') break;
			
			System.out.println("\n'Y', 'N' 만 입력해 주세요\n");
		} 
		
		
		
		boolean result = service.removeMember(name, phone, choice);
		
		if (result) System.out.println("탈퇴가 완료되었습니다");
		else 	    System.out.println("### 회원 탈퇴 실패 ###");
		
	}

}





























