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
	public int addTodo(String title, String sb) {
		
		List<Todo> todoList = dao.getTodoList();
		LocalDateTime regDate = LocalDateTime.now();
		
		Todo todo = new Todo(title, sb, false, regDate);
		
		todoList.add(todo);
		
		return todoList.indexOf(todo);
	}

}
