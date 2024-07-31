package memo2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	
	
	
}






























