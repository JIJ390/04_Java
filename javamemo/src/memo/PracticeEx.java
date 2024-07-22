package memo;

import java.util.Arrays;
import java.util.Scanner;

public class PracticeEx {
	
	int     a;
	long    b;
	char    c;
	double  d;
	byte    e;
	float   f;
	short   g;
	boolean h;
	String  i;
	
	/**
	 * 기본 자료형에 저장되는 기본값
	 */
	public void method1() {
		System.out.println("int     " + a);
		System.out.println("long    " + b);
		System.out.println("char    " + c);
		System.out.println("double  " + d);
		System.out.println("byte    " + e);
		System.out.println("float   " + f);
		System.out.println("short   " + g);
		System.out.println("boolean " + h);
		System.out.println("String  " + i);
	}
	
	public void method2() {
		System.out.println("int     " + Integer.MAX_VALUE);
		System.out.println("long    " + Long.MAX_VALUE);
		System.out.println("double  " + Double.MAX_VALUE);
		System.out.println("byte    " + Byte.MAX_VALUE);
		System.out.println("float   " + Float.MAX_VALUE);
		System.out.println("short   " + Short.MAX_VALUE);
	}
	
	public void method3() {
		System.out.println("int     " + Integer.MIN_VALUE);
		System.out.println("long    " + Long.MIN_VALUE);
		System.out.println("double  " + Double.MIN_VALUE);
		System.out.println("byte    " + Byte.MIN_VALUE);
		System.out.println("float   " + Float.MIN_VALUE);
		System.out.println("short   " + Short.MIN_VALUE);
	}
	
	/**
	 * 얕은 복사와 깊은 복사 확인
	 */
	public void method4() {	
		
		int[]	arr;
		int[] arrtemp1 = {1, 2, 3};
		
		arr = arrtemp1;
		
		for (int i = 0; i < 5; i++) {
			System.out.println(Arrays.toString(arr));
			
			int[] arrtemp2 = {1, 2, 3, 4, 5};
			
			arr = arrtemp2;
		}
		
	}
	
	public void method5() {
		String str = "123456789";
		int a;
		int sum = 0;
		
		for (int i = 0; i < str.length(); i++) {
//			sum += Integer.parseInt(String.valueOf(str.charAt(i)));
//			sum += Character.getNumericValue(str.charAt(i));
			a = str.charAt(i) - '0';
			
			sum += a;
		}
		
//		return num_Str.chars().map(c -> c - 48).sum();
		System.out.println(str.chars().map(c -> c - 48).sum());
		System.out.println(sum);
		
	}
	
	/**
	 * 입력버퍼 확인
	 */
	public void method6() {
		
		// 입력 버퍼는 중첩 되지 않음 하나만 쌓임
		// 고로 버퍼 제거는 실사용 nextLine() 이 나오기 전에 한 번 사용하면 됨
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("a 입력");
		int a = sc.nextInt();
		
		System.out.print("b 입력");
		int b = sc.nextInt();	
		
		System.out.print("c 입력");
		String c = sc.nextLine();	// 입력 버퍼는 중첩 되지 않음 하나만 쌓임
		
		System.out.print("d 입력");
		String d = sc.nextLine();
		
		System.out.print("e 입력");
		int e = method6_1();	// 메소드 호출에서는 입력 버퍼 발생 X
		
		System.out.print("f 입력");
		String f = sc.nextLine();
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
	}
	
	public int method6_1() {
		
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

	
	
//	public static void main(String[] args) {
//		args = new String[2];
//		args[0] = "hello";
//		args[1] = "world";
//		args = new String[5];
//		
//		System.out.println(Arrays.toString(args));
//	}
}
