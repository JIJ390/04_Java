package list.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/* Collection Framework : Java 에서 제공하는 자료구조를 모아둔 것
 * (java.util 패키지에 존재)
 * 
 * [특징]
 * 1) 크기 제한 X
 * 2) 추가, 수정, 삭제, 검색, 정렬 등 다양한 기능이 제공됨
 * 3) 객체만 저장 가능!!
 * 		(정확히는 객체 참조 주소만 저장 가능)
 * 
 * [List] 
 * - 자료(Data) 를 순차적으로 나열한 자료 구조(배열 비슷)
 * 
 * - index 가 존재함
 * 	 -> 각 Data 를 index 로 구분할 수 있어
 * 		중복된 Data 를 저장할 수 있다 !!! 
 * 
 */
public class ListService {

	public void test1() {
//		ArrayList 객체 생성
//		-> List 인터페이스를 상속 받은 자식 클래스로
//		   가장 많이 사용하는 List
		
//		List : 부모 인터페이스 
//			   -> 객체 생성 불가 / 부모 참조 변수로는 사용 가능
		
//		List list = new ArrayList();		// 10 칸 생성(기본)
		
		List list = new ArrayList(3);	//  3 칸 생성(기본)
		
//		E (Element) : 요소를 뜻하는 상징적인 글자
//					  (특정 자료형 X, Object 타입)
		
//		Object 는 모든 클래스의 최상위 부모!!
//		-> 어떤 객체든 받아서 추가 가능!!
		
//		boolean add(E e) 
//		- List 에 주어진 객체(e) 를 맨 끝에 추가
		list.add("아무거나");	// Strung
		list.add(new Object());	// Object() 객체
		list.add(new int[4]);	// int 배열, 3 번째
		
//		4 번째 --> 크기 초과 오류 발생? (O/X)
//			   --> List 크기가 자동으로 증가
		list.add(123);			
//		int 기본 자료형은 추가 불가!
//		-> Integer Wrapper class 로 
//		   변환 되어 자장됨(자동)
		
		System.out.println(list.toString());
		
//		2. void add(int index, E e)
//		 - index 번째에 e를 추가 -> 중간에 삽입한다
//		   원래 위치에 있던 요소는 다음 인덱스 위치로 밀림
		 
		list.add(2, "중간");
		
		System.out.println(list); // toString() 생략 가능
		
//		3. int size()
//		 - 저장된 Data(객체) 의 수를 반환
		
		System.out.println("현재 저장된 data 개수 : " + list.size());
		
//		(E = Object)
//		4. E get(int index)
//		 - index 번째 요소를 반환
		System.out.println(list.get(0));
		System.out.println(list.get(3));
		
//		List + 일반 for 문
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%d 번째 인덱스 요소 : %s\n",
							  i, list.get(i));
//			list.get(i) Object 형태 반환 toSring() 자동 호출
		}
		
		System.out.println("\n======================\n");
		
//		List + 향상된 for 문
		for (Object obj : list) {
			String str = null;
			
//			obj 가 참조하는 객체가 String 타입이라면
			if (obj instanceof String) str = "[String]";
			else if (obj instanceof int[]) str = "[int[]]";
			else if (obj instanceof Integer) str = "[Integer]";
			else str = "[Object]";
			
			System.out.println(str + obj);
		}
		
	}
	
	/**
	 * List + 제네릭(타입 제한) 확인 + List 메서드 몇 가지 더 확인
	 */
	public void test2() {
		/* 제네릭(Generics, <>)
		 * 1) 컬렉션의 타입을 제한하여 한 가지 자료형만 
		 * 	  저장할 수 있게 하는 기능
		 * 
		 * 2) 클래스나 메서드가 다룰 타입을 지정하는 기능
		 */
		
//		String 으로 타입이 제한된 List 생성
//		List<String> menuList = new ArrayList<String>();
		List<String> menuList = new LinkedList<String>();
		
//		add() 확인 : String 으로 제한돼서 다른 자료형 추가 X
		menuList.add("냉면");
		menuList.add("쭈꾸미볶음");
		menuList.add("칼국수");
		menuList.add("비빔밥");
		menuList.add("양념갈비");
		
//		Object 도 가능
		for (String menu : menuList) { 
			System.out.println(menu);
		}
		
//		5. E set(int index, E e)
//		 - 지정된 index 번째 요소를 
//		   e(두 번째 매개변수) 로 수정
//		   -> 메서드 반환 값으로 이전 객체가 반환
		
		System.out.println("============================");
		
		System.out.println(menuList);
		
		String before = menuList.set(2, "순두부");
		
		System.out.println(menuList);
		System.out.println("'" + before + "' 가 '" + 
						   menuList.get(2) + "' 로 변경됨");
		
//		6. boolean contains(E e) 
//		 - List 내부에 e 와 같은 객체가 존재하는지에 따라 
//		   true / false 반환 (검색? 확인 기능)
		
		System.out.println("칼국수 : " + menuList.contains("칼국수"));
		System.out.println("순두부 : " + menuList.contains("순두부"));
		
//		7. inf indexOf(E e)
//		 - List 내부에 e 와 같은 객체가 존재하면
//		   해당 index 를 반환
//		   존재하지 않으면 -1 을 반환
		
		System.out.println("순두부   : " + menuList.indexOf("순두부"));
		System.out.println("양념갈비 : " + menuList.indexOf("양념갈비"));
		System.out.println("칼국수   : " + menuList.indexOf("칼국수"));
		
		
//		8. E remove(int index)
//		 - List 에서 지정된 index 번째 요소를 제거
//		   뒤에 있는 요소 가 앞으로 당겨옴
		
//		 - 제거된 요소는 메서드 결과로 반환
		
		String remove = menuList.remove(1);
		
		System.out.println("\n" + menuList);
		System.out.println(remove + " 제거됨");
	}
	
	/**
	 * 왜 컬렉션 참조 변수를 부모 타입으로 작성하는가?
	 * 
	 * -> 프로그래밍 과정에서 미쳐 생각치 못한 비효율적인 요소를 
	 * 	  쉽게 개선하기 위해서
	 * 
	 * ex) ArrayList 로 만들었는데
	 * 	   중간에 추가, 삭제가 빈번히 일어나는 경우
	 * 	   -> LinkedList 가 훨씬 효율적
	 * 
	 *     LinkedList 만들었는데 
	 *     검색이 빈번하게 일어나는 경우
	 *     -> ArrayList가 훨씬 효율적
	 */
	public void test3() {
		List<Integer> list = new ArrayList<Integer>();
		
		Random random = new Random();
		
//		System.currentTimeMillis();
//		: 1970 년 1월 1일 09:00:00.00.00 기준으로
//		  현재 시간까지 지난 시간을 ms 단위로 반환(long)
//		System.out.println(System.currentTimeMillis());
//		System.out.println(System.nanoTime());
		
		long start = System.currentTimeMillis();
		
		for(int i = 0; i < 1000000; i++) {
//			0 ~ 99999 사이 난수
			list.add(random.nextInt(100000));
		}
		
		long end = System.currentTimeMillis();
//		System.out.println(System.currentTimeMillis());
//		System.out.println(System.nanoTime());
		
		System.out.println("생성 완료 - 걸린 시간 : " 
						+ (end - start) + " ms");

		
//		추가 시간 확인
		start = System.nanoTime();
		list.add(500000, 123456789);		// 중간에 데이터 삽입
		end = System.nanoTime();
		
		System.out.println("추가 시간 : " + (end - start) + " ns");

		
//		검색 시간 확인
		
		start = System.currentTimeMillis();
		System.out.println(list.indexOf(123456789));
		end = System.currentTimeMillis();
		
		System.out.println("검색 시간 : " + (end - start) + " ms");
	}
}















