package pkg4.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 문자 기반 스트림
 * 
 * - 2 byte 문자(char) 단위로 입출력하는 스트림
 * 
 * - 문자만 작성된 파일(txt), 채팅, 인터넷 요청(주소)/응답(html)
 * 
 * - Reader(입력), Writer(출력) 최상위 인터페이스
 */
public class CharService {

	/**
	 * 문자 기반 스트림을 이용해 출력하기1
	 * - 기반 스트림만 이용
	 */
	public void fileOutput1() {
//		String 불변성을 해결한 객체
		StringBuilder sb = new StringBuilder();
		
		sb.append("오늘은 8 월 1 일 입니다\n");
		sb.append("아쉽게도 목요일이네요\n");
		sb.append("학교 종이 땡땡땡\n");
		sb.append("HELLO !OoO!\n");
		
		String str = sb.toString();
		
		FileWriter fw = null;
		
		try {	// 예외가 작성될 것 같은 코드
			
			File f = new File("/io_test/char");
			if (!f.exists()) f.mkdirs();
			
			fw = new FileWriter("/io_test/char/문자테스트.txt");
			
//			문자 기반 스트림 write 는 byte[] 이 아닌 String 을 매개변수로 받음
//			문자열을 지정된 파일에 출력
//			-> 자동으로 전달한 String 을 한 글자씩 출력
			fw.write(str);
			
//			통로에 남아있는 데이터
//			스트림 밖으로 데이터를 흘려 보냄(flush)
			fw.flush();
			
			System.out.println("출력 완료");
			
		} catch (Exception e) { // try에서 던져진 예외를 잡아서 처리하는 구문
			e.printStackTrace();
			
		} finally {	// try에서 예외 발생 여부 관계 없이 무조건 수행하는 구문
			try {
				if (fw != null) fw.close();
//				close() : flush() 를 선 실행 후 close 함
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void fileOutput2() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("문자 기반 보조스트림\n");
		sb.append("BufferedWriter 를 이용해\n");
		sb.append("출력한 결과입니다!!!\n");
		
		FileWriter     fw = null;
		BufferedWriter bw = null;
		
		try {

			fw = new FileWriter("/io_test/char/보조스트림출력.txt");
			bw = new BufferedWriter(fw);
			
			bw.write(sb.toString());
			
			bw.flush();
			
			System.out.println("출력 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	/**
	 * 문자 기반 입력 스트림을 이용해
	 * /io_test/char/문자테스트.txt 
	 * 파일 내용을 읽어와 콘솔에 출력
	 */
	public void fileInput1() {

		FileReader fr = null;
		
		try {
			
			fr = new FileReader("/io_test/char/문자테스트.txt");
			
			StringBuilder sb = new StringBuilder();
			
		    int ch;        
			
//		    read() 문자를 하나씩 받아옴
//		    while ((ch = fr.read()) != -1) System.out.print((char)ch);
			while ((ch = fr.read()) != -1) sb.append((char)ch);
			
			System.out.println(sb);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void fileInput2() {
		
		FileReader     fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader("/io_test/char/보조스트림출력.txt");
			br = new BufferedReader(fr);
			
			StringBuilder sb = new StringBuilder();
			
//			String br.readLine()
//			-> 한 줄을 읽어옴, 없으면 null 반환
//			-> \n 은 읽어오지 않음
			
			String line = null;
			
			
			long start = System.nanoTime();
			
			while ((line = br.readLine()) != null) {
//				sb.append(line + "\n");	    // 3171799 ns  20 배 가량 느림!!
				sb.append(line);			// 153400  ns
				sb.append("\n");
			}

//			sb.append(line + "b");
			
			long end = System.nanoTime();
			
			
			System.out.println(end - start);
			
			System.out.println(sb);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	
		
	}
	
}

















