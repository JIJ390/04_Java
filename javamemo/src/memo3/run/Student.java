package memo3.run;

public class Student {
	private String name;
	private int score;
	
	public void Student() {}
	
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return String.format("%s 학생의 점수 : %d점", name, score);
	}
	
}
