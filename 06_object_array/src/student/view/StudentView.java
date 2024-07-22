package student.view;

import java.util.Scanner;

import student.dto.StudentDTO;
import student.service.StudentService;

// 콘솔창에 보여지는 용도
// == 클라이언트의 입력 / 출력을 담당하는 클래스
public class StudentView {
	
	private Scanner sc = new Scanner(System.in);
	
	private StudentService service = new StudentService();
	
	/**
	 * 메인 메뉴 출력
	 */
	public void mainMenu() {
		int input = 0;  // 입력 받은 메뉴 번호를 저장할 변수
		
		do {
			System.out.println("\n----- 학생 관리 프로그램 -----");
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 전체 조회");
			System.out.println("3. 학생 1명 정보 조회(인덱스)");
			System.out.println("4. 학생 이름으로 조회"); // 동명이인 X
			System.out.println("5. 학생 정보 수정(인덱스)");
			System.out.println("6. 학생 1명 점수 조회(점수, 합계, 평균)");
			System.out.println("7. 평균 최고점, 최저점 학생");
			System.out.println("0. 종료");
			
			System.out.print("메뉴 선택 >> ");
			
			input = sc.nextInt();
			sc.nextLine();
			
			System.out.println();
			
			switch (input) {
			case 1 : addStudent();  break;
			case 2 : allStudent();  break;
			case 3 : selectIndex(); break;
			case 4 : selectName();  break;
			case 5 : updateStudent(); break;
			case 6 : scoreStudent(); break;
			case 7 : break;
			case 0 : System.out.println("*** 프로그램 종료 ***"); return;
			default : System.out.println("*** 메뉴 번호 잘못 입력 ***");
			}
			
		} while(input != 0);
	}


	/**
	 * 학생 추가 화면
	 * 학번, 이름 성별을 입력 받아
	 * Student 객체로 만들어서 StudentService 로 전달!
	 * -> 추가 성공 시 true / 실패 시 false 반환 받아
	 * 	결과 출력
	 */
	private void addStudent() {
		System.out.println("\n----- 학생 추가 -----");
		
		System.out.print("학번 입력 : ");
		String studentNumber = sc.nextLine();
		
		System.out.print("이름 입력 : ");
		String name = sc.nextLine();
		
		System.out.print("성별 (남/여) : ");
		char gender = sc.next().charAt(0);
		
		// 학생 객체를 생성하여 입력 받은 데이터를 저장(세팅)
		
		StudentDTO std = new StudentDTO(studentNumber, name, gender);
	
		boolean result = service.addStudent(std);
		
		if (result) {
			System.out.println(name + " 학생이 추가되었습니다.");
		} else {
			System.out.println("더 이상 학생을 추가할 수 없습니다.");
		}
	
	}
	
	/**
	 * StudentService 에 있는 student 객체 배열을 얻어와 모든 학생 섲보를 출력
	 */
	private void allStudent() {
		
		System.out.println("\n----- 학생 전체 조회 -----\n");
		
			StudentDTO[] students = service.getStudents();
			
			for (StudentDTO std : students) {
				
				// null 인 경우 == 저장된 학생이 없을 때
				// -> NullPointerException 방지
				//   (참조변수가 null을 저장하고 있는데 사용하려고 할 때)
				if (std == null) return;
				
				System.out.println(std.toString());
				System.out.println("---------------------------------------");
		}
	}
	
	/**
	 * 인덱스를 입력 받아 service 에 전달하여 
	 * 해당 인덱스의 학생 객체 하나(studentDTO)를 반환 받아 출력
	 */
	private void selectIndex() {
		
		System.out.println("\n----- 학생 한 명 조회 -----\n");
		System.out.print("조회할 인덱스 입력 : ");
		int index = sc.nextInt();
		
		// service 메서드 호출 후 학생 1 명 정보 반환
		StudentDTO std = service.selectIndex(index);
		
		if (std == null) {
			System.out.println("*** 해당 인덱스에 학생 객체가 존재하지 않습니다. ***");
			return;
		}
		
		System.out.println(index + " 번째 학생 정보");
		System.out.println(std.toString());
		System.out.println("---------------------------------------");
		
	}
	
	private void selectName() {
		
		System.out.println("\n----- 학생 한 명 조회 -----\n");
		
		System.out.print("조회할 이름 입력 : ");
		String targetName = sc.nextLine();
		
		// 입력 받은 이름(targetName)을 서비스로 전달하여 
		// 일치하는 이름을 가진 학생 객체(주소 값) 반환 받기
		// -> null 또는 학생 객체(주소 값)
		
		StudentDTO std = service.selectName(targetName);
		
		if (std == null) {
			System.out.println("*** 해당 인덱스에 학생 객체가 존재하지 않습니다. ***");
			return;
		}
		
		System.out.println(targetName + " 학생 정보");
		System.out.println(std.toString());
		System.out.println("---------------------------------------");

	}
	
	private void updateStudent() {
		
		System.out.println("\n----- 학생 정보 수정 -----\n");
		
		System.out.print("수정할 학생 객체 인덱스 입력 : ");
		int index = sc.nextInt();
		sc.nextLine();
		
		System.out.print("수정할 학번 입력 : ");
		String studentNumber = sc.nextLine();
		
		System.out.print("수정할 이름 입력 : ");
		String name = sc.nextLine();
		
		System.out.print("수정할 성별 (남/여) : ");
		char gender = sc.next().charAt(0);
		
		StudentDTO std = service.updateStudent(index, studentNumber, name, gender);
		
		if (std == null) {
			System.out.println("*** 해당 인덱스에 학생 객체가 존재하지 않습니다. ***");
			return;
		}
		
		System.out.println("\n----- 수정되었습니다. ----\n");
		System.out.println(service.selectIndex(index).toString());
	

	}
	
	private void scoreStudent() {
		
		System.out.println("\n----- 학생 점수 조회 -----\n");
		
		System.out.print("조회할 인덱스 입력 : ");
		int index = sc.nextInt();
		
		String std = service.scoreStudent(index);
		
		System.out.println(service.selectIndex(index).toString());
		System.out.println(std);
		
	}
	
}
















