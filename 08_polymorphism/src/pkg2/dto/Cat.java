package pkg2.dto;

// The type Cat must implement the inherited abstract method Animal.move()
// 상속 받은 move(), eat(), sleep() 구현해야 함
public class Cat extends Animal{

	private int beard; // 수염
	
	public Cat() {
		super();	// 부모(Animal)객체 생성
	}

	public Cat(int eyes, int beard) {
		super(eyes);
		this.beard = beard;
	}

	public int getBeard() {
		return beard;
	}

	public void setBeard(int beard) {
		this.beard = beard;
	}
	
	@Override
	public String toString() {
		return "Cat : " + beard + " / " + getEyes();
	}

	/* Animal로 부터 상속 받은 abstract 메서드를 구현(오버라이딩) 하라고
	 * 오류가 발생함
	 * -> 오버라이딩 강제화
	 */
	@Override
	public void move() {
		System.out.println("고양이 : 사뿐 사뿐 움직임");
	}

	@Override
	public void eat() {
		System.out.println("고양이 : 냠냠 먹음");
	}

	@Override
	public void sleep() {
		System.out.println("고양이 : 엎드려 잠");
	}

}












