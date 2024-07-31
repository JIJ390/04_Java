package pkg3.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import pkg3.dto.Member;

/* ObjectInputStream / ObjectOutputStream
 * 
 * - 객체를 입출력하는 용도의 바이트 기반 보조 스트림
 * 	 (1 byte 단위 / 기반 스트림 요구[단독 사용 불가!])
 * 
 * *********************************************************
 * 직렬화(Serializable)
 * - 스트림을 통과하려는 객체(Object) 를 
 * 	 직렬(직선) 형태로 변환하는 것
 * 
 * [직렬화 방법]
 * - 스트림을 통과하려는 객체에게 
 *   Serializable 인터페이스를 상속받게 하면된다!
 *   
 * 역직렬화
 * - 직렬화된 객체를 다시 정상 객체형태로 바꾸는 것
 * 
 * [역직렬화 방법]
 * - ObjectInputStream 을 이용해서 
 *   직렬화된 객체를 읽어오게 되면 
 * 	 자동으로 역직렬화가 수행됨
 * *********************************************************
 */
public class ObjectService {
	
	/**
	 * 객체를 외부 파일로 출력
	 */
	public void ObjectOutput() {
		
		FileOutputStream   fos = null;
		ObjectOutputStream oos = null;
		
		try {
			
			Member member = new Member("member01", "pass01", "홍길동", 20);
			
			String folder = "/io_test/object";
			
			File f = new File(folder);	
			if (!f.exists()) f.mkdirs();	// 경로상 폴더 없으면 모두 생성
			
			fos = new FileOutputStream(folder + "/Member.dat");
//										.dat 확장자 : 데이터를 담고있는 파일
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(member);
			
			System.out.println("Member 객체 출력 완료");
			
//			NotSerializableException
//			- 직렬화 안댐
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * 파일에서 Member 객체 읽어오기
	 */
	public void ObjectInput() {

		FileInputStream   fis = null;
		ObjectInputStream ois = null;
 		
		try {
			
			fis = new FileInputStream("/io_test/object/Member.dat");
			ois = new ObjectInputStream(fis);
			
//			직렬화된 객체를 읽어와
//			역직렬화 후 Member 타입으로 읽어오기
			
//			Member member = (Member)ois.readObject();
//							업캐스팅
			
//			readObject	// .getClass() 잘 활용하기
//			Object OOO = new Member();
			
			System.out.println(ois.readObject());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null) ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
 		
		
	}
}



























