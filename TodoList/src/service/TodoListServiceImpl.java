package service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import dao.TodoListDao;
import dao.TodoListDaoImpl;
import dto.Todo;


public class TodoListServiceImpl implements TodoListService{
	
	private TodoListDao dao = null;

	public TodoListServiceImpl () throws FileNotFoundException,
			                             ClassNotFoundException, 
			                             IOException {
		dao = new TodoListDaoImpl();
	}
	
	@Override
	public String formatDate(LocalDateTime regDate) {
		return regDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}
	
	@Override
	public String fullView() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("\n===============[1. Todo List Full View]=============\n");
		
		List<Todo> todoList = dao.getTodoList();
		
		int countComplete = 0;
		int allTodo       = todoList.size();
		
		for (Todo todo : todoList) if (todo.isComplete()) countComplete++;
		
		sb.append(String.format("[ 완료된 Todo 개수 / 전체 Todo 수 : %d / %d ]\n", countComplete, allTodo));
		
		sb.append("--------------------------------------------------------------------\n");
		sb.append(String.format("%3s %15s %15s %10s \n", "인덱스", "등록일", "완료여부", "할 일 제목"));
		sb.append("--------------------------------------------------------------------\n");
		
		for (Todo todo : todoList) {

			sb.append(String.format("[%3s] %25s     (%c)       %-11s \n", 
							todoList.indexOf(todo), formatDate(todo.getRegDate()),
							todo.isComplete() ? 'O' : 'X', todo.getTitle()));
		}

		return sb.toString();
	}
	
	@Override
	public String detailView(int index) {
		
		Todo todo = dao.getTodoList().get(index);
		
		StringBuilder sb = new StringBuilder();
	
		sb.append("--------------------------------------------\n");			
		sb.append("제목 : ");
		sb.append(todo.getTitle());
		sb.append("\n등록일 : ");
		sb.append(formatDate(todo.getRegDate()));
		sb.append("\n완료 여부 : ");
		sb.append(todo.isComplete() ? 'O' : 'X');
		sb.append("\n\n[세부 내용]\n");
		sb.append("--------------------------------------------\n");
		sb.append(todo.getDetail());
		
		return sb.toString();
	}

	@Override
	public int addTodo(String title, String detail) throws IOException {
		
		List<Todo> todoList = dao.getTodoList();
		
		Todo todo = new Todo(title, detail, false, LocalDateTime.now());
		
		todoList.add(todo);
		
		dao.saveFile();
		
		return todoList.indexOf(todo);
	}
	
	@Override
	public void completeTodo(int index) throws IOException {
		
		Todo todo = dao.getTodoList().get(index);
		
		todo.setComplete(!todo.isComplete());
		
		dao.saveFile();
	}
	
	@Override
	public void updateTodo(String title, String detail, int index) throws IOException {
		
		Todo todo = dao.getTodoList().get(index);
		
		todo.setTitle(title);
		todo.setDetail(detail);
		
		dao.saveFile();
		
	}

	@Override
	public void deleteTodo(int index) throws IOException {
		dao.getTodoList().remove(index);
		dao.saveFile();
	}
	
}
