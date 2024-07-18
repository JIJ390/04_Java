package loop.ex;

import java.util.Scanner;

public class LoopEx2 {

	// 필드(유사 전역 변수)
	Scanner sc = new Scanner(System.in);
	
	/** 다음 모양 출력하기
	 * 1234
	 * 1234
	 * 1234
	 */
	public void method1() {
		for (int i = 0; i < 3; i++) { 		// 행 제어 (3행 반복)
			for (int j = 1; j <= 4; j++) {	// 열 제어 (4열 반복)
				System.out.print(j);
			}
			System.out.print("\n"); 			// 한 행이 끝나면 줄 바꿈
		}	
	}
	
	/** 다음 모양 출력하기
	 * 54321
	 * 54321
	 * 54321
	 * 54321
	 * 
	 */
	public void method2() {
		for (int i = 0; i < 4; i++) {
			for (int j = 5; j >= 1; j--) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
	
	/** 다음 모양 출력하기
	 * 행, 열, 정방향(1) 역방향(-1) 입력
	 * 
	 * 행 입력 : 3
	 * 열 입력 : 6
	 * 정방향(1)/역방향(-1) : -1
	 * 
	 * 654321
	 * 654321
	 * 654321
	 */
	public void method3() {
		System.out.print("행 입력 : ");
		int row = sc.nextInt();
		
		System.out.print("열 입력 : ");
		int col = sc.nextInt();
		
		System.out.print("정방향(1)/역방향(-1) : ");
		int direction = sc.nextInt();
		
		for (int i = 1; i <= row; i++) {
			
			switch (direction) {
			case  1 : for (int j = 1; j <= col; j++) System.out.print(j); break;	// 정방향
			case -1 : for (int j = col; j >= 1; j--) System.out.print(j); break;	// 역방향
			default : System.out.println("잘못된 입력"); return;
			}
			
			System.out.println();
		}
		
		System.out.println("==================================");
		
		int start = direction == 1 ?   1 : col; 
		int end   = direction == 1 ? col :   1; 
		
		for (int i = 1; i <= row; i++) {
			// 무한 반복, += direction 이 [*핵심*], 경우에 따라 (-/+)
			for (int j = start; ; j += direction) {	
				
				System.out.print(j);
				if (j == end) break;
			}
			System.out.println();
		}
		
	}
//				if (direction == 1 && j <= end) {
//					System.out.print(j);
//					continue;
//				}
//				
//				if (direction == -1 && j >= end) {
//					System.out.print(j);
//					continue;
//				}
//				break;
	
	/**	다음 모양 출력하기
	 * (0,0) (0,1) (0,2)
	 * (1,0) (1,1) (1,2)
	 * (2,0) (2,1) (2,2)
	 */
	public void method4() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.printf("(%d,%d) ", i, j);
			}
			System.out.println();
		}
		
	}
	
	
	/** 다음 모양 출력 하기
	 * 
	 * (0,0) 
	 * (1,0) (1,1) 
	 * (2,0) (2,1) (2,2)
	 */
	public void method5() {
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.printf("(%d,%d) ", i, j);
			}
			System.out.println();
		}
		
	}
	
	/**	다음 모양 출력하기
	 * (0,0) (0,1) (0,2)
	 * (1,0) (1,1) 
	 * (2,0) 
	 */
	public void method6() {
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3 - i; j++) {	// j = i 형태 다름!
				System.out.printf("(%d,%d) ", i, j);
			}
			System.out.println();
		}
		
	}
	
	/** [do ~ while]
	 * - 최소 1회 이상 반복하는 반복문
	 */
	public void method7() {
		int num = 10;
		
		do {
			System.out.println("반복 출력");
		} while (num < 10); // 조건 따지는 순서 위 아래를 바꿈
		
		System.out.println("종료");
	}
	
	/** 
	 * 0 이 입력될 때까지 입력된 모든 수의 합
	 */
	public void method8() {
		
		int input = 0;
		int sum = 0;
		
		do {	// 최소 1 회 반복 보장
			System.out.print("숫자 입력 : ");
			input = sc.nextInt();
			sum += input;
		} while (input != 0);
		
		System.out.println("합계 : " + sum);
		
	}
	
}
