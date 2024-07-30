package pkg2.service;

import java.util.Scanner;

public class TryCatchFinallyService {

	/* try{} : 예외 발생이 예상(가능성이 있는)되는 코드를 block 내부에 작성
	 * 
	 * catch (처리할 예외 객체 참조 변수 {} : 
	 * 		 try 에서 던져진 예외 객체를 잡아서 처리하는 구문
	 * 		 -> 예외가 처리되어(없어져) 프로그램이 강제종료 되지 않음
	 * 
	 * finally {} :
	 *  try 구문에서 예외 발생여부 상관 없이
	 *  무조건 마지막에 실행되어야 하는 코드를 작성하는 구문
	 * 
	 * 
	 */
	
	private Scanner sc = new Scanner(System.in);
	
	public void test1() {
		try {
			System.out.print("1. 정상 수행 / 2. 예외 강제 발생 : ");
			int input = sc.nextInt();
			
			if (input == 1) {
				System.out.println("예외 없이 정상 수행");
			} else {
				throw new Exception("강제로 던져진 Exception");
//									e.getMessage()
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
//				   빨간줄 에러 / 동기(멀티태스킹) 후순위로 실행될 수 있다
		} finally {
			System.out.println("=== 무조건 수행 ===");
		}
	}
	
	/**
	 * finally 는 언제 사용할까?
	 * 
	 * * Java 프로그램 - 외부 프로그램 / 장치
	 * 	 둘의 연결을 무조건 끊어야 할 때 주로 사용
	 */
	public void test2() {
		
//		Resource leak: 'scan' is never closed
//		scan 이 참조하는 객체가 닫히지 않아서
//		자원(메모리) 이 누수 되고 있다.
//		
//		--> 키보드와 연결된 통로(Stream) 가 
//			닫히지 않고 남아있어서 메모리가 쓸떄 없이 소비됨
//		*프로그램이 끝나도 외부장치와의 통로는 사라지지 않음
		
		Scanner scan = new Scanner(System.in);
//									키보드 : 외부 장치
		try {
			System.out.print("1. 정상 수행 / 2. 예외 강제 발생 : ");
			
			int input = scan.nextInt();
			
			if (input == 1) {
				System.out.println("예외 없이 정상 수행");
			} else {
				throw new Exception("강제로 던져진 Exception");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			
		} finally {
			scan.close();
			System.out.println("==== scan close 완료 ====");
//			예외 발생 여부 관계 없이 무조건!!!!!!!!!!!!!
//			외부 입력 장치와의 통로를 닫아서
//			메모리를 반환시켜주는 메서드
//			
//			-> 프로그램 최적화 방법 중 하나
		}
		
	}

}



























