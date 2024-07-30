package memo2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PracticeService {

	private Scanner sc = new Scanner(System.in);
	
	public void test1() {
		
		try {
			test2();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("처리");
			System.out.println(1 + 1);
			
			
		} finally {
			System.out.println("끝");
		}
	}
	
	public void test2() {
		
		System.out.println("입력");
		int a = sc.nextInt();
		System.out.println(100 / 0);
	}
	
	
	/**
	 * catch,  finally 에 예외가 있을 경우 catch 예외구문 이전까지
	 * 동작 후 finally 구문으로 이동
	 */
	public void test3() {
		try {
			System.out.println("시작");
			test4();
			
		} catch (Exception e) {
			
			System.out.println("catch");
			throw new ArithmeticException();
			
		} finally {
			System.out.println("finally");		
			throw new InputMismatchException();
		}
		
	}
	
	public void test4() throws Exception{
		throw new Exception();
	}
	
	
}
