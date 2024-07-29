package set.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import set.dto.Person;

public class SetService {
	/* Set(집합, 주머니)
	 * - 기본적으로 순서를 유지하지 않음
	 *   (index 없음! -> get() 메서드가 없음)
	 *   
	 * - 중복 데이터 저장 X (같은 객체가 들어오면 덮어쓰기)
	 * 
	 * 
	 * Set 인터페이스의 자식 클래스
	 * 
	 * 1. HashSet (대표) : 처리 속도가 빠른 Set
	 * 
	 * 2. LinkedHashSet : 순서를 유지하는 Set
	 * 
	 * 3. TreeSet : 자동 정렬되는 Set
	 */
	
	/**
	 * Set / HashSet 사용법
	 */
	public void test1() {
//		HashSet 객체 생성
		Set<String> set = new HashSet<String>();
		
//		1. boolean add(E e) : 요소 추가
		set.add("네이버");
		set.add("카카오");
		set.add("라인");
		set.add("쿠팡");
		set.add("배달의민족");
		set.add("토스");
		set.add("직방");
		set.add("야놀자");
		
		System.out.println(set);	//set.toString()
//		HashSet 순서 유지 X
		
//		중복 데이터 추가 후 결과 확인
		
		set.add("배달의민족");
		set.add("배달의민족");
		set.add("배달의민족");
		
//		String 은 equals 와 hashCode가 오버라이딩 되어있음

		System.out.println(set); // 중복 허용 X
		
		set.add(null);
		set.add(null);
		set.add(null);
		
//		null 도 중복 안됨!!!!
		System.out.println(set);
		
//		2. int size() : Set 에 저장된 객체(참조변수)의 수 반환
		System.out.println(set.size());
	
//		3. boolean remove(E e) : Set 에 저장된 객체 중 같은 객체를 찾아 제거
//		제거 성공/ 실패(없음) : true / false
		
		System.out.println("배민 제거 : " + set.remove("배달의민족"));
		System.out.println("삼성 제거 : " + set.remove("삼성"));
		System.out.println(set);
		
//		4. boolean contains(E e) : 같은 요소가 있으면 true, false
		
		System.out.println("네이버 존재 : " + set.contains("네이버"));
		System.out.println("KT     존재 : " + set.contains("KT"));
		
//		5. boolean isEmpty() : 비어있으면 true / false
		
//		6. void clear() : 저장된 객체 모두 제거
		System.out.println("비어있음? : " + set.isEmpty());
		
		set.clear();
		System.out.println("제거 완료");
		System.out.println("비었니? : " + set.isEmpty());
		
//		Set
//		- index 가 없음
//		-> index 를 활용하는 메서드가 없다
//		-> 원하는 요소 하나만을 꺼낼 수 없다
		
//		- 순서 유지 X
//		-> 중복 허용 X
	}
	
	/**
	 *  Set에 저장된 객체를 꺼내는 방법
	 *  
	 *  1. Iterator(반복자) 이용
	 *  2. List로 변환
	 *  3. 향상된 for문 이용
	 */
	public void test2() {
		
		Set<String> snackSet = new HashSet<String>();
		
		snackSet.add("포카칩");
		snackSet.add("새우깡");
		snackSet.add("홈런볼");
		snackSet.add("꼬깔콘");
		snackSet.add("프링글스");
		snackSet.add("빈츠");
		snackSet.add("쿠크다스");
		
		/* 1. Iterator(반복자) 이용 */
//		컬렉션에 저장된 요소를 하나 씩
//		순차접근하는 기능을 제공하는 인터페이스
	
//		hasNext() : 다음 순차 접근할 요소가 있으면 true
		
//		next() : 다음 요소가 있으면 꺼내와서 반환
		
//				 -> 화살표(커서) 를 한 칸 움직임
		Iterator<String> it = snackSet.iterator();
		
		System.out.println("[Iterator]");
		
		while (it.hasNext()) {
			String snack = it.next();
			System.out.println(snack);
		}
		
		System.out.println("------------------------------------------");
		
		/* 2. List 로 변환 */
		
		List<String> snackList = new ArrayList<String>(snackSet);
		
		System.out.println("[List로 변환]");
		
		for(int i=0 ; i<snackList.size() ; i++) {
			System.out.println(snackList.get(i));
		}
		
		/* 3. 향상된 for 문 */
		
		System.out.println("---------------------------------");
		System.out.println("[향상된 for 문]");
		
		for (String snack : snackSet) {
			System.out.println(snack);
		}
	}
	
	/**
	 * Hash 가 포함된 컬렉션을 이용하는 방법
	 * ex) HashSet, LinkedHashSet, HashMap, HashTable 등
	 * 
	 * 1. Object.equals()   오버라이딩 하기
	 * 2. Object.hashCode() 오버라이딩 하기
	 * 
	 * *** 1, 2 둘 다 수행 해야만 함!!
	 * 
	 * -> Java 는 동일한 객체임을 비교할 때
	 *    동등 / 동일 모두 true 여야지만 동일한 객체로 인식
	 */
	public void test3() {
		Person p1 = new Person("홍길동", 25, '남');
		Person p2 = new Person("홍길순", 22, '여');
		Person p3 = new Person("신짱구",  5, '남');
		
//		중복된 필드를 가진 Person 객체 2 개 생성
		Person p4 = new Person("김유리",  5, '여');
		Person p5 = new Person("김유리",  5, '여');
		
//		HashSet 에 p1 ~ p5 추가
		Set<Person> setPerson = new HashSet<Person>();
		
		setPerson.add(p1);
		setPerson.add(p2);
		setPerson.add(p3);
		setPerson.add(p4);
		setPerson.add(p5);
		
//		[key point!] 
//		- p4/p5가 중복된 데이터로 인식되서 
//		  한 번만 출력되는지 확인
		
//		확인 1(equals, hashCode 오버라이딩 X)
//			-> 김유리 중복돼서 출력됨
		for (Person p : setPerson) {
			System.out.println(p);
		}
		
		System.out.println("---------------------------------");
//		equals 오버라이딩 확인 == 동등 비교(동명이인 개념)
		System.out.println(p4.equals(p5));
		System.out.println(p4.equals(p1));
//		hashCode 오버라이딩 확인
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		System.out.println(p3.hashCode());
		System.out.println(p4.hashCode());
		System.out.println(p5.hashCode());
	}
	
	/**
	 * TreeSet : 이진 트리 구조를 이용해 객체를 저장하는 Set
	 * 		-> 오름차순 정렬 + 중복 제거
	 * (포도 모양)
	 * * 선행 조건 * *
	 * = 저장되는 객체가 Comparable 인터페이스를 상속해 구현해야 함
	 * 
	 */
	public void test4() {
		Random random = new Random();
		
		Set<Integer> lotto = new TreeSet<Integer>();
		
//		1 ~ 45 난수
		while (lotto.size() < 6) {
			lotto.add(random.nextInt(45) + 1); 
//			내부에서 알아서 중복 제거 및 오름차순 정렬
		}
		
		System.out.println(lotto);
	}
	
	/** 로또 번호 생성기
	 * 
	 * - 금액을 천 원 단위로 입력 받아
	 * 	 천 원당 1 회씩 번호를 생성해서 List 에 저장한 후
	 * 	 생성 종료 되는 시점에 한 번에 출력
	 * 
	 *  단, 5 회 출력 시 마다 구분선 추가
	 * <pre>
	 * 금액 입력 : 3000
	 *
	 * 1 회 : [1, 2, 3, 4, 5, 6]
	 * 2 회 : [11, 12, 13, 14, 15, 16]
	 * 3 회 : [21, 22, 23, 24, 25, 26]
	 * 4 회 : [31, 32, 33, 34, 35, 36]
	 * </pre>
	 */
	public void lottoNumberGenerator() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("금액 입력 : ");
		int value = sc.nextInt();
		
		
		List<Set<Integer>> lottoList = new ArrayList<Set<Integer>>();
		
		Random random = new Random();
		
		for (int i = 0; i < value / 1000; i++) {
			
			Set<Integer> lotto = new TreeSet<Integer>();
			
			while (lotto.size() < 6) {
				lotto.add(random.nextInt(45) + 1); 
			}
			
			lottoList.add(lotto);
		}
		
		for (int i = 1; i <= lottoList.size(); i++) {
			
			System.out.printf("%3d 회 : %s \n", i, lottoList.get(i - 1));
			
			if (i % 5 == 0) {
				System.out.println("================================");
			}
			
		}
		
	}
	
}
































