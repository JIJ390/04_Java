package list.view;

import java.util.List;
import java.util.Scanner;

import list.dto.BookDTO;
import list.service.BookService;

// view : 사용자에게 보여지는 부분(출력과 입력)

public class BookView {

	private Scanner sc = new Scanner(System.in);
	
	private BookService service = new BookService(); 
	
	/** 
	 * 사용자에게 보여질 메인 화면
	 */
	public void mainMenu() {
		int input = 0;
		
		do {
			System.out.println("\n***** 도서 관리 프로그램 *****\n");
			
			System.out.println("1. 전체 조회");
			System.out.println("2. index 로 조회");
			System.out.println("3. 책 이름으로 조회");
			System.out.println("4. 저자 이름으로 조회");
			System.out.println("5. 가격으로 조회");
			System.out.println("6. 책 추가하기");
			System.out.println("7. 책 제거하기");
			System.out.println("8. 책 수정하기(가격)");
			System.out.println("0. 종료");
			
			System.out.print("\n메뉴 선택 : ");
			input = sc.nextInt();
			sc.nextLine();	// 입력 버퍼 엔터 제거
			System.out.println();
			
			switch (input) {
			case 1 : selectAll();    break;
			case 2 : selectIndex();  break;
			case 3 : selectTitle();  break;
			case 4 : selectWriter(); break;
			case 5 : selectPrice();  break;
			case 6 : addBook();      break;
			case 7 : removeBook();   break;
			case 8 : updateBook();   break;
			case 0 : System.out.println("***프로그램 종료 ***"); break;
			default : System.out.println("=-= 잘못된 입력입니다 =-=");
			}
			
			
		} while (input != 0);
	}





	/**
	 * 전체 조회
	 * - BookService 에 있는 bookList 를 얻어와 
	 *   존재하는 모든 요소의 정보를 출력
	 */
	private void selectAll() {
		System.out.println("\n※ 전체 조회 ※\n");
		
		List<BookDTO> bookList = service.selectAll();
		
		for (int i = 0; i < bookList.size(); i++) {
			// print() 관련 구문에서 참조 변수명을 작성하면
			// 자동으로 toString()이 호출된다!
			System.out.println(i +") " + bookList.get(i));
		}
	}
	
	/**
	 * 입력 받은 index 번째 BookDTO 를 반환 받아와 출력
	 */
	private void selectIndex() {
		System.out.println("\n※ 인덱스 조회 ※\n");		
		
		System.out.print("조회 하려는 책의 index 번호 입력 : ");
		int index = sc.nextInt();
		
//		전달한 index 번째 요소가 존재하면 BookDTO 객체 주소
//		없다면 null 반환
		BookDTO book = service.selectIndex(index);
		
		System.out.println(); // 줄바꿈
		
		if (book == null) {
			System.out.println("*** 해당 index 에 책이 존재하지 않습니다 ***");
			return;
		}
		
		System.out.println("제목 : " + book.getTitle());
		System.out.println("저자 : " + book.getWriter());
		System.out.println("가격 : " + book.getPrice() + " 원");
	}

	/**
	 * 입력 받은 책 제목이 포함된 모든 책 출력하기 
	 * 단 없으면 "조회 결과가 없습니다" 출력
	 */
	private void selectTitle() {
		System.out.println("\n※ 책 제목으로 조회 ※\n");		
		
		System.out.print("조회 하려는 책 제목 입력 : ");
		String title = sc.nextLine();
		
		List<BookDTO> searchList = service.selectTitle(title);
		
		System.out.println(); // 줄바꿈
		
		if (searchList.size() == 0) {
			System.out.println("*** 조회 결과가 없습니다 ***");
			return;
		}
//		if (searchList.isEmpty())
//		비어있는 경우, 윗 줄과 같음 !!!
		
		for (BookDTO book : searchList) System.out.println(book);
		
	}
	
	
	/**
	 * 입력 받은 책 저자가 같은 모든 책 출력하기 
	 * 단 없으면 "조회 결과가 없습니다" 출력
	 */
	private void selectWriter() {
		System.out.println("\n※ 책 저자로 조회 ※\n");		
		
		System.out.print("조회 하려는 책 저자 입력 : ");
		String writer = sc.nextLine();
		
		List<BookDTO> searchList = service.selectWriter(writer);
		
		System.out.println(); 
		
		if (searchList.isEmpty()) {
			System.out.println("*** 조회 결과가 없습니다 ***");
			return;
		}
		
		for (BookDTO book : searchList) System.out.println(book);
		
	}
	
	/**
	 * 검색할 가격의 범위 (최소값, 최대값) 을 입력 받아
	 * 가격 범위 내의 모든 책을 조회하여 출력
	 * 단 없으면 "조회 결과가 없습니다" 출력
	 */
	private void selectPrice() {
		System.out.println("\n※ 책 가격으로 조회 ※\n");
		
		System.out.print("책 최소 가격 입력 : ");
		int minPrice = sc.nextInt();
		
		System.out.print("책 최대 가격 입력 : ");
		int maxPrice = sc.nextInt();
		
		List<BookDTO> searchList = service.selectWriter(minPrice, maxPrice);
		
		System.out.println(); // 줄바꿈
		
		if (searchList.isEmpty()) {
			System.out.println("*** 조회 결과가 없습니다 ***");
			return;
		}
		
		for (BookDTO book : searchList) System.out.println(book);
	}
	
	/**
	 * (제목 저자 가격) 책 객체 생성해서 추가
	 */
	private void addBook() {
		System.out.println("\n※ 책 추가하기 ※\n");
		
		System.out.print("책 제목 입력 : ");
		String title = sc.nextLine();
		
		System.out.print("책 저자 입력 : ");
		String writer = sc.nextLine();
		
		System.out.print("책 가격 입력 : ");
		int price = sc.nextInt();
		
		if (service.addBook(new BookDTO(title, writer, price))) {
			System.out.println("*** 추가 되었습니다 ***");
		} else { // 실행 안됨!!! 무조건 true
			System.out.println("*** 문제 발생 ***");
		}
		
		
	}
	
	/**
	 * 인덱스 번호를 입력 받아
	 * 1) 일치하는 인덱스가 있으면 bookList 에서 제거 후
	 * "책 제목" 책이 목록에서 제거 되었습니다
	 * 
	 * 
	 * 2) 일치하는 인덱스가 없으면
	 * "해당 인덱스에 존재하는 책이 없습니다" 출력
	 */
	private void removeBook() {
		System.out.println("\n※ 책 추가하기 ※\n");
		
		System.out.print("제거 하려는 책 index 입력 : ");
		int index = sc.nextInt();
		
		String result = service.removeBook(index);
		
		if (result == null) {
			System.out.println("*** 해당 index 에 존재하는 책이 없습니다 ***");
			return;
		}
		
		System.out.printf("[%s] 책이 목록에서 제거 되었습니다\n", result);
		
	}

	/**
	 * index 값을 입력받아 
	 * 해당 index에 책이 존재하지 않으면
	 * -> "해당 인덱스에 책이 존재하지 않습니다" 출력 후 메서드 종료
	 * 
	 * 해당 index에 책이 존재하면
	 * -> 수정할 가격을 입력 후 수정
	 * -> "[책제목] 가격이 (이전 가격) -> (새 가격) 수정되었습니다 
	 */
	private void updateBook() {
		System.out.println("\n※ 책 수정하기 (가격) ※\n");
		
		System.out.print("수정 하려는 책 index 입력 : ");
		int index = sc.nextInt();
		
		// ex) index가 0인 경우
		// BookServie의 bookList.get(0) 에 저장된 주소와
		// 아래 book에 저장된 주소가 "같음"
		BookDTO book = service.selectIndex(index);
		
		if (book == null) {
			System.out.println("*** 해당 index 에 존재하는 책이 없습니다 ***");
			return;
		}
		
		System.out.print("수정 하려는 책 가격 입력 : ");
		int price = sc.nextInt();
		
		int before = book.getPrice();
		
		book.setPrice(price);
		
		System.out.printf("[%s] 가격이 (%d) -> (%d) 수정되었습니다\n", 
						   book.getTitle(), before, book.getPrice());
	}

}



























