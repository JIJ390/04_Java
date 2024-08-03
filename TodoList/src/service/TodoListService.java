package service;

import java.io.IOException;
import java.util.List;

import dto.Todo;

public interface TodoListService {

	int addTodo(String title, String sb) throws IOException;

	List<Todo> getTodoList();

	String detailView(int index);

	void completeTodo(int index) throws IOException;

	void updateTodo(String title, String sb, int index) throws IOException;

	void deleteTodo(int index);


}
