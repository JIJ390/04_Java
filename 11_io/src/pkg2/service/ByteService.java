package pkg2.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* * Stream (스트림) 
 * - 데이터가 이동하는 통로
 * - 기본적으로 단방향
 * 
 * * Byte 기반 스트림
 * - 1 byte 단위로 데이터를 입출력하는 스트림
 * - 최상위 인터페이스 : InputStream, OutputStream
 * 
 * - 입출력 할 수 있는 데이터 : 
 * 	 문자열, 이미지, 영상, 오디오, pdf 등 모든 데이터/ 파일
 * 	 (단, 문자열이 깨질 가능성이 있고,
 * 		좁은 통로를 이용하다 보니 속도가 상대적으로 느림
 * 
 *  **************************************************************
 *  Stream(통로) 객체는 Java 프로그램이 종료가 되어도
 *  
 *  연결에 사용된 외부 파일/프로그램과 지속적으로 
 *  연결되어져 있어 자동으로 사라지지 않는다!!
 *  
 *  -> 직접 닫아서 없애주는 close() 구문을 필수로 수행!!
 * 
 *  **************************************************************
 * 
 */
public class ByteService {
	/**
	 * 지정된 경로의 폴더에 
	 * 파일 생성 + 내용출력 (바이트 기반 스트림 사용) 
	 */
	public void fileByteOutput() {
		/* IO 관련 객체 / 기능 사용 시 
		 * IOException 발생 가능성이 있기 때문에
		 * 예외 처리 필수 !
		 */
		
//		FileOutputStream 참조 변수 선언
//		-> try / finally 에서 사용 
//		(전역 변수 처럼 사용)
//		try에서 선언하면 finally 에서 닫을 수 없음!!
		FileOutputStream fos = null;
		
		try {			// 스트림 객체 생성
			String folderPath = "/io_test/byte";
			String fileName   = "바이트기반테스트.txt";
			
			File folder = new File(folderPath);
//			폴더 없으면 만들기
			if (!folder.exists()) {
				folder.mkdirs();
			}
			
//			출력할 파일과 연결된 출력용 스트림 객체 생성
//			-> 출력하려는 파일이 존재하지 않으면 자동 생성!!
//		                               /io_test/byte/바이트기반테스트.txt
			fos = new FileOutputStream(folderPath + "/" + fileName);
			
//			만들어진 txt 파일에 들어갈 내용 작성
			
//			StringBuilder : String 불변성 문제를 해결한 객체
//			                -> 메모리 효율 Good
			StringBuilder sb = new StringBuilder();
			sb.append("Hello World!!!\n");
			sb.append("1233455566\n");
			sb.append("asd71238**@#(@875!@#$\n");
			sb.append("안녕하세요~ ºㅁº aaa\n");
			
//			StringBuilder 에 저장된 내용을 String으로 변환
			
			String content = sb.toString();
			
			/* 연결된 외부 파일로 내용을 출력 */
			
//			방법 1) 1 byte 씩 끊어서 출력
			
//			for 문 수행 전에 미리 반복할 횟수를 얻어옴
//			(효율적)
//			ing length = content.length();
			
//			for (int i = 0, length = content.length(); i < length; i++) {
//				
//				char ch = content.charAt(i); // i 번째 문자 반환
//				fos.write(ch);	// 출력 스트림으로 출력
//								// 이전 출력 내용 뒤에 이어쓰기
//				
////				2 바이트 문자(Char) 를 1 바이트 스트림으로 출력
////				=> 문자 깨짐!! (데이터 손실)
//			}
//			
//			for (char c : content.toCharArray()) {
//				fos.write(c);
//			}
			
//			방법 2) String 을 byte 로 먼저 변환한 후 출력
//			-> 미리 byte 로 변환하면 손실되는 데이터가 없어
//			   한글도 개찌지 않고 출력된다!
			
			
//			byte[] bytes = content.getBytes();
//			fos.write(bytes);
			
			
			fos.write(content.getBytes());
			
			System.out.println("출력완료");
			
			
		} catch (IOException e) {
			e.printStackTrace(); // 예외 종류, 메시지, 발생 위치 출력
			
		} finally {			// 스트림 클로즈
			
//			try 에서 예외 발생 여부 없이 
//			연결된 FileOutStream 객체를 닫아서
//			메모리 반환을 하겠다
			
			try {
				
//				NullpointerExcetion 방지
				if (fos != null) fos.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	/**
	 * 버퍼를 이용한 빠르고 효율적인 파일 출력
	 * - FileOutputStream (기반 스트림)
	 * - BufferedOutputStream (보조 스트림)
	 */
	public void bufferedFileByteOutput() {
		
		
		/* 버퍼(buffer) 란 ??
		 * - 데이터가 모아져 있는 메모리 상의 임시 공간
		 * == 장바구니라고 생각!!
		 * -> 한 번에 많은 양의 데이터를 이동시켜 시간 효율이 좋음!!
		 */
		
//		try, finally 에서 사용하기 위해 먼저 선언
		FileOutputStream     fos = null;
		BufferedOutputStream bos = null;
		
		try {
			fos = new FileOutputStream("/io_test/byte/버퍼_바이트.txt");
//			보조 스트림 생성
			bos = new BufferedOutputStream(fos);
//			-> 기반 스트림을 매개변수로 전달하면 연결
			
//			""" """ : 내부에 작성된 문자열 그대로 저장 (like HTML <pre>)
			
			String content = """
I'm like some kind of supernova
Watch out
Look at me go, 재미 좀 볼
빛의 core, so hot, hot
문이 열려 서로의 존재를 느껴
마치 Discord, 날 닮은 너 (incoming!), 너 누구야? (Drop)
사건은 다가와, ah-oh, ayy
거세게 커져가, ah-oh, ayy
That tick, that tick, tick bomb
That tick, that tick, tick bomb
감히 건드리지 못할 걸 (누구도 말이야)
지금 내 안에선 (su-su-su-supernova)
Nova, can't stop hyperstellar
원초 그걸 찾아
Bring the light of a dying star
불러낸 내 우주를 봐봐, supernova

					""";
//			보조 스트림을 통해 출력
//			-> content 를 byte[] 배열로 변환해서 출력
//			-> 출력 시 버퍼를 사용해 한 번에 출력
			
			
			bos.write(content.getBytes());
			System.out.println("출력 완료!");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		
			try {
				if (bos != null) bos.close();
//				보조 스트림만 닫으면
//				연결된 기반 스트림도 같이 닫히게 된다
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * 바이트 기반 파일 입력 1
	 */
	public void finallyByteInput1() {
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("/io_test/byte/가사.txt");
//			방법 1) 
//			파일 내부 문자열을 1byte 씩 끊어서 읽어오기
			
			int value = 0; // 읽어온 1 byte 를 저장할 변수   
			
//			읽어온 값을 누적 저장할 객체 생성
			StringBuilder sb = new StringBuilder();
			
			while (true) {
//				fis.read(); 다음 데이터 바이트를 int 형으로 반환
//						    읽어올 내용 없을때(끝) -1 반환
				value = fis.read();
				
				if(value == -1) break;	// 반복 종료
				
//				읽어온 데이터를 char 로 변환하여 sb에 누적
				sb.append((char)value);
			}
			
			System.out.println(sb);
			
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				if (fis != null) fis.close();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 바이트 기반 파일 입력 2
	 */
	public void finallyByteInput2() {
		FileInputStream     fis = null;
		
		try {
			
			fis = new FileInputStream("/io_test/byte/가사.txt");
			
//			방법 2) 
//			byte[] fis.readAllBytes();
//			-> 연결된 파일의 내용을 모두 byte 로 변환 후
//			   하나씩 읽어와 byte[] 에 저장하여 반환
//			-> byte[] 을 이용해서 String 객체를 만들 수 있는데
//			   이 때 바이트로 쪼개진 데이터가
//			   정상적으로 합쳐져 깨지지 않고 정상 형태 유지
			
			System.out.write(fis.readAllBytes());

			System.out.println("----------------------");
			
			byte[] bytes = fis.readAllBytes();
			String content = new String(bytes);
			System.out.println(content);
			
			System.out.println("aaa");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if (fis != null) fis.close();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
	}

	
	/**
	 * 버퍼를 이용해 효율적으로 파일 읽어오기
	 */
	public void bufferedFileByteInput() {
		FileInputStream     fis = null;
		BufferedInputStream bis = null;
		
		try {
			
			fis = new FileInputStream("/io_test/byte/가사.txt");
			bis = new BufferedInputStream(fis);
			
			System.out.write(bis.readAllBytes());
			
//			byte[] bytes = bis.readAllBytes();
//			String content = new String(bytes);
//			System.out.println(content);
			
			
		} catch (Exception e) {	// 부모 타입을 이용해 자식타입 예외처리 가능 (다형성-업캐스팅)
			e.printStackTrace();
		} finally {
			
			try {
				if (bis != null) bis.close();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
	}
	
	/**	[파일 복사]
	 * 
	 * <pre>
	 *  복사할 파일의 경로를 입력하여
	 *  해당 파일이 존재하지 않으면 
	 *  -> "파일이 존재하지 않습니다" 콘솔 출력
	 *  
	 *  존재하면
	 *  -> 같은 경로에 '파일명_copy' 이름으로 파일 출력
	 *  
	 *  [실행 화면]
	 *  파일 경로 입력 : /io_test/byte/가사.txt
	 *  복사 완료      : /io_test/byte/가사_copy.txt 
	 *  
	 * </pre>
	 *  
	 *  
	 */
	public void fileCopy() {
		
		FileInputStream     fis = null;
		BufferedInputStream bis = null;
		
		FileOutputStream     fos = null;
		BufferedOutputStream bos = null;
		
		BufferedReader br = null;	// 보조 ??
		
		try {
			
			br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("파일 경로 입력 : ");
			String target = br.readLine();		// 키보드 입력 한 줄 받기
			
//			===============================================================
			
//			입력 받은 경로의 파일과 연결되어 읽어올 스트림 생성
			fis = new FileInputStream(target);
//			경로에 파일 없으면 FileNotFoundException
			bis = new BufferedInputStream(fis);	// 보조 스트림
			
//			입력용 스트림을 이용해 파일 내용 읽어오기
//			(byte[] 형식으로 반환)
//			byte[] bytes = bis.readAllBytes();
			
//			=============================================
			StringBuilder sb = new StringBuilder();
			
			sb.append(target);
			
//			int String.lastIndexOf("찾을 값");
//			- 찾을 값이 String(문자열) 몇번재 인덱스에 존재하는지
//			  뒤에서 부터 찾아서 반환, 없으면 -1 반환
			
			int insertPoint = sb.lastIndexOf(".");
			
			sb.insert(insertPoint, "_copy");
			
			fos = new FileOutputStream(sb.toString());
			bos = new BufferedOutputStream(fos);
			
			bos.write(bis.readAllBytes());
			
			System.out.println("복사 완료 : " + sb);
			
			
		} catch (FileNotFoundException e) {
//			경로를 잘못 썼을 때
			System.out.println("입력한 경로에 파일이 존재하지 않습니다");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(bis != null) bis.close();
				if(bos != null) bos.close();
				if(br  != null) br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			
	}

}




























