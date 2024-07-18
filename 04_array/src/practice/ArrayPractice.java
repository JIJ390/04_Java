package practice;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {
	
	Scanner sc = new Scanner(System.in);
	/**
	 * 메소드 명 : public void practice1(){}
		 
		 길이가 9인 배열을 선언 및 할당하고, 1부터 9까지의 값을 반복문을 이용하여
		 순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
		 짝수 번째 인덱스 값의 합을 출력하세요. (0 번째 인덱스는 짝수로 취급)
		 
	 * [실행 화면]
		 1 2 3 4 5 6 7 8 9
		 짝수 번째 인덱스 합 : 25
	 */
	public void practice1() {
		
		int[] arr = new int[9];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
//			System.out.print(arr[i] + " ");
		}
		
//		System.out.println();
		
		int sum = 0;
		
//		for (int i = 0; i < arr.length; i += 2) {
//			sum += arr[i];
//		}
		
		for(int i = 0 ; i<arr.length ; i++) {
			System.out.print(arr[i] + " ");
			
			if(i % 2 == 0) { // 짝수번째 인덱스 요소 합
				sum += arr[i];
			}
		}
		
		System.out.println("\n짝수 번째 인덱스의 합 : " + sum);
		
	}
	
	/**
	 * 메소드 명 : public void practice2(){}
		 
		 길이가 9인 배열을 선언 및 할당하고, 9부터 1까지의 값을 반복문을 이용하여
		 순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
		 홀수 번째 인덱스 값의 합을 출력하세요. (0 번째 인덱스는 짝수로 취급)
		
		[실행 화면]
		 9 8 7 6 5 4 3 2 1 
		 홀수 번째 인덱스 합 : 20
	 */
	public void practice2() {
		
		int[] arr = new int[9];
		int sum   = 0;
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr.length - i;
			System.out.print(arr[i] + " ");
		}
		
		for (int i = 1; i < arr.length; i += 2) {
			sum += arr[i];
		}
		
		System.out.println("\n홀수 번째 인덱스 합 : " + sum);
	}

	/**
	 * 메소드 명 : public void practice3(){}
			사용자에게 입력 받은 양의 정수만큼 배열 크기를 할당하고
			1부터 입력 받은 값까지 배열에 초기화한 후 출력하세요.
			
		[실행 화면]
			양의 정수 : 5
			1 2 3 4 5 
		[실행 화면]
			양의 정수 : 8
			1 2 3 4 5 6 7 8
	 */
	public void practice3() {
		System.out.print("양의 정수 : ");
		int value = sc.nextInt();
		
		int[] arr = new int[value];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
			System.out.print(arr[i] + " ");
		}
	}
	
	/**
	 * 메소드 명 : public void practice4(){}
			
			정수 5개를 입력 받아 배열을 초기화 하고
			검색할 정수를 하나 입력 받아 배열에서 같은 수가 있는 인덱스를 찾아 출력.
			배열에 같은 수가 없을 경우 “일치하는 값이 존재하지 않습니다“ 출력
		
		[실행 화면 1]
			입력 0 : 5
			입력 1 : 8
			입력 2 : 9
			입력 3 : 10
			입력 4 : 4
			검색할 값 : 8
			인덱스 : 1
		
		[실행 화면 2]
			입력 0 : 5
			입력 1 : 8
			입력 2 : 9
			입력 3 : 10
			입력 4 : 4
			검색할 값 : 1
			일치하는 값이 존재하지 않습니다
	 */
	public void practice4() {
		
		int[] arr = new int[5];
		int search;
		boolean flag = true;
		
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("입력 %d : ", i);
			arr[i] = sc.nextInt();
		}
		
		System.out.print("검색할 값 : ");
		search = sc.nextInt();
		
		for (int i = 0; i < arr.length; i++) {
			if (search == arr[i]) {
				System.out.println("인덱스 : " + i);
				flag = false;
			}			
		}
		
		if (flag) System.out.println("일치하는 값이 존재하지 않습니다.");
		
	}
	
	/**
	 * 메소드 명 : public void practice5(){}
			사용자가 배열의 길이를 직접 입력하여 그 값만큼 정수형 배열을 선언 및 할당하고
			배열의 크기만큼 사용자가 직접 값을 입력하여 각각의 인덱스에 값을 초기화 하세요.
			그리고 배열 전체 값을 나열하고 각 인덱스에 저장된 값들의 합을 출력하세요.
		[실행 화면]
			정수 : 5
			배열 0번째 인덱스에 넣을 값 : 4
			배열 1번째 인덱스에 넣을 값 : -4
			배열 2번째 인덱스에 넣을 값 : 3
			배열 3번째 인덱스에 넣을 값 : -3
			배열 4번째 인덱스에 넣을 값 : 2
			4 -4 3 -3 2 
			총 합 : 2

	 */
	public void practice5() {
		
		System.out.print("정수 : ");
		int value = sc.nextInt();
		
		int[]	arr = new int[value];
		int sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("배열 %d 번째 인덱스에 넣을 값 : ", i);
			arr[i] = sc.nextInt();
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			sum += arr[i];
		}
		
		System.out.println("\n총합 : " + sum);
	}
	
	/**
	 * 메소드 명 : public void practice6(){}
			주민등록번호를 입력 받아 char 배열에 저장한 후 출력하세요.
			단, char 배열 저장 시 성별을 나타내는 숫자 이후부터 *로 저장하세요.
		[실행 화면]
			주민등록번호(-포함) : 123456-1234567
			123456-1******
	 */
	public void practice6() {
		
		System.out.print("주민등록번호(-포함) : ");
		String numb = sc.next();
		
		char[] arr = new char[numb.length()];
		
		for (int i = 0; i < arr.length; i++) {
			if (i >= 8) arr[i] = '*';
			else arr[i] = numb.charAt(i);
			
			System.out.print(arr[i]);
		}
	}		
	
	
	/**
	 * 메소드 명 : public void practice7(){}
			3이상인 홀수를 입력 받아 배열의 중간까지는 1부터 1씩 증가하여 오름차순으로 값을 넣고,
			중간 이후부터 끝까지는 1씩 감소하여 내림차순으로 값을 넣어 출력하세요.
			단, 입력한 정수가 홀수가 아니거나 3 미만일 경우 “다시 입력하세요”를 출력하고
			다시 정수를 받도록 하세요.
		[실행 화면]
			정수 : 4
			다시 입력하세요.
			정수 : -6
			다시 입력하세요.
			정수 : 5
			1, 2, 3, 2, 1

	 */
	public void practice7() {
	
		int value;

		do {
			System.out.print("정수 : ");
			value = sc.nextInt();
			
			if (value >= 3 && value % 2 != 0) break;
			
			System.out.println("다시 입력하세요.");
			
		} while (value < 3 || value % 2 == 0);
		
		int[] arr = new int[value];
		
		for (int i = 0; i < arr.length; i++) {
			if (i < arr.length / 2) arr[i] = i + 1; 
			if (i >= arr.length / 2) arr[i] = arr.length - i; 
			System.out.print(arr[i] + " ");
		}
		
	}
	
	/**
	 * 메소드 명 : public void practice8(){}
			10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고,
			1~10 사이의 난수를 발생시켜 배열에 초기화한 후 출력하세요.
		[실행 화면]
			발생한 난수 : 9 7 6 2 5 10 7 2 9 6 
	 */
	
	public void practice8() {
		
		int[] arr = new int[10];

		System.out.print("발생한 난수 : ");
		
		for (int num : arr) {
			num = (int)(Math.random()*10 + 1);
			System.out.print(num + " ");
		}
		
	}
	
	/**
	 * 메소드 명 : public void practice9(){}
			10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고,
			1~10 사이의 난수를 발생시켜 배열에 초기화 후
			배열 전체 값과 그 값 중에서 최대값과 최소값을 출력하세요.
		[실행 화면]
			발생한 난수 : 5 3 2 7 4 8 6 10 9 10 
			최대값 : 10
			최소값 : 2
	 */
	public void practice9() {
		
		int[] arr = new int[10];
		int min = 10;
		int max = 0;

		System.out.print("발생한 난수 : ");
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10 + 1);
			
			System.out.print(arr[i] + " ");
			
			if (max < arr[i]) max = arr[i];
			if (min > arr[i]) min = arr[i];
		}
		
		System.out.print("\n최대값 : " + max);
		System.out.print("\n최소값 : " + min);
	}
	
	
	/**
	 * 메소드 명 : public void practice10(){}
			10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고
			1~10 사이의 난수를 발생시켜 중복된 값이 없게 배열에 초기화한 후 출력하세요.
		[실행 화면]
			4 1 3 6 9 5 8 10 7 2
	 */
	public void practice10() {
		
		int[]	arr = new int[10];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10 + 1);
				
			for (int j = 0; j < i; j++) {
				if (arr[j] == arr[i]) {
					i--; 
					break;
				}
			}
		}
		
		for (int num : arr) {
			System.out.print(num + " ");
		}
		
	}
	
	/**
	 * 메소드 명 : public void practice11(){}
			로또 번호 자동 생성기 프로그램을 만들기.
			(중복 값 없이 오름차순으로 정렬하여 출력하세요.)
		[실행 화면]
			3 4 15 17 28 40 
	 */
	public void practice11() {
		int[]	arr = new int[6];
		int temp;
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 45 + 1);
				
			for (int j = 0; j < i; j++) {
				if (arr[j] == arr[i]) {
					i--; 
					break;
				}
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[i]) {
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		
		for (int num : arr) {
			System.out.print(num + " ");
		}
		
	}
	
	/**
	 * 메소드 명 : public void practice12(){}
			문자열을 입력 받아 문자열에 어떤 문자가 들어갔는지 배열에 저장하고
			문자의 개수와 함께 출력하세요. (중복 제거)
		[실행 화면]
			문자열 : application
			문자열에 있는 문자 : a, p, l, i, c, t, o, n
			문자 개수 : 8

	 */
	public void practice12() {
		
		System.out.print("문자열 : ");
		String str = sc.next();
		
		char[] arr = new char[str.length()];
		
//		boolean flag = true;
//		int count = 0;
//		
//		for (int i = 0; i < str.length(); i++) {
//			
//			for (int j = 0; j < i; j++) {
//				
//				if (str.charAt(i) == str.charAt(j)) flag = false;		// 안되는 이유 비교가 중복으로 일어남
//				break;																// 중복 문자가 기록되지 않은 문자열과 비교해야함
//				
//			}
//			
//			if (!flag) {
//				flag = true; 			
//				continue;
//			}
//			
//			arr[i] = str.charAt(i);
//			count++;
//		}
//		
//		System.out.print("문자열에 있는 문자 : ");
//		
//		for (int i = 0; i < str.length(); i++) {
//			System.out.print(arr[i] + " ");
//		}
//		
//		System.out.println("\n문자 개수 : " + count);
		
		
		for (int i = 0; i < str.length(); i++) {
			
			arr[i] = str.charAt(i);
			
			for (int j = 0; j < i; j++) {
				
				if (str.charAt(i) == str.charAt(j)) arr[i] = ' ';
			}
		}
		
		
		char[] arr2 = new char[str.length()];
		int count = 0;
		
		System.out.print("문자열에 있는 문자 : ");
		
		for (int i = 0; i < str.length(); i++) {
			
			if (arr[i] == ' ') continue;
			
			arr2[i] = arr[i];
			count++;
			
			System.out.print(arr2[i] + " ");
		}
		
		System.out.println("\n문자 개수 : " + count);
		
	}
	
/*메소드 명 : public void practice13(){}
		사용자가 입력한 배열의 길이만큼의 String 배열을 선언 및 할당하고
		배열의 인덱스에 넣을 값 역시 사용자가 입력하여 초기화 하세요.
		단, 사용자에게 배열에 값을 더 넣을지 물어보고 몇 개를 더 입력할 건지,
		늘린 곳에 어떤 데이터를 넣을 것인지 받으세요.
		사용자가 더 이상 입력하지 않겠다고 하면 배열 전체 값을 출력하세요.
		(배열의 얕은 복사, 깊은 복사를 이용하는 문제)
		얕은 복사 : 배열의 시작 주소만을 복사하여 두 참조 변수가 하나의 배열을 참조.
		깊은 복사 : 원본 배열이 가지고 있는 데이터를 그대로 복사한 새로운 배열 (복제)
		→ tip : 깊은 복사를 위한 새로운 배열은 꼭 원본 배열과 같은 크기일 필요는 없다!
	
	[실행 화면]
		배열의 크기를 입력하세요 : 3
		1번째 문자열 : 자바의 정석
		2번째 문자열 : 알고리즘
		3번째 문자열 : C프로그래밍
		더 값을 입력하시겠습니까?(Y/N) : y
		더 입력하고 싶은 개수 : 2
		4번째 문자열 : 인간관계
		5번째 문자열 : 자기계발
		더 값을 입력하시겠습니까?(Y/N) : y
		더 입력하고 싶은 개수 : 1
		6번째 문자열 : 영단어600
		더 값을 입력하시겠습니까?(Y/N) : n
		[자바의 정석, 알고리즘, C프로그래밍, 인간관계, 자기계발, 영단어600]
	
*/
	public void practice13() {
		
		System.out.print("배열의 크기를 입력하세요 : ");
		int value = sc.nextInt();
		
		int num = 0;
		char input;
		
		String[]	arr = new String[value];
		String[]	arrPlus = arr;
		
		sc.nextLine();
		
		for (int i = 0; i < value; i++) {
			System.out.printf("%d 번째 문자열 : ", i + 1);
			arr[i] = sc.nextLine();
		}
		
		do {
			
			System.out.print("더 값을 입력하시겠습니까?(Y/N) : ");
			input = sc.next().charAt(0);
			
			switch (input)	{
			case 'y' : System.out.print("더 입력하고 싶은 개수 : ");
						  num = sc.nextInt(); break;
						  
			case 'n' : System.out.println(Arrays.toString(arrPlus)); return;
			
			default  : System.out.println("잘못된 입력입니다"); 
						  input = 'y'; continue;
			}
			
			String[] arrTemp = new String[value + num];
			
			System.arraycopy(arrPlus, 0, arrTemp, 0, arrPlus.length);
			
			sc.nextLine();
			
			for (int i = value; i < value + num; i++) {
				System.out.printf("%d 번째 문자열 : ", i + 1);
				arrTemp[i] = sc.nextLine();
			}
		
			value += num;
			arrPlus = arrTemp;
			
		} while (input == 'y');
	}
	
}
		







