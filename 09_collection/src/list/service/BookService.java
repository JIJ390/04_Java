package list.service;

import java.util.ArrayList;
import java.util.List;
import list.dto.BookDTO;

// Service : 기능(비즈니스 로직) 제공용 클래스
public class BookService {

//	BookDTO 객체 참조 변수만을 저장하는
//	ArrayList 객체 bookList 생성
//	-> <BookDTO> == 제네릭(타입 제한) 컴파일 단계에서 강력한 타입 제한
	
	private List<BookDTO> bookList = new ArrayList<BookDTO>();
	
	public BookService() {
		bookList.add(new BookDTO("자바 프로그래밍 입문", "박은종", 25000));
		bookList.add(new BookDTO("선재 업고 튀어 대본집 세트", "이시은", 45000));
		bookList.add(new BookDTO("THE MONEY BOOK", "토스", 19800));
		bookList.add(new BookDTO("자바의 정석", "남궁성", 35000));
		bookList.add(new BookDTO("눈물의 여왕 대본집 세트", "박지은", 60000));
		bookList.add(new BookDTO("삼국지 전권 세트", "이문열", 300000));
		
	}

	/**
	 * bookList 를 반환하는 서비스 메서드
	 * @return bookList
	 */
	public List<BookDTO> selectAll() {
		return bookList;
	}

	/**
	 * bookList에 전달받은 index 가 존재하면 
	 * 해당 index 번째 요소(BookDTO) 반환
	 * 없으면 null 반환 
	 * @param index
	 * @return BooKDTO 또는 null 
	 */
	public BookDTO selectIndex(int index) {
		if (index < 0 || index >= bookList.size()) return null;
		return bookList.get(index);
	}

	/**
	 * bookList 요소의 제목 중 
	 * 전달 받은 title이 포함된 책을 모두 반환
	 * @param title
	 * @return searchList
	 */
	public List<BookDTO> selectTitle(String title) {
		
		List<BookDTO> searchList = new ArrayList<BookDTO>();
		
		for (BookDTO book : bookList) {	
			if (book.getTitle().contains(title)) searchList.add(book);
			// 책 제목이 title을 포함하고 있을 때 searchList 에 저장
		}
		
		return searchList;
	}

	public List<BookDTO> selectWriter(String writer) {
		
		List<BookDTO> searchList = new ArrayList<BookDTO>();
		
		for (BookDTO book : bookList) {	
			if (book.getWriter().contains(writer)) searchList.add(book);
		}
		
		return searchList;
	}

	/**
	 * 가격 범위 내 모든 책을 찾아서 반환
	 * @param minPrice
	 * @param maxPrice
	 * @return
	 */
	public List<BookDTO> selectWriter(int minPrice, int maxPrice) {
		List<BookDTO> searchList = new ArrayList<BookDTO>();
		
		for (BookDTO book : bookList) {	
			int price = book.getPrice();
			if (price <= maxPrice && price >= minPrice) {
				searchList.add(book);
			}
		}
		
		return searchList;
	}

	/**
	 * 전달받은 newBook 을 bookList 에 추가
	 * @param newBook
	 * @return true (List의 add() 구문은 무조건 성공하기 때문에
	 */
	public boolean addBook(BookDTO newBook) {
		return bookList.add(newBook);
	}

	/**
	 * 
	 * @param index
	 * @return
	 */
	public String removeBook(int index) {
		if (index < 0 || index >= bookList.size()) return null;
		
		return bookList.remove(index).getTitle();
//		* method chaining(연쇄) : 메서드의 결과(반환값) 을 이용해 다른 메서드를 호출
	}
	
//	/**
//	 * 
//	 * @param index
//	 * @param price
//	 * @return
//	 */
//	public String updateBook(int index, int price) {
//		if (index < 0 || index >= bookList.size()) return null;
//		
//		String  title   = bookList.get(index).getTitle();
//		String  writer  = bookList.get(index).getWriter();
//		
//		BookDTO newBook = new BookDTO(title, writer, price);
//		
//		return bookList.set(index, newBook).getTitle();
//	}
//	
}


































