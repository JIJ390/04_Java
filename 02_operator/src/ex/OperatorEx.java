package ex;

import java.util.Scanner;

/*
 *  예제 기능용 클래스
 */
public class OperatorEx {
	// OperatorRun 에서
	// 호출할 수 있는 기능을 정의해두는 클래스
	// 자바는 역할분담을 중시하는 언어
	
	// method == 객체(클래스) 가 가지고 있는 기능(functuion)
	
	// test1() 메서드
	public void test1()	{
		System.out.println("test1() 메서드 호출됨");
	}
	
	public void test2()	{
		System.out.println("2222222222222222");
	}
	
	/**
	 * 입력 받은 두 정수의 산술 연산 결과 출력하기 
	 * 
	 * 정수 입력 1 : 10
	 * 정수 입력 2 : 13
	 * 
	 * 10 + 3 = 13
	 * 10 - 3 = 7
	 * 10 * 3 = 30
	 * 10 / 3 = 3
	 * 10 % 3 = 1
	 */
	public void method1() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 1 : ");
		int num1 = sc.nextInt();	// 입력 버퍼에 있는 다음 정수 읽어오기
									// (정수만, 엔터 남음)
		System.out.print("정수 입력 2 : ");
		int num2 = sc.nextInt();
		
		System.out.println();	// 줄 바꿈
		
		// \n : 개행 (escape 문자)
		System.out.printf("%d + %d = %d \n", num1, num2, (num1 + num2));
		System.out.printf("%d - %d = %d \n", num1, num2, (num1 - num2));
		System.out.printf("%d * %d = %d \n", num1, num2, (num1 * num2));
		System.out.printf("%d / %d = %d \n", num1, num2, (num1 / num2));
		System.out.printf("%d %% %d = %d \n", num1, num2, (num1 % num2));
		// printf 에서 %% == '%'
		
	}
	
	/**
	 * 입력 받은 정수가 3 의 배수가 맞는지 확인
	 */
	public void method2() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		// input 이 3 의 배수가 맞으면 true, 아니면 false 저장
		boolean isTrue = input % 3 == 0;
		// java 에서는 자료형이 정해져 있기 때문에 type을 비교하는 ===는 사용하지 않음
		
		System.out.printf("%d 는 3 의 배수인가? %b", input, isTrue);
	}
	
	
	/**
	 * 첫 번째 입력 받은 수가 
	 * 두 번째 입력 받은 수의 배수가 맞는지 확인
	 * 
	 * [true인 경우]
	 * 첫 번째 입력 : 20
	 * 두 번째 입력 : 5
	 * 20 은 5 의 배수가 맞는가? true
	 * 
	 * [false인 경우]
	 * 첫 번째 입력 : 9
	 * 두 번째 입력 : 4
	 * 9는 4의 배수가 맞는가? false
	 */
	public void method3() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 입력 : ");
		int num1 = sc.nextInt();
		
		System.out.print("두 번째 입력 : ");
		int num2 = sc.nextInt();
		
		boolean isTrue = (num1 % num2 == 0);
		
		System.out.printf("%d 는 %d 의 배수가 맞는가? : %b", num1, num2, isTrue);
		
	}
	
	/**
	 * 생성된 난수가 1 이상 10 이하 짝수가 맞는지 확인
	 * (난수 범위 1 ~ 20)
	 */
	public void method4() {
							// 0 ~ 0.9... => 1.0 ~ 20.9...
		int randomNumber = (int)(Math.random() * 20 + 1);
		
		System.out.println("생성된 난수 : " + randomNumber);
		boolean result1 = randomNumber >= 1 && randomNumber <= 10;
		boolean result2 = randomNumber % 2 == 0;
		
		System.out.println("생성된 난수가 1 이상 10 이하 짝수가 맞는가? " + (result1 && result2));
	}
	
	/**
	 * 입력받은 수가 짝수 이거나 
	 * 10 보다 큰 수(초과) 인지 확인
	 */
	public void method5() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 입력 : ");
		int input = sc.nextInt();
		
		boolean result1 = input % 2 == 0;
		boolean result2 = input > 10;
		
		System.out.printf("%d 는 10 보다 크고 짝수인가? %b", input, result1 && result2);
	}
	
	/** [삼항 연산자 1]
	 * 1 ~ 10 사이 난수 발생
	 * 홀짝 검사
	 */
	public void method6() {
		
		// 1 ~ 10 사이 난수
		int ran = (int) (Math.random() * 10 + 1);
		
		String result = (ran % 2 == 0) ? "짝수" : "홀수";
		
		System.out.printf("%d 는 %s", ran, result);
	}
	
	
	/**	[삼항 연산자 2]
	 * 나이를 입력 받아
	 * 13 세 이하면 "어린이"
	 * 14 세 이상 19 세 이하 "청소년"
	 * 20 세 이상 "성인"
	 * 출력
	 */
	public void method7() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		String result = (age <= 13) ? "어린이" : (age >= 20 ? "성인" : "청소년");
		
		System.out.println(result);
		
	}
	
}
















