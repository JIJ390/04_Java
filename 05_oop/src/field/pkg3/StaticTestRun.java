package field.pkg3;

public class StaticTestRun {

	public static void main(String[] args) {
		
		Korean k1 = new Korean();		
		k1.setName("김철수");
		k1.setId("990101-1111111");
		
		Korean k2 = new Korean();
		k2.setName("김영희");
		k2.setId("990304-2222222");
		
		// -------------------------------------------------

		System.out.printf("k1 : %d / %s / %s \n", k1.nationalCode, k1.getName(), k1.getId());
		System.out.printf("k2 : %d / %s / %s \n", k2.nationalCode, k2.getName(), k2.getId());
		// -------------------------------------------------

		System.out.println("\n\n[static 변수 값 변경 확인]");
		
		// static 은 값을 공유하고 있기 때문에 
		// 한 번만 바꾸면 공유하는 모든 객체의 값이 변경된다!!!
		k1.nationalCode = 10;
		
		System.out.printf("k1 : %d / %s / %s \n", k1.nationalCode, k1.getName(), k1.getId());
		System.out.printf("k2 : %d / %s / %s \n", k2.nationalCode, k2.getName(), k2.getId());
		
		// ------------------------------------------------
		
		// 왜 k1.nationalCode / k2.nationalCode 에 노란 줄에 표시될까
		
		// The static field Korean.nationalCode should be accessed in a static way
		// -> 정적 방식으로 접근하는게 좋아
		// -> Static 영역에 생성된 이름으로 호출하는게 좋다!
		//    (참조를 2 번 반복하는 것보다 효율적)
		
		System.out.println("\n\n");
		System.out.println("[static에 선언된 이름 사용하기]");
		
		System.out.println("Koean.nationalCode : " + Korean.nationalCode);
		
		System.out.println("-- 값 변경 --");
		Korean.nationalCode = 1;	// 클래스명.필드명
		System.out.println("Koean.nationalCode : " + Korean.nationalCode);
		System.out.println(k1.nationalCode);
		System.out.println(k2.nationalCode);
		
		// ------------------------------------------------
		
		// final 변수 == 상수
		
		// static 변수 == 공유하는 변수
		
		// static final 또는 final static
		// -> 공유 가능한 상수
		
		// --> 무슨 용도?? 전체적으로 사용되면서 변하면 안되는 값
		//		Math.PI (원주율)
		//		Integer.MAX_VALUE (int 최대값)
		//		Integer.MIN_VALUE (int 최소값)
		
		//    앞에 클래스명이 붙으면 static
		//    대문자 변수명이면      final
		
		System.out.println(Math.PI);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
	}
}




































