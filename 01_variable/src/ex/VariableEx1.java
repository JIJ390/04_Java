package ex;

public class VariableEx1 {

	/** [main method]
	 * <p>
	 *	자바 프로그램을 실행시키기 위한 구문(기능)
	 * </p>
	 */
	public static void main(String[] args) {
		// 변수 : 메모리에 값을 저장하는 공간
		//		  변수에 저장된 값은 바꿀 수 있다
		
		/* 자료형 (Data Type) * 
		 * - 변수에 저장되는 값의 종류/ 크기
		 * 
		 * [Java 기본 자료형 8가지]
		 * 
		 * -논리형-
		 * boolean (1 byte) - true / false
		 * 
		 * -정수형-
		 * byte	   (1 byte)
		 * short   (2 byte)
		 * int     (4 byte) - 정수 기본형 (123 -> int로 인식)
		 * long    (8 byte) - 숫자 뒤에 l 또는 L (123L)
		 * 
		 * -실수형-
		 * float   (4 byte) - 숫자 뒤에 f 또는 F (3.14f)
		 * double  (8 byte) - 실수 기본형
		 * 
		 * -문자형-
		 * char    (2 byte) - 문자 하나를 의미, 'A' 형식으로 작성
		 * */
		
		// 변수 선언 : 메모리에 값을 저장할 공간을 할당
		
		int num1; // 메모리에 int 형 데이터를 저장하기 위한 공간(4byte)를 할당하고
				  // 변수 이름을 num1 이라고 지정
		

		// 자바는 초기화(처음 값 대입) 되지 않은 지역 변수를 출력, 연산할 수 없다!!
		// 대입 연산만 가능
		
		// The local variable num1 may not have been initialized
		// -> 지역 변수 num1 이 초기화되지 않았을 수 있습니다
		// System.out.println(num1);
		
		num1 = 2000;
		
		System.out.println(num1);

		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("[자료형별 리터럴 작성법]");
		
		// 논리형(1 byte)
		boolean isTrue = true;
		boolean isFalse = false;
		
		// 문자열 이어쓰기
		System.out.println("isTrue : " + isTrue);
		System.out.println("isFalse : " + isFalse);
		
		// JS 에서는 true == 1 비교 가능 하지만 Java 는 안됨!
		// WHY? 자료형이 같지 않아서 비교 불가
		// System.out.println(true == 1);
		
		
		// [정수형] 
		int intNum  = 2147483647;	// int 최대값
		
		// int 범위 초과 대입 -> 오류 발생
		// The literal 2147483648 of type int is out of range 
		// int intNum2 = 2147483648;	// int 최대값 + 1
		
		//long longNum = 2147483648;	// 일반 정수값 == int(기본형) 
		long longNum = 2147483648L;		// 뒤에 L == long 표기 
		
		System.out.println("intNum  : " + intNum);
		System.out.println("longNum : " + longNum);
		// longNum 뒤에 l 안붙어서 출력됨
		// -> 코드에만 리터럴 표기법 작성 / 출력 시 미표기됨
		
		// [실수형]
		float floatNum = 1.23F;			// 뒤에 F = float 자료형 의미	
		
		// float floatNum = 1.23;			 
		// Type mismatch: cannot convert from double to float
		// -> float 변수에 double 값을 저장할 수 없다
		
		// WHY? doube == 실수 기본형, 보통 실수 표기법이 double 로 인식됨
		
		double doubleNum = 3.14;
	
		System.out.println("floatNum : " + floatNum);
		System.out.println("doubleNum : " + doubleNum);
		
		// [문자형]
		char ch1 = 'A';					// 2byte
		char ch2 = '가';				// 리터럴 표기
		char ch3 = '鄭';				// ('')
		char ch4 = '㉿';
		
		// char ch5 = 'AB';				// 두 개 X
		// char ch5 = "A";				// 쌍따옴표"" X
		
		System.out.println("ch1 : " + ch1);
		System.out.println("ch2 : " + ch2);
		System.out.println("ch3 : " + ch3);
		System.out.println("ch4 : " + ch4);
		
				
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		
		System.out.println("[float 와 double 의 차이점]");
		
		/* float  (4 byte), double (8 byte)
		 * byte 크기가 2 배 라서 double 이 아니다
		 * 
		 * 정확도가 2배 == 소수점 표현 자릿 수가 2배라서 double!!!!!
		 */
		
		// 소수점 아래 19 자리
		float  test1 = 1.1234567890123456789f;
		double test2 = 1.1234567890123456789;
		
		System.out.println(test1);	// 1.1234568	7 ~ 8 자리
		System.out.println(test2);	// 1.1234567890123457	15 ~ 16 자리
		
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		/* String (문자열)
		 * - 기본 자료형(8가지) 에 포함되지	않음!!!!
		 * 
		 * - 기본 자료형 O : 변수에 직접 값을 저장
		 * - 기본 자료형 X : 변수에 값의 위치(주소) 를 저장
		 * 	 == 참조형     : 값의 크기를 예상하기 힘든 경우(몇 글자를 저장할지)
		 */
		
		String str1 = "문자열 리터럴 표기법은 쌍따옴표";
		String str2 = "String 은 주소를 저장하고 찾아가는 참조형";
		
		System.out.println(str1);
		System.out.println(str2);
		
	}
}












