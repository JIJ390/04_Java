package list.run;

import list.view.BookView;

public class BookRun {

	public static void main(String[] args) {
//		변수 : 메모리에 값을 저장하는 공간
//		    -> 저장하면 계속 호출 가능 (재사용)
//		객체를 일회성으로 사용
		new BookView().mainMenu();
		
		
//		문자열 포함 확인 
//		String.contains("검색어") : 포함이면 true / false
//		System.out.println("선재 업고 튀어".contains("선재"));
//		System.out.println("선재 업고 튀어".contains("업고"));
//		System.out.println("선재 업고 튀어".contains("고"));
//		System.out.println("선재 업고 튀어".contains("카리나"));
		
	}
}
