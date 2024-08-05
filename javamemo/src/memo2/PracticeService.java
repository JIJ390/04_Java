package memo2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Random;
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
	
	
//	=======================================================================================
	
	
	public void objCopy() {
		
		FileInputStream    fis = null;
		ObjectInputStream  ois = null;
		
		FileOutputStream   fos = null;
		ObjectOutputStream oos = null;
		
		try {
			
			File folder = new File("\\io_test\\object");
			
			if (!folder.exists()) folder.mkdirs();
			
			fos = new FileOutputStream("\\io_test\\object\\OBJ.dat");
			oos = new ObjectOutputStream(fos);
			
			PracticeDTO pr1 = new PracticeDTO("홍길동", "ID123", "PW245");
			
			oos.writeObject(pr1);
			
			System.out.println("객체 생성 저장");
			
			fis = new FileInputStream("\\io_test\\object\\OBJ.dat");
			ois = new ObjectInputStream(fis);
			
			System.out.println("객체 정보 가져옴");
	
			
			Object prCopy = (PracticeDTO)ois.readObject();
			
			StringBuilder sb = new StringBuilder();
			
			sb.append("\\io_test\\object\\OBJ.dat");
			sb.insert(sb.lastIndexOf("."), "_copy");
			
			fos = new FileOutputStream("\\io_test\\object\\OBJ_copy.dat");
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(prCopy);
			
			System.out.println("복사 완료!");
			System.out.println(prCopy.getClass());
			System.out.println(prCopy);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null) ois.close();
				if (oos != null) oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void test5() {
		
		
		String[] arr = new String[5];
		
		for (int i = 0; i < 5; i++) {
			Random random = new Random();
			
			arr[i] = random.nextInt(5) + "";
			
			System.out.println(arr[i]);
			
		}
		
		
	}
	
	
	/**
	 * print 속도 검사
	 */
	public void test6() {
		String str = "apple";
		String abc = "abcdde";
		
		StringBuilder sb = new StringBuilder();

		
		double startTime = System.nanoTime();
		
//		System.out.println("가나다 + " + str + " + 라마바 + " + abc + "+ 사아자");	//5336500
//		System.out.printf("가나다 + %s + 라마바 + %s + 사아자", str, abc);			//846800.0
		
		sb.append("가나다 + ");				//84200
		sb.append(str);
		sb.append(" + 라마바 + ");
		sb.append(abc);
		sb.append("+ 사아자");
//		
//		sb.append("가나다 + " + str);		//1003300
//		sb.append(" + 라마바 + " + abc);
//		sb.append("+ 사아자");
		
//		sb.append(String.format("가나다 + %s", str));		//810000.0
//		sb.append(String.format(" + 라마바 + %s", abc));	
//		sb.append("+ 사아자");
		
//		sb.append("가나다 + ");								//805300.0
//		sb.append(String.format(" %s ", str));
//		sb.append(" + 라마바 + ");
//		sb.append(String.format(" %s ", abc));
//		sb.append("+ 사아자");
		
		System.out.println(sb);
		
//		System.out.print("가나다 + ");				// 115700.0
//		System.out.print(str);
//		System.out.print(" + 라마바 + ");
//		System.out.print(abc);
//		System.out.print(" + 사아자\n");
		
//		System.out.println("가나다 + apple + 라마바 + abcdde + 사아자");	//77800
		
//		stringbuilder 에 String.format 을 쓰면 printf 와 유사한 속도
//		println 내에 + 쓰는 게 가장 느림 차순은 printf 사용, 최선은 sb.append 도배
		
		double endTime = System.nanoTime();
		
		System.out.println(endTime - startTime);
		
	}
	
	
	
}






























