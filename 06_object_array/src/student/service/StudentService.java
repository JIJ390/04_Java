package student.service;

import java.util.Random;

import student.dto.StudentDTO;

// 기능(비즈니스 로직) 제공용 클래스
public class StudentService {
	
	// StudentDTO 객체를 참조하는 
	// StudentDTO 참조 변수 5 개 묶음 배열 생성
	// 인덱스 : 0 ~ 4
	// 각 인덱스 요소 : 초기 값 null
	private StudentDTO[] students = new StudentDTO[5]; 
	
	/* 기본 생성자 */
	public StudentService() {
		// 학생 객체 배열(students) 에 샘플 학생 3명 추가
		
		// students[0] : StudentDTO 자료형 참조 변수
		students[0] = new StudentDTO("24001", "신짱구", '남');
		students[1] = new StudentDTO("24002", "유리", '여');
		students[2] = new StudentDTO("24003", "맹구", '남');
		
		// student[3] / [4] == null
		// 0 ~ 100 사이 난수 발생 
		// 1) Math.floor(Math.random() * 101)  *101 주의*
		//
		// 2) Random random = new Random();
		//		random.nextInt(101);
		
		Random random = new Random();
		
		for (StudentDTO std : students) { // 향상된 for 문
			
			// 현재 접근한 요소가 참조하는 객체가 없다면
			// 반복을 종료
			if (std == null) return;
			
			std.setHtml(random.nextInt(101));
			std.setCss (random.nextInt(101));
			std.setJs  (random.nextInt(101));
			std.setJava(random.nextInt(101));
			
		}
		
	}
	
	
	/**
	 * 학생 객체 배열 students 중 비어있는 인덱스
	 * 전달받은 할생 객체(std) 추가
	 * @param std : 입력 받은 값을 저장한 학생 객체 주소
	 * @return true : 추가 성공 / false : 추가 실패
	 * - 실패 조건 : students 배열에 꽉 차있는 데 추가 학생이 전달된 경우
	 */
	public boolean addStudent(StudentDTO std) {
		
		Random random = new Random();
		
		// 0번 인덱스 부터 
		// 순서대로 비어있는(null) 요소를 찾아
		// 전달 받은 std를 대입
		for (int i = 0; i < students.length; i++) {
			
			if (students[i] == null) {	// 비어있는 요소가 있을 경우
				
				students[i] = std;			// 비어있는 temp 에 std 얕은 복사
				
				students[i].setHtml(random.nextInt(101));
				students[i].setCss (random.nextInt(101));
				students[i].setJs  (random.nextInt(101));
				students[i].setJava(random.nextInt(101));
				
				return true;
			}
		}
		
		// 비어있는(null) 인 요소가 없을 경우 false 반화
		return false;
	}
	
	/**
	 * students 객체 배열에 저장된 주소를 얻어가게 하는 메서드
	 * @param x
	 * @return
	 */
	public StudentDTO[] getStudents() {
		
		return students;
		
	}

	/** 
	 * 학생 1 명 정보 조회 (index 검성)
	 * @param index
	 * @return 조회된 학생 객체 주소 || null
	 */
	public StudentDTO selectIndex(int index) {
		
		// 전달 받은 index 범위가 students의 인덱스 범위 밖인 경우
		if (index < 0 || index >= students.length) {
			return null;
		}
		
		return students[index];
	}


	/**
	 * 전달 받은 이름과 이름이 일치하는 학생 객체를 반환
	 * @param targetName
	 * @return null 또는 일치하는 학생 객체(주소 값)
	 */
	public StudentDTO selectName(String targetName) {
		
		for (StudentDTO std : students) {
			if (std == null) return null;
			if (std.getName().equals(targetName)) return std;
			// 참조형 비교는 equals !!!!!
		}
		
		return null;
	}


	public int checkIndex(int index) {
		if (index < 0 || index >= students.length) return 1;
		if (students[index] == null) return 2;
		return 3;
	}
	
	/**
	 * 전달받은 인덱스 번째 학생의 점수 수정
	 * @param index
	 * @param other
	 */
	public void updateScores(int index, StudentDTO other) {
		
		// 객체 배열 : 객체 참조형 변수를 묶음으로 다룸
		StudentDTO s = students[index];
		
		s.setHtml(other.getHtml());
		s.setCss(other.getCss());
		s.setJs(other.getJs());
		s.setJava(other.getJava());
	}


	/**
	 * 평균 최대/최소 구하기
	 * @return 
		최고점 : 짱구(85.4)
		최저점 : 맹구(61.5)
	 */
	public String selectMaxMin() {
		
		double maxAvg = 0.0;
		double minAvg = 100.0;
		
		String maxName = "";
		String minName = "";
		
		for (StudentDTO std : students) {
			
			if (std == null) continue;
			
			double avg = (std.getHtml() + std.getCss() + std.getJava() + std.getJs()) / 4.0;
			
			if (maxAvg <= avg) {
				maxAvg  = avg;
				maxName = std.getName();
			}
			if (minAvg >= avg) {
				minAvg  = avg;
				minName = std.getName();
			}
		}
		
		return String.format("최고점 : %s (%.1f) \n"
								 + "최저점 : %s (%.1f) \n", 
								 maxName, maxAvg, minName, minAvg);
		
	}






		
}




















