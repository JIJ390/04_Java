package field.pkg1;

public class FieldRun {

	public static void main(String[] args) {
		
		// FieldTest1 객체 생성
		FieldTest1 f1 = new FieldTest1();
		
		
		// public 필드 직접 접근
		System.out.println(f1.publicValue);

		// protected 필드 직접 접근
		// -> 같은 패키지라서 가능
		System.out.println(f1.protectedValue);
		
		// (default) 필드 직접 접근
		// -> 같은 패키지라서 가능
		System.out.println(f1.defaultVaule);
		
		// private 필드 직접 접근 -> 문제 발생
		// The field FieldTest1.privateValue is not visible
		// - 다른 곳 / 객체가 private 필드 접근 불가
//		System.out.println(f1.privateValue);
		
		
		
	}
}
