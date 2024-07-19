package field.pkg2;

import field.pkg1.FieldTest1;


// 다른 패키지				/*상속 구문*/
public class FieldRun2 extends FieldTest1 {

	public static void main(String[] args) {
		
		// FieldTest1 객체 생성
		FieldTest1 f1 = new FieldTest1();
		
		// public 
		System.out.println(f1.publicValue);
		
		// protected -> 문제 발생 ( 상속 관계 X )
		
//		System.out.println(f1.protectedValue);
	
		
		// (default) -> 문제 발생
		// The field FieldTest1.defaultVaule is not visible
		// defaultVaule 필드는 같은 패키지에서만 접근 가능
		// 다른 패키지에 존재하기 때문 
//		System.out.println(f1.defaultVaule);
		
	}
	
	public void method() {
		
		// 상속 관계 이기 때문에 protected 직접 접근 가능
		System.out.println(protectedValue);
		
	}
}


