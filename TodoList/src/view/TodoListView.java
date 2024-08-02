package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListView {
	
	private TodoListService service = null; 
	private BufferedReader  br      = null;
	
	public TodoListView() {
		try {
			service = new TodoListServiceImpl();
			br = new BufferedReader(new InputStreamReader(System.in));
		} catch (Exception e) {
			
			System.out.println("*** 프로그램 실행 중 오류 발생 ***");
			e.printStackTrace();
			
			System.exit(0);		
		}
	}
	
	public void mainMenu() {
		int input = 0;
		
		while (true) {
			try {
				input = selectMenu();
				
				switch (input) {
				case 1 : break;
				case 2 : break;
				case 3 : addTodo(); break;
				case 4 : break;
				case 5 : break;
				case 6 : break;
				case 0 : System.out.println("프로그램 종료"); return;
				default : System.out.println("\n### 메뉴에 작성된 번호만 입력 해주세요 ###");
				}
				
			} catch (NumberFormatException e) {
				System.out.println("\n### 숫자만 입력해 주세요 ###");
				input = -1;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		
	}
	
	private int selectMenu() throws NumberFormatException, IOException {
		System.out.println("\n===== Todo List =====\n");
		System.out.println("1. Todo List Full View");
		System.out.println("2. Todo Detail View");
		System.out.println("3. Todo Add");
		System.out.println("4. Todo Complete");
		System.out.println("5. Todo Update");
		System.out.println("6. Todo Delete");
		System.out.println("0. EXIT");
		
		System.out.print("select menu number >>> ");
		return Integer.parseInt(br.readLine());
		
	}
	
	private void addTodo() throws IOException {
		System.out.println("\n===============[3. Todo Add]===============\n");
		
		System.out.print("할 일 제목 입력 : ");
		String title = br.readLine();
		
		System.out.println("세부 내용 작성 (입력 종료 시 !wq 작성 후 엔터");
		System.out.println("-----------------------------------------------");
		
		StringBuilder sb = new StringBuilder();
		String input;
		
		while (true) {
			
			input = br.readLine();
			if (input.equals("!wq")) break;
				
			sb.append(input);
			sb.append("\n");
			
		} 
		
		System.out.println("-----------------------------------------------");
		
//		인덱스 추가 메서드
		
		int index = service.addTodo(title, sb.toString());
		
		System.out.printf("[%d] 인덱스에 추가 되었습니다\n", index);
		System.out.println("=====================================================================");
		
	}

}





























