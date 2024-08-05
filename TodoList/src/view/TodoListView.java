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
			br      = new BufferedReader(new InputStreamReader(System.in));
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
				case 1 : fullView();     break;
				case 2 : detailView();   break;
				case 3 : addTodo();      break;
				case 4 : completeTodo(); break;
				case 5 : updateTodo();   break;
				case 6 : deleteTodo();   break;
				case 0 : System.out.println("\n프로그램 종료"); return;
				default : System.out.println("\n### 메뉴에 작성된 번호만 입력 해주세요 ###");
				}
				
			} catch (NumberFormatException e) {
				System.out.println("\n### 숫자만 입력해 주세요 ###");
				input = -1;
			} catch (IndexOutOfBoundsException e) {
				e.printStackTrace();
				System.out.println("\n### 입력한 인덱스 번호에 할 일(Todo)가 존재하지 않습니다 ###");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("=====================================================================");
		}
		
	}
	
	private int selectMenu() throws IOException {
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
	
//	[1] 전체 조회
	private void fullView() {
		System.out.println(service.fullView());
	}
	
//	[2] 상세 보기
	private void detailView() throws IOException {
		System.out.println("\n===============[2. Todo Detail View]===============\n");
		System.out.print("인덱스 번호 입력 : ");
		System.out.println(service.detailView(Integer.parseInt(br.readLine())));
	}
	
//	[3] 할 일 추가
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
		
		System.out.printf("[%d] 인덱스에 추가 되었습니다\n", service.addTodo(title, sb.toString()));
		
	}
	
//	[4] 할 일 완료 전환
	private void completeTodo() throws IOException {
		
		System.out.println("\n===============[4. Todo Complete]===============\n");
		
		System.out.print("O <-> X 변경할 인덱스 번호 입력 : ");
		service.completeTodo(Integer.parseInt(br.readLine()));
		
		System.out.println("[변경 되었습니다]");
	}
	
//	[5] 할 일 수정
	private void updateTodo() throws IOException {
		
		System.out.println("\n===============[5. Todo Update]===============\n");
		
		System.out.print("수정할 To do인덱스 번호 입력 : ");
		int index = Integer.parseInt(br.readLine());
		
		String str = service.detailView(index);
		
		System.out.println("@@@@@@@@@@@[수정 전]@@@@@@@@@@@@@@@");
		System.out.println(str);
		System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
		
		System.out.print("수정할 제목 : ");
		String title = br.readLine();
		
		System.out.println("수정할 세부 내용 작성 (입력 종료 시 !wq 작성 후 엔터");
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
		
		service.updateTodo(title, sb.toString(), index);
		System.out.println("[수정 되었습니다]");
		
	}
	
//	[6] 할 일 삭제
	private void deleteTodo() throws IOException {
		System.out.println("\n===============[6. Todo Delete]===============\n");
		
		System.out.print("삭제할 인덱스 번호 입력 : ");
		service.deleteTodo(Integer.parseInt(br.readLine()));
		
		System.out.println("[삭제 되었습니다]");
	}

}
