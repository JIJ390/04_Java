package condition.ex;

import java.util.Scanner;

/**
 * 조건문 예시 기능용 클래스
 */
public class ConditionEx {
	
	// 필드(field) == 멤버 변수 == 인스턴스 변수(전역 변수 유사?)
	Scanner sc = new Scanner(System.in);
	// Scanner 템플릿으로 임포트 바로 가져올 수 있음
	

	/**
	 * 1 ~ 10 사이 난수가 짝수인지 홀수인지 출력
	 */
	public void method1() {
		
		int ran = (int) (Math.random() * 10 + 1);
		
		if (ran % 2 != 1) {
			System.out.println("짝수입니다.");
		} else {
			System.out.println("홀수입니다");
		}
		
	}
	
	/**
	 * 나이를 입력 받아 
	 * 13 세 이하 : 어린이
	 * 14 세 이상 19 세 이하 : 청소년
	 * 20 세 이상 : 성인
	 */
	public void method2() {
		
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();		// 필드 sc 이용
		String result;

		if (age <= 13) {
			result = "어린이";
		} else if (age <= 19) {
			result = "청소년";
		} else {
			result = "성인";
		}
		
		System.out.println(result);
	}
	
	/**
	 * 나이를 입력 받아 
	 * 13 세 이하 : 어린이
	 * 14 세 이상 19 세 이하 : 청소년
	 * 	- 14 ~ 16 : 청소년 (중)
	 * 	- 14 ~ 16 : 청소년 (고)
	 * 20 세 이상 : 성인
	 * 0 d이하 또는 100 초과 : 잘못 입력하셨습니다
	 * 
	 */
	public void method3() {
		
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();		// 필드 sc 이용
		String result;
		
		if (age <= 0 || age > 100)  result = "잘못 입력하셨습니다.";
		else if (age <= 13) 		result = "어린이";
		else if (age <= 16)			result = "청소년(중)";
		else if (age <= 19) 		result = "청소년(고)";
		else 						result = "성인";

//	삼항연산자 사용시
//	else if (age <= 19) result = "청소년" + ((age <= 16) ? "(중)" : "(고)"); 
		
		System.out.println(result);
		
	}
	
	/** [switch 를 이용한 메서드 호출] 
	 */
	public void displayMenu() {
		
		System.out.println("1. method1() - 난수 홀짝");
		System.out.println("2. method2() - 나이 구분1");
		System.out.println("3. method3() - 나이 구분2");
		System.out.println("4. method4() - 계절 찾기");
		System.out.println("5. method5() - 성적 산출");
		
		System.out.print("번호 선택 : ");
		int num = sc.nextInt();
		
		System.out.println("======================");
		
		switch (num) {
		case 1 : method1(); break;	// 1 입력 시 method1() 호출
		case 2 : method2(); break;
		case 3 : method3(); break;
		case 4 : method4(); break;
		case 5 : method5(); break;
		default : System.out.println("잘못 입력 하셨습니다.");
		}
		
	}
	
	
	/**
	 * 입력된 달(월) 의 계절 출력하기
	 */
	public void method4() {
		
		System.out.print("월 입력 : ");
		int month = sc.nextInt();
		
		String result;
		
		switch (month) {
		
		// case 를 연속해서 작성하는 방법
		// 1) 세로로 
		case 3 :
		case 4 : 
		case 5 : result = "봄"; break; 
		// 2) 가로로
		case 6 : case 7 : case 8 : result = "여름"; break;
		// 3) case 값, 값, 값
		case 9, 10, 11 : result = "가을"; break;
		
		case 12, 1, 2 : result = "겨울"; break;
		
		default : result = "잘못 입력하셨습니다.";
		
		}	// switch end
		
		System.out.println(result);
		
	}
	
	/** [성적 판별기]
	 * 중간고사, 기말고사, 과제 점수를 입력 받아 성적 부여
	 * - 중간고사 (40%), 기말고사 (50%), 과제 (10%)
	 * - 입력 시 각각 100점 만점으로 입력 받음
	 * - 합산된 점수에 따라 성적 부여
	 * 
	 * 95 이상 : A+
	 * 90 이상 : A
	 * 85 이상 : B+
	 * 80 이상 : B
	 * 75 이상 : C+
	 * 70 이상 : C
	 * 65 이상 : D+
	 * 60 이상 : D
	 * 나머지  : F
	 * 
	 * [이름] : 홍길동
	 * 중간 고사 점수(40%) : 100
  	 * 기말 고사 점수(50%) : 80
	 * 과제 점수(10%) : 50
	 * 
	 * 최종 점수 : 85 점
	 * 성적 : B+
	 */
	public void method5() {
		
		System.out.print("이름 입력 : ");
		sc.nextLine();
		String name = sc.nextLine();
		
		System.out.print("중간 고사 점수 입력 : ");
		double middleScore = sc.nextDouble();
		
		System.out.print("기말 고사 점수 입력 : ");
		double finalScore = sc.nextDouble();
		
		System.out.print("과제 점수 입력 : ");
		double reportScore = sc.nextDouble();
		
		double averageScore = middleScore * 0.4 + finalScore * 0.5 + reportScore * 0.1;
		
		String grade;
		
//		if (averageScore >= 90) grade = averageScore >= 95 ? "A+" : "A";
//		else if (averageScore >= 80) grade = averageScore >= 85 ? "B+" : "B";
//		else if (averageScore >= 70) grade = averageScore >= 75 ? "C+" : "C";
//		else if (averageScore >= 60) grade = averageScore >= 65 ? "D+" : "D";
//		else grade = "F";
		
//		switch ((int)(averageScore / 5)) {
//		case 20, 19 : grade = "A+"; break;
//		case 18 : grade = "A";  break;
//		case 17 : grade = "B+"; break;
//		case 16 : grade = "B";  break;
//		case 15 : grade = "C+"; break;
//		case 14 : grade = "C";  break;
//		case 13 : grade = "D+"; break;
//		case 12 : grade = "D";  break;
//		default : grade = "F";
//		}
		
		// switch 문 () 에 들어갈 수 있는 값은 int, String
		switch ((int)(averageScore / 10)) {
		case 10, 9 : grade = "A" ; break;
		case 8     : grade = "B" ;  break;
		case 7     : grade = "C" ;  break;
		case 6     : grade = "D";  break;
		default    : grade = "F";
		}
		// 1 의 자리가 5 이상인 값들만 '+' 추가
		if (averageScore > 60 && (averageScore % 10 >= 5)) grade += "+";
		
		System.out.println();
		System.out.println("==================");
		System.out.println("이름               : " + name);
		System.out.println("중간고사 성적(40%) : " + (int)middleScore);
		System.out.println("기말고사 성적(50%) : " + (int)finalScore);
		System.out.println("과제 성적(10%)     : " + (int)reportScore);
		System.out.println();
		System.out.printf ("종합 성적          : %.1f \n", averageScore);
		System.out.println("학점               : " + grade);
		
	}
	
	
	/**[연습 문제]
	 * 국어, 영어, 수학, 사탐, 과탐 점수를 입력 받아
	 * 40점 미만 과목이 있으면 FAIL
	 * 평균이 60점 미만인 경우도 FAIL
	 * 모든 과목 40점 이상, 평균 60점 이상인 경우 PASS
	 * 
	 *  [출력 예시]
	 * 점수 입력(국 영 수 사 과) : 100 50 60 70 80
	 * 
	 * 1) 40점 미만 과목이 존재하는 경우
	 * FAIL [40점 미만 과목 : 국어 영어]
	 * 
	 * 
	 * 2) 평균 60점 미만인 경우
	 * FAIL [점수 : 50.4 (평균 미달)]
	 * 
	 * 3) PASS인 경우
	 * PASS [점수 : 83.4 / 100]
	 */
	public void practice() {
		System.out.print("점수 입력(국 영 수 사 과) : ");
		double kor = sc.nextDouble();	// 국
		double eng = sc.nextDouble();	// 영
		double mat = sc.nextDouble();	// 수 , nextInt 는 띄어쓰기, 엔터 전부
		double soc = sc.nextDouble();	// 사 , 입력이 종료된 것으로 인식
		double sci = sc.nextDouble();	// 과 
		
		String str ="";
		double averageScore = (kor + eng + mat + soc + sci) / 5;
		
		if (kor < 40) str += "국어 ";
		if (eng < 40) str += "영어 ";
		if (mat < 40) str += "수학 ";
		if (soc < 40) str += "사회 ";
		if (sci < 40) str += "과학 ";
		
		if (kor < 40 || eng < 40 || mat < 40 || soc < 40 || sci < 40) {
			System.out.printf("FAIL [40 점 미만 과목 : %s]", str);
		} else if (averageScore < 60) {
			System.out.printf("FAIL [점수 : %.1f (평균 미달)]", averageScore);
		} else {
			System.out.printf("PASS [점수 : %.1f ]", averageScore);
		}
		
	}
	
}
