package dto;

/* 상속 : 부모의 코드(필드 / 메서드) 를 물려 받아
 * 		 자식이 자신의 코드인 것처럼 사용
 * 
 * 상속 키워드 : extends (확장하다)
 * 	-> 부모 코드를 물려받은 자식의 크기가 커지기 때문에!
 * 
 * ** 주의 사항 **
 * - 부모의 코드 중 생성자는 물려받지 못함!!!
 * 
 * - 부모의 private 접근 제한자 필드 / 메서드는 
 *   상속 받긴 하지만 직접 접근 불가!!
 *    -> 상속 관계여도 다른 클래스(객체)로 인식 되기 때문에
 *    	접근 불가   
 * 
 */

public class Child1 extends Parent{
	// 필드
	private String notebook;
	
	/* super() 생성자
	 * - super 뜻 : 상위의
	 * - 현재 클래스의 상위 클래스(부모) 생성자를 호출하는 구문
	 * 
	 * - super() 는 자식 생성자에만 작성할 수 있으며
	 *   반드시 첫번째 줄에 작성해야 한다!!!!!
	 */

	// 기본 생성자
	public Child1() {
		super();
		System.out.println("자식1 - 기본 생성자로 객체 생성");
	}
	
	// 매개변수 생성자
	public Child1(String notebook) {
		
		// 부모 매개변수 생성자 호출~☎~☎~☎~☎~☎~☎~☎~☎~☎
		super("부산 해운대구", 123456789, "모하비");
		
		this.notebook = notebook;
		System.out.println("자식1 - 매개변수 생성자로 객체 생성");
	}
	
	public String getNoteBook() {
		return notebook;
	}

	public void setNoteBook(String notebook) {
		this.notebook = notebook;
	}
	
	/**
	 * 자식 객체 + 부모 객체에 있는 모든 필드 값 출력
	 */
	public void print() {
		// 부모 필드
		
		// protected 필드는 상속받은 클래스에서 직접 접근 가능!!
		System.out.println("lastName : " + lastName);
		
		// private 필드 간접 접근
		System.out.println("address  : " + getAddress());
		System.out.println("money    : " + getMoney());
		System.out.println("car      : " + getCar());
		
		// 자식 필드
		System.out.println("notebook : " + notebook);
		
	}
	
	/* super 참조 변수
	 * - 자식 객체 내부의 부모 객체를 참조하는 변수
	 * - 언제 사용해???
	 *   -> 부모의 필드 / 메서드임을 확실하게 명시할 때 주로 사용
	 */
	
	/**
	 * 자식 + 부모 필드 정보를 하나의 문자열로 반환
	 * -> 성 / 주소 / 돈 / 차 / 노트북
	 */
	public String childInrorm() {
		
//		return String.format("%s / %s / %d / %s / %s",
//				 lastName, getAddress(), getMoney(), getCar(), notebook);
		
		return super.inform() + " / " + notebook;
	}

	/* 오버라이딩(Overriding) / 재정의
	 * Over    : 위쪽 (방향?), 넘어서다
	 * Ridding : 타는 것
	 * 
	 * => 부모로부터 물려받은 메서드를 자식이 
	 * 	같은 이름의 메서드를 만들어 덮어 쓰기
	 * 	-> 물려 받은 자식에 맞게
	 * 		부모의 메서드를 다시 정의해야 하는 경우 사용
	 * 
	 * ** 중요 **
	 * @Override 어노테이션(Annotation)
	 * 1) 해당 메서드는 오버라이딩 되었음을 명시
	 * 2) 오버라이딩된 코드가 알맞게 작성되었는지 
	 * 	컴파일러에게 검사하라고 지시하는 컴파일러 주석
	 * 
	 *   *\('∇')/*   Θ∇Θ -ω- º∇º
	 *   
	 * [오버라이딩 성립 조건]
	 * 1. 접근 제한자는 같은 더 넓거나 범위
	 * 2. 반환형, 매개 변수, 메서드명은 모두 동일!!!!!!!!!!!
	 * 3. 예외처리 구문(throws) 은 같거나 좁은 범위
	 * 
	 * (부모랑 똑같이 쓰는게 가장 쉬움)
	 */ 
	
	@Override
	public void introduce() {
		System.out.println("저는 Parent 의 자식 Child1 입니다");
	}

	// Parent 에게 상속 받은 toString() 오버라이딩 / 재정의
	@Override
	public String toString() {
		// Child1 클래스 내부에서 toString() 호출하면 
		// Child1.toString()이 호출됨
		
		// super.toString() : 부모 클래스에 작성된 toString() 호출
		// -> 오버라이딩 했다고 해서
		//    부모의 메서드가 덮어쓰기되어 사라지는 것이 아니다!!
		
		return super.toString() + " / " + notebook;
	}
	
	
//	final 메서드 확인하기 -> 오버라이딩 시도
//	@Override
//	public void onlyParent() {}
//	Cannot override the final method from Parent
// 오버라이딩 불가	
	
	

	
	
}

















