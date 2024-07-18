package ex;

import java.util.Arrays;

public class ArrayEx2 {
	
	/* 얕은 복사
	 * - 참조형 변수가 가지고 있는 
	 *   "주소" 만 복사하는 것
	 * 
	 * - 서로 다른 변수가 같은 배열/ 객체를 참조하기 때문에
	 *   같은 값을 공유!!
	 * 
	 */
	public void method1() {
		// 원본 배열
		int[] arr = {10, 20, 30, 40, 50};
		
		// 얕은 복사한 배열
		int[] copyArr = arr;
		
		System.out.println("[변경 전]");
		System.out.println("arr     : " + Arrays.toString(arr));
		System.out.println("copyArr : " + Arrays.toString(copyArr));
		
		copyArr[3] = 4444;
		copyArr[4] = 5555;
		
		System.out.println("[변경 후]");
		System.out.println("arr     : " + Arrays.toString(arr));
		System.out.println("copyArr : " + Arrays.toString(copyArr));
		
		// 복사한 배열을 수정했지만
		// 원본도 같이 수정됨
		// -> 얕은 복사는 주소만 복사해서
		//    같은 배열을 참조하게 만들어 값을 공유함
		
	}
	
	/* 깊은 복사
	 * - 원본 배열 / 객체가 가지고 있는 값을
	 *   똑같이 복사한 배열 / 객체를 만드는 것
	 *   (복제의 개념) 
	 *   
	 * - 새로운 배열 / 객체가 만들어 지는 것으로 
	 *   원본과는 독립되어 있음
	 *   -> 값을 공유하지 않는다!!!!!!!
	 */
	public void method2() {
		// 원본 배열
		int[] arr = {10, 20, 30, 40, 50};
		
		// 깊은 복사 1 : for 문 이용
		int[] copyArr = new int[arr.length]; // 원본 크기의 새 배열 생성
		// 원본 배열 요소의 값을 같은 인덱스의 복사된 배열 요소에 대입
		for(int i = 0; i < arr.length; i++) {
			copyArr[i] = arr[i];
		}
		
		// 깊은 복사 2 : System.arraycopy(원본 배열명, 원본 복사 시작 인덱스,
		// 				                   복사 배열명, 복사 배열의 삽입 시작 인덱스, 
		//					                   복사 길이)) 이용
		
		int[] copyArr2 = new int[arr.length];
//		                원본 요소/ 복사 요소/ 길이
		System.arraycopy(arr, 0, copyArr2, 0, arr.length);
		
		// 원본, 복사1, 복사2 의 0번 인덱스 값을 변경
		arr[0]      = 11111;
		copyArr[0]  = 22222;
		copyArr2[0] = 33333;
		
		System.out.println("arr      : " + Arrays.toString(arr));
		System.out.println("copyArr  : " + Arrays.toString(copyArr));
		System.out.println("copyArr2 : " + Arrays.toString(copyArr2));
	}
	
	
	//============================================================================
	
	
	/* [향상된 for 문 (forEach]
	 *  
	 * - 0 번 인덱스 부터 마지막 인덱스 까지 1 씩 증가하며
	 *   iterable 성격을 띄는 객체의 요소를 
	 *   하나씩 순서대로 반환하는 for 문 
	 *   
	 *   * iterable : 반복 가능한 (여러 개가 묶여있는, 하나씩 꺼낼 수 있는?)
	 *     ex) 배열, List, Set, Map 등
	 *     
	 * [작성법]
	 * 
	 * for (배열 요소 자료형의 변수 : 배열명) {
	 * 
	 * }
	 * 
	 * ex) 
	 * int[] arr = new int[3];
	 * 
	 * for (int num : arr0 {
	 * 	// num 은 for 문이 반복 될 때마다
	 * 	// arr[0], arr[1], arr[2] 인덱스 값이
	 * 	// 순차적으로 대입됨
	 * }
	 */
			
			
			
	public void method3() {
		
		int[] arr = {10, 20, 30, 40};
		
		// 향상된 for 문
		for (int num : arr) {
			System.out.println(num);
		}
		
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		// 일반 for 문
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}
	
	/**
	 * 향상된 for 문을 이용한
	 * 배열 요소 순차 접근(==반복 접근)
	 */
	public void method4() {
		
		char[] arr = {'정', '인', '재'};
		
		for (char ch :arr) { // 향상된 for 문
			System.out.printf("'%c' 의 유니코드 : %d \n", ch, (int)ch );
		}
	}
	
	//=====-=-=-======================-=-=-=-=-=-=-===============
	
	/** [2 차원 배열]
	 
	    - 1 차원 배열을 묶음으로 다루는 것
	      -> 1차원 배열을 참조하는 
	      	참조형 변수의 묶음
	    - 2 차원 배열 선언으로 만들어진 1 차원 배열은
	    	HEAP 메모리 영역에 할당
	    
	    [작성법]
	    ([] : 1 차원 배열)
	    
	     자료형[] 배열명 = new 자료형[크기][크기];
	 */
	public void method5() {
		// 2 차원 배열 선언 / 할당
		int[][] arr = new int[2][3];
		
		// 2 차원 배열 초기화
		arr[0][0] = 10;
		arr[0][1] = 20;
		arr[0][2] = 30;
		arr[1][0] = 40;
		arr[1][1] = 50;
		arr[1][2] = 60;
		
		System.out.println(arr[0]); // 1 차원 배열의 해시코드 (주소)
		System.out.println(arr[1]); // 1 차원 배열의 해시코드 (주소)
		
		// arr[0] 가 참조하는 객체/ 배열이 int[] 자료형인가?
		System.out.println(arr[0] instanceof int[]);
		
		System.out.println("=======================");
		// for 문으로 모든 요소 출력하기 1 (일반 for 문)
		
		// arr.length == arr 이 참조하는 1 차원 배열 참조변수의 묶음의 길이(개수)
		for (int row = 0; row < arr.length; row++) { // 행 제어
			for (int col = 0; col < arr[row].length; col++) { // 열 제어
				System.out.print(arr[row][col] + " ");
			}
			
			System.out.println();
		}
		
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=");
		// for 문으로 모든 요소 출력하기 2 (향상된 for 문)
		
		for (int[] row : arr) {  // 행을 하나씩 순차 접근
			for (int col : row) { // 각 행의 열을 하나씩 순차 접근 
				System.out.print(col + " ");
			}
			System.out.println();
		}
 	}
	
	
	/**
	 * 
	 */
	public void method6() {
		
	}
	
}
    
    
    
    
    
    
 
 
 
 
 
 
 








