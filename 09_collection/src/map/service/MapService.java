package map.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapService {
	/* Map : 특정 키워드(Key)를 입력하면
	 *       해당되는 상세한 값(Value)를 얻을 수 있는 컬렉션 객체
	 * 
	 * - K:V 형식으로 구성
	 * 
	 * - K:V 한 쌍을 "Entry" 라고 부름
	 * 
	 * - Key : 키워드 역할(== 변수명)
	 * 1) 중복 X
	 *  -> 중복되는 Key 입력 시 Value를 덮어씌움
	 *  -> Key 역할의 객체는 hashCode(), equals() 오버라이딩 필수!
	 *  
	 * 2) 순서 유지 X (단, LinkedHashMap 제외)
	 * 
	 * * Key만 묶어서 보면 Set과 같은 특징을 지니고 있음!
	 *  -> Map.keySet() / Map.EntrySet() 제공
	 * 
	 * 
	 * Value : 키워드에 해당하는 상세한 값
	 * 
	 * - Key로 인해서 모든 Value가 구분됨
	 *  -> Map.get(Key) / Map.remove(Key) 형태로 사용
	 * 
	 */
	
	public void test1() {
//		HashMap : 대표적인 Map 상속 객체
//		- Hash 단어가 붙으면 빠름
//		-> 대신 Key 역할의 객체가
//		   equals(), hashCode() 오버라이딩 필수 !!
		
//			K		V
		Map<String, String> map = new HashMap<String, String>();
		
//		1. V put(K k, V v) : Map 에 K : V 한 쌍 추가, 성공시 Value 반환
//							 -> 중복되는 key 가 없으면 null
//							 -> 중복되는 key 존재 시 이전 value 반환
		
		System.out.println(map.put("아침", "참치 김밥"));
		System.out.println(map.put("점심", "돈까스"));
		System.out.println(map.put("저녁", "삼겹살"));
		System.out.println(map.put("저녁", "꽃등심"));
//		key 중복 -> 이전 value 를 내보내고 새 value 로 대체
		
		System.out.println(map);
		
//		2. V get(K k) : 해당 Key 에 대응되는 Value 반환
//		단, 일치하는 K 가 없으면 null 반환
		System.out.println(map.get("아침"));
		System.out.println(map.get("점심"));
		System.out.println(map.get("저녁"));
		System.out.println(map.get("야식"));
		
//		3. int size() : Map 에 저장된 K:V 쌍의 개수를 반환
		System.out.println("size() : " + map.size());
		
//		4. V remove(K k) : Map 에서 key 가 일치하는 쌍을 제거
//						   일치하는 key 가 존재하면 Value 반환
//						   존재하지 않으면 null 반환
		System.out.println(map.remove("아침") + " 제거");
		System.out.println(map.remove("저녁") + " 제거");
		System.out.println(map.remove("야식") + " 제거");

		System.out.println(map);
		
	}
	
	
	/**
	 * Map 에 저장된 모든 요소 순차 접근하기
	 */
	public void test2() {
		
//		V 는 Object -> 모든 자료형 가능(모든 객체의 최상위 부모)
		Map<String, Object> student = new HashMap<String, Object>();
		
		// Map 을 유사 DTO 처럼 사용 (별도 기능은 없음)
		student.put("name"  , "홍길동");	// String
		student.put("grade" ,       3 );	// Intefer
		student.put("gender",     '남');	// Character
		student.put("avg"   ,     80.4);	// Double
		/* 1) Map.keySet() 이용*/
//		-> key 만 모아둔 집합(Set) 반환
		
//		모아둔 key 집합에서 key 를 하나씩 꺼내서
//		Map.get(key) 를 통해 value 를 하나씩 꺼냄
		
		Set<String> keys = student.keySet();
		
		System.out.println(keys);
		
		for (String key : keys) {
			System.out.printf("student[%-6s] : %s \n", key, student.get(key));
		}
		
		System.out.println("==============================================");
		/* 2) Map.entrySet() 이용*/
//		-> K : V 쌍 형태의 객체를 모아둔 집합(Set) 반환
		
		Set<Entry<String, Object>> set = student.entrySet();
		
		System.out.println(set); // k=v, k=v, ...
		
//		Entry.getKey();		: key 반환
//		Entry.getValue();	: value 반환
		
//		향상된 for 문
		for (Entry<String, Object> entry : set) {
			System.out.printf("student[%-6s] : %s \n", entry.getKey(), entry.getValue());
		}
		
	}
}






























