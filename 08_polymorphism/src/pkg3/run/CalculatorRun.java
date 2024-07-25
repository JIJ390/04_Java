package pkg3.run;

import pkg3.dto.Calculator;
import pkg3.dto.JIJCalculator;

public class CalculatorRun {
	public static void main(String[] args) {
//		인터 페이스도 추상 클래스 처럼
//		- 객체 생성 X
//		- 부모 타입 참조 변수로 사용 O
//			-> 다형성 업 캐스팅 + 동적 바인딩
		Calculator c = new JIJCalculator();
		
		System.out.println(c.plus(222, 3333));
		System.out.println(c.minus(6, 2));
		System.out.println(c.multi(5000, 322333));
		System.out.println(c.div(55555, 2222));
		System.out.println(c.mod(1234, 222));
		System.out.println(c.pow(2, 10));
		System.out.println(c.areaOfCircle(3));
		System.out.println(c.toBinary(200));
		System.out.println(c.toHexadecimal(300));
		
		
	}
	
}






















