package ex;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx1 {
	
	Scanner sc = new Scanner(System.in);

	/* Java 배열 (자료구조)
	 * 
	 * - 같은 자료형 변수를 하나의 묶음으로 다루는 것
	 * 
	 * - 생성된 배열의 요소(묶어진 배열) 는 
	 * 	 인덱스 번호로 구분된다! (index 는 0 부터 시작)
	 * 
	 * - 생성도니 배열을 활용하기 위해서는
	 * 	 배열을 참조하는 "참조형 변수" 를 이용한다!
	 * 
	 * [참조형 변수]
	 * - 값 X, 주소를 저장하는 변수
	 * 
	 * - 변수 호출 시 값을 반환 X
	 *   -> 저장된 주소로 찾아가 해당 위치의 배열/ 객체를 참조
	 *   
	 * - 기본 자료형 8개를 제외한 나머지는 모두 참조형!
	 */
	
	/**
	 * 배열 선언 할당 초기화 
	 */
	public void method1() {
		// 배열 선언
		int[] arr;			// Stack 메모리 영역에
							// int[] 자료형을 참조할 변수 arr을 선언
		// 배열 할당
		arr = new int[4];	// Heap 메모리 영역에 
							// int 4칸 짜리 배열을 할당(생성) 한 후
							// 생성된 배열의 주소를 arr 에 대입
							
							// -> arr 변수를 이용해 생성된 배열을 참조할 수 있다!
		
		// 배열 초기화
		// -> 배열 요소에 값을 대입
		
		// 1) 배열을 생성 하자마자
		//    각 칸에는 무슨 값이 저장되어 있을까?
		//	  -> 각 자료형의 기본 값이 저장되어 있음!!
		//	  -> int : 0 / double : 0.0 / long : 0L
		// 		 float : 0.0f / char : '\u0000' /boolean : false
		System.out.println(arr);	// 배열의 해시코드(유사 주소)

		System.out.println("arr[0] : " + arr[0]);	// 0
		System.out.println("arr[1] : " + arr[1]);	// 0
		System.out.println("arr[2] : " + arr[2]);	// 0
		System.out.println("arr[3] : " + arr[3]);	// 0
		
		// 2) index 별로 값 초기화
		arr[0] = 1004;
		arr[1] = 120;
		arr[2] = 10;
		arr[3] = 00101;
		
		for (int i = 0; i < 4; i++) {
			System.out.printf("arr[%d] 의 값 : %d \n", i, arr[i]);
		}
		
		// --------------------------------------------
		/* Java 의 배열은 크기 조절 X */
		
		arr = new int[5];
		arr[4] = 999;
	  // ArrayIndexOutOfBoundsException : 배열 인덱스 범위 초과 예외
		
		for (int i = 0; i < 5; i++) {
			System.out.printf("arr[%d] 의 값 : %d \n", i, arr[i]);
		}
	}
	
	/**
	 * 정수 4개를 입력 받아 
	 * 배열 요소에 차례대로 대입 후
	 * 저장된 값 한번에 출력하기  
	 */
	public void method2() {
		
		// 정수 4칸짜리 배열을 생성하여
		// 배열 주소를 arr 변수에 대입
		int[]	arr = new int[4];
		
		// arr.length == 배열 길이
		for (int i = 0; i < arr.length; i++) {
			System.out.print(i + " 번 인덱스 : ");
			arr[i] = sc.nextInt();
		}
		
		// java.util.Arrays 클래스 : 배열의 유용한 기능을 모아둔 클래스
		// Arrays.toString(배열명) : 배열에 저장된 값을 하나의 문자열로 반환
		
		String str = Arrays.toString(arr);
		System.out.println(str);
		
		System.out.println("<<종료>>");
	}
	
	// debug : 프로그램 수행이 정상적으로 이루어지지 않은 경우
	//         원인을 파악하기 위해 추적하는 것
	//				 + 해결 까지 / 단축키 f11 / f8
	
	/* [이클립스 디버그 모드 사용 방법]
	 * 
	 * 1) 확인하고싶은 코드 다음 줄에 break point 추가
	 * 
	 * 2) debug 모드로 실행 (벌레 아이콘 또는 F11)
	 * 
	 * 3) debug 화면으로 switch 
	 * 
	 * 4) resume (F8 키)를 눌러가며 순서대로 확인
	 * 
	 * */
	
	/**
	 * 배열 선언과 동시에 초기화 + 난수 활용
	 * 
	 * [배열 선언 + 초기화]
	 * JS   > let arr = ["aaa", "bbb", "ccc"];
	 * 
	 * Java > String[] arr = {"aaa", "bbb", "ccc"}; 중괄호 사용
	 */
	public void method3() {
		// 과목이 작성되어 있는 배열 생성
		String[] subjects = {"HTML", "CSS", "JS", "Java", "Java", "Java"};
		
		// 배열 index 범위의 난수 생성
		int ran = (int)(Math.random() * subjects.length);

		System.out.printf("당신이 시험볼 과목은 %s 입니다.", subjects[ran]);
	}
	
	/**
	 * 5 칸 짜리 char 배열을 만들어
	 * 각각의 배열 요소에 입력된 값을 대입
	 * 
	 * 입력 완료 후 
	 * 저장된 값을 역순으로 출력
	 */
	public void method4() {
		char[] arr = new char[5];
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print("문자 입력 : ");
			arr[i] = sc.next().charAt(0); 
			// 입력된 문자열의 0번째 문자 반환
			// -> char 입력 방법
		}
		
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
		
	}
	
}
















