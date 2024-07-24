package pkg1.run;

import pkg1.dto.Child;
import pkg1.dto.Parent;

public class TestRun1 {
	public static void main(String[] args) {
//		부모 참조 변수 = 부모 객체
		Parent p1 = new Parent();
		
//		사용 가능한 필드 / 메서드 : Object, Parent
		System.out.println(p1.getLastName());
		System.out.println(p1.hashCode());

		System.out.println("===================================");
//		자식 참조 변수 = 자식 객체
		Child c1 = new Child();
		
//		사용 가능한 필드 / 메서드 : Parent, Object, Child
		System.out.println(c1.getLastName());	// Parent
		System.out.println(c1.hashCode());		// Object
		System.out.println(c1.getCar());			// Child
		
		System.out.println("===================================");
		
		/*	**8 다형성 - 업캐스팅(Up Casting) ***
		 * 
		 * - "부모" 참조 변수 = '자식' 객체
		 * 
		 * - 상속 관계에서만 가능!!!
		 * 
		 * - 참조하는 자식 객체가 부모 객체로 변함!!!
		 */
		
		Parent p2 = new Child(); // 오류 안남!!!!
		
//		사용 가능한 필드 / 메서드 : Parent, Object
		System.out.println(p2.getLastName());	// Parent
		System.out.println(p2.hashCode());		// Object
		
//		System.out.println(p2.getCar());
//		-> Child 메서드 접근 불가!!!!		
		
		System.out.println("===================================");
		
		/*	*** 다운 캐스팅 (DownCasting) ***
		 * 
		 * 업 캐스팅 상태에서 (부모참조 = 자식 객체)
		 * 참조 변수의 자료형을 자식 객체 자료형으로 강제 형변환
		 * 
		 */
		
		Parent p3 = new Child(); // 업 캐스팅 상태
		
//		p3(Parent)를 Child로 강제 형변환 하여
//		반환된 주소를 c3에 저장
		
		Child c3 = (Child)p3;
		
//		. 이 (Child) 보다 우선 순이 높아 () 필요
//		가독성 떨어져서 보통 자식 참조 변수(ex) c3) 에 대입해서 사용
		System.out.println(((Child)p3).getCar());
		System.out.println(c3.getCar());	// 자식 메서드 참조 가능
		
//		Child c4 = new Parent();
//		Type mismatch: cannot convert from Parent to Child
		
		System.out.println("===================================");
		/*	Object 를 이용한 업캐스팅
		 * + 객체 타입에 따른 다운 캐스팅
		 */
		
//		Object : 모든 클래스(객체)의 최상위 부모
		Object[] arr = new Object[3];
//                   Object 참조 변수 3개 묶음		
//		(Object)type
		arr[0] = new Parent();	// Parent -> Object 업 캐스팅
		arr[1] = new Child();	// Child  -> Object 업 캐스팅
		arr[2] = new Object();  
		
		/* instanseof 연산자
		 * 
		 * [작성법]
		 * 참조변수명 instanceof 클래스
		 * 
		 * - 참조하고 있는 객체가 클래스명 객체가 맞는지 확인
		 *   true, false 로 반환 	
		 *   
		 * ** 주의사항 **
		 * - instanceof는 참조하고 있는 객체가
		 *   상속하고있는 객체도 같이 확인하기 때문에
		 *   자식 객체를 참조하는 변수에
		 *   부모 타입을 검사하면 true가 나온다!!
		 *   
		 *   Parent p = new Child(); // 업 캐스팅
		 *   
		 *   p instanceof Child
		 *   - p 가 참조하는 객체가 Child??? true
		 *   
		 *   p instanceof Parent
		 *   - p 가 참조하는 객체가 Parent??? true
		 *   
		 *   2 개를 참조하는 형태 
		 *   실제 참조 메모리는 Child지만
		 *   코드 구동 중에는 Parent를 참조하는 것처럼 보임
		 *   
		 *   ==> 주의 사항을 잘 이용하면
		 *   	 Parent, Child 클래스 상속 관계가 맞는지
		 *     확인하는 용도로도 사용 가능!
		 */
		
		for (Object obj : arr) {
			/* tip. 자료형을 연달아 검사하는 경우, 
			 * 마지막 자식(후손) 자료형 부터 검사하는게 좋다
			 */
			if (obj instanceof Child) {
				System.out.println("Child 입니다");
			}
			// 얻어온 요소가 Child  타입이면?
			else if (obj instanceof Parent) {
				System.out.println("Parent 입니다");
			}
			// 얻어온 요소가 Parent 타입이면?
			else {
				System.out.println("Object 입니다");
			}
			// 얻어온 요소가 Object 타입이면?
		}
		
		
		System.out.println("======================");
		
		
		for (Object obj : arr) {
			/* tip. 자료형을 연달아 검사하는 경우, 
			 * 마지막 자식(후손) 자료형 부터 검사하는게 좋다
			 */
			if (obj instanceof Object) {
				System.out.println("Object 입니다");
			}
			else if (obj instanceof Parent) {
				System.out.println("Parent 입니다");
			}
			else {
				System.out.println("Child 입니다");
			}
		}
		
		int i = 0;
		
		for (Object obj : arr) {
			if (i == 0) System.out.println("arr[0] = new Parent();");
			if (i == 1) System.out.println("arr[1] = new Child();");
			if (i == 2) System.out.println("arr[2] = new Object();");

			System.out.println("obj : " + (obj instanceof Object));
			System.out.println("par : " + (obj instanceof Parent));
			System.out.println("chi : " + (obj instanceof Child));
			System.out.println();
			i++;
		}
		
		System.out.println();
		
		Parent p4 = new Child();
		
		System.out.println("obj : " + (p4 instanceof Object));
		System.out.println("par : " + (p4 instanceof Parent));
		System.out.println("chi : " + (p4 instanceof Child));
	}

}














