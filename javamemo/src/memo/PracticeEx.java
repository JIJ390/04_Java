package memo;

import java.util.Arrays;

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
	
	
	/**
	 * String 자료형 메모리 할당
	 */
	public void method5() {
		String str  = "abc";
		String str2 = "abc";
		
		
	}
	
	public static void main(String[] args) {
		args = new String[2];
		args[0] = "hello";
		args[1] = "world";
		args = new String[5];
		
		System.out.println(Arrays.toString(args));
	}
}
