package method;

import java.util.Scanner;

// 기능 제공용 클래스
public class StudentService {
	
	// 필드
	// 이 클래스에서만 사용하는 스캐너 객체 sc 생성 매개변수[System.in] <- 키보드 의미
	private Scanner sc = new Scanner(System.in);
	
	/**
	 * 메인 메뉴 화면
	 * 
	 */
	public void mainMenu() {
		int input = 0; // 입력 받은 메뉴 번호를 저장할 변수
		
		// 생성된 학생 객체 주소를 저장할 참조 변수
		// (null : 참조하는 객체가 없다, 주소 저장 X)
		Student std = null;
		
		do {
			System.out.println("\n==== 학생 1 명 관리 프로그램 ====");
			System.out.println();
			System.out.println("1. 학생 등록");
			System.out.println("2. 학생 정보 확인");
			System.out.println("3. 학생 이름 수정");
			System.out.println("4. Java 공부하기");
			System.out.println("5. HTML 공부하기");
			System.out.println("0. 프로그램 종료");
			System.out.println();
			System.out.print("메뉴 번호 입력 : ");
			input = sc.nextInt();
			
			System.out.println();
			
			sc.nextLine(); // 입력 버퍼에 남아있는 엔터 제거
			
			switch (input) {
			case 1 : std = registStudent();
						System.out.println(std.getName() + " 학생 등록됨");
						break; 
						
			case 2 : System.out.println("[학생 정보 확인]");
						// static 은 클래스명을 붙여서 호출!!
						// std로 호출 시 이중으로 주소값 참조
						System.out.println("학교 : " + Student.schoolName);
						System.out.println(std.toString()); 
						break;
						
			case 3 :	// 학생 이름 수정 메서드 호출 시 
						// std 에 저장된 학생 객체 참조 주소 전달 (얕은 복사)
						updateName(std);
						break;
						
			case 4 : studyJava(std);
						break;
						
			case 5 : studyHtml(std);
						break;
			
			case 0 : System.out.println("=== 프로그램을 종료합니다. ==="); break;
				
			default : System.out.println("=== 알맞은 메뉴 번호를 입력해 주세요 ===");
			}
			
		} while (input != 0);	// 메뉴 번호 0 선택 시 반복 종료
	}
	
	/**
	 * 학생 등록 메서드
	 * @return 생성된 Student 객체의 주소 반환
	 */
	private Student registStudent() {
		
		System.out.println("[학생 등록]");
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("학번 : ");
		String studentNumber = sc.nextLine();
		
		System.out.print("성별(남/여) : ");
		char gender  = sc.next().charAt(0);
		
		Student student = new Student(name, studentNumber, gender);
		
		// student 변수에는 생성된 Student 객체를 참조하는 주소값이 담겨있다
		// -> 주소 값을 반환 (== 주소 값이 복사되어 호출한 곳으로 돌아감!
		return student;
	}
	
	/**
	 * 학생 이름 수정 메서드
	 */
	private void updateName(Student std) {
		
		System.out.println("[학생 이름 수정]");
		System.out.println("기존 이름   : " + std.getName());
		System.out.print("변경할 이름 : ");
		String newName = sc.nextLine();
		
		// 이름을 홍길동 -> 김철수 로 변경하시겠습니까?
		System.out.printf("이름을 %s -> %s 로 변경하시겠습니까? (y/n)\n",
								std.getName(), newName);
		
		// String.toUpperCase() -> 대문자로 변환
		// String.toLowerCase() -> 소문자로 변환
		char check = sc.next().toLowerCase().charAt(0);
		
		if (check == 'n') {
			System.out.println("이름 변경 취소됨");
			return;
		}
		
		// 'y' 가 입력된 경우
		std.setName(newName); // 새로운 이름을 std가 참조하는 객체에 세팅
		
		System.out.printf("이름이 %s 로 변경되었습니다.\n", std.getName());
	}
	
	/**
	 * 자바 공부 수행 -> std 의 자바 역량 변경
	 * 단, 수정된 자바 역량은 최대값(100), 최소값(0) 범위 초과 불가
	 * @param std
	 */
	public void studyJava(Student std) {
		
		System.out.println("[Java 공부하기]");
		System.out.println("현재 Java 역량 점수 : " + std.getJava());
		System.out.print("증가 또는 감소한 Java 역량 점수 입력 : ");
		
		int before = std.getJava();
		
		int score = sc.nextInt();
		
		// 기존 점수에 누적
		int temp = std.getJava() + score;	// 기존 점수 + 입력 점수
		
		if (temp > Student.MAX_VALUE) temp = Student.MAX_VALUE;
		if (temp < Student.MIN_VALUE) temp = Student.MIN_VALUE;
		
		std.setJava(temp); // 참조하고 있는 학생 객체 java 필드에 대입
		
		System.out.println("=== Java 역량 점수 수정 완료 ===");
		
		// 50 -> 80 (+30) 
		// 50 -> 30 (-20) 
		
		// 최대값 초과
		// 90 -> 100 (+30)
		// 10 -> 0   (-40)
		
		String str = (score <= 0) ? score + "" : "+" + score;
		// 삼항 연산자 
		
		System.out.printf("%d -> %d (%s)\n", before, std.getJava(), str);
		
	}
	
	/**
	 * HTML 공부하기
	 */
	public void studyHtml(Student std) {
		
		System.out.println("[HTML 공부하기]");
		int before = std.getHtml();
		
		System.out.println("현재 HTML 역량 점수 : " + std.getHtml());
		System.out.print("증가 또는 감소한 HTML 역량 점수 입력 : ");
		
		int score = sc.nextInt();
		
		int temp = std.getHtml() + score;	
		
		if (temp > Student.MAX_VALUE) temp = Student.MAX_VALUE;
		if (temp < Student.MIN_VALUE) temp = Student.MIN_VALUE;
		
		std.setHtml(temp); 
		
		System.out.println("=== HTML 역량 점수 수정 완료 ===");
		
		String str = (score <= 0) ? score + "" : "+" + score;
		
		System.out.printf("%d -> %d (%s)\n", before, std.getHtml(), str);
		
	}
}






























