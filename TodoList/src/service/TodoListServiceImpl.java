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
	public List<Todo> getTodoList() {
		return dao.getTodoList();
	}
	
	@Override
	public String detailView(int index) {
		
		List<Todo> todoList = dao.getTodoList();
		
		Todo todo = todoList.get(index);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = todo.getRegDate().format(formatter);
		
		char complete;
		
		if (todo.isComplete()) complete = 'O';
		else                   complete = 'X';
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("--------------------------------------------\n");
		sb.append("제목 : " + todo.getTitle() + "\n");
		sb.append("등록일 : " + formattedDateTime + "\n");
		sb.append("완료 여부 : " + complete + "\n");
		sb.append("\n");
		sb.append("[세부 내용]\n");
		sb.append("--------------------------------------------\n");
		sb.append(todo.getDetail());
		
		return sb.toString();
	}

	@Override
	public int addTodo(String title, String sb) throws IOException {
		
		List<Todo> todoList = dao.getTodoList();
		LocalDateTime regDate = LocalDateTime.now();
		
		Todo todo = new Todo(title, sb, false, regDate);
		
		todoList.add(todo);
		
		dao.saveFile();
		
		return todoList.indexOf(todo);
	}
	
	@Override
	public void completeTodo(int index) throws IOException {
		List<Todo> todoList = dao.getTodoList();
		
		Todo todo = todoList.get(index);
		
		boolean before = todo.isComplete();
		
		if (before) todo.setComplete(false);
		else        todo.setComplete(true);
		
		dao.saveFile();
	}
	
	@Override
	public void updateTodo(String title, String sb, int index) throws IOException {
		
		Todo todo = dao.getTodoList().get(index);
		
		todo.setTitle(title);
		todo.setDetail(sb);
		
		dao.saveFile();
		
	}

	@Override
	public void deleteTodo(int index) {
		dao.getTodoList().remove(index);
	}
	
}
